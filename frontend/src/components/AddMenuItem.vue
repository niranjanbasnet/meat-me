<template>
  <div class="addmenu">
    <div class="row">
      <div class="col">
        Add Menu Item
    <b-form>
      Menu Item Name:<b-form-input v-model="textmenuitemname" placeholder="Enter your menu item name"> </b-form-input>
      Add description:<b-form-input v-model="textdescription" placeholder="Enter your description"></b-form-input>
      Add price:<b-form-input v-model="textprice" placeholder="Enter your price"></b-form-input>
      <br>
      Add to Menu:
      <select v-model="selectedmenu" @change="changeData">

        <option :id="item.id" :name="item.id" :key="item.id" v-for="item in menuData" v-bind:value="item.id">{{item.menuname}}</option>
        
      </select>
      <br>
      <br>
       <b-button variant="primary" @click="sendMenuData">Submit</b-button>
       <br>
       <br>
       
    </b-form>
  <br>
  <b-button variant="primary" @click="getMenuData">Get all data</b-button>
  <br>
    <div class="row">
      <div>
        Menu Item Data
        <b-table v-if="getmenudata=true" :items="localMenuData"></b-table>
      </div>
    </div>

      </div>

      <div class="col">
         Add Menu
         <div class="row">
            Add Menu Name:<b-form-input v-model="textmenuname" placeholder="Enter your Menu Name"></b-form-input>
            Add Menu Date:<b-form-input v-model="textmenudate" placeholder="Enter your Menu date"></b-form-input>
            <br>
            <br>
            <b-button variant="primary" @click="sendMenuData1">Submit Menu</b-button>
         </div>
         <br>
         <br>
         <div class="row">
           Choose Menu:
            <select id="dropdown" v-model="selectedmenu" @change="changeData1">

                <option :id="item.id" :name="item.id" :key="item.id" v-for="item in menuData" v-bind:value="item.id">{{item.menuname}}</option>
          
            </select>
           </div>
           <div class="row">
             <div>
                Menu Item Data
                <b-table v-if="getmenudata=true" :items="menuDataTable"></b-table>
              </div>
           </div>
       
      </div>


    </div>
    <br>
    <div class="row">
      <div>Order Food</div>
    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'AddMenu',
  props: {
  },
  data() {
    return { 
      textmenuitemname: "",
      textdescription: "",
      textprice: "",
      textmenuname:"",
      textmenudate:"",
      selectedmenu: "",
      getmenudata: false,
      localMenuData:[],
      menuData: [],
      menuDataTable: []
    }},
    methods: {
      changeData: function () {
        console.log("Selected ", this.selectedmenu);
      },
      changeData1: function () {
        console.log("Selected ", this.selectedmenu);
        this.getMenuDataByMenuId();
      },
      sendMenuData: function() {
        console.log("Sending data");
        var menuitemdata = {
          menuitemname: this.textmenuitemname,
          description: this.textdescription,
          price: this.textprice
        }
        console.log("MENU DATA is ", menuitemdata)
        axios
            .post('menuitem/addnewitem/'+this.selectedmenu, menuitemdata)
            .then((response) => {
              console.log(response)
              this.getAllMenuData();
               console.log("Added")
            })
            .catch(error => {
                console.log("Error pushing data", error);

            })
      },

      sendMenuData1: function() {
        console.log("Sending menu data");
        var menudata = {
          
          menuname: this.textmenuname,
          menudate: this.textmenudate
        }
        console.log("MENU is ", menudata)
        axios
            .post('menu/addnewitem', menudata)
            .then((response) => {
              console.log(response)
              this.getAllMenuData();
               console.log("Added")
            })
            .catch(error => {
                console.log("Error pushing data", error);

            })
      },
      getMenuData: function() {

        this.getmenudata = true;
        axios
            .get('menuitem/all')
            .then((response) => {
              console.log(response)
              this.localMenuData = response.data;
               
            })
            .catch(error => {
                console.log("Error getting data", error);

            })

      },
      getAllMenuData:function() {
        this.getmenudata = true;
        axios
            .get('menu/all')
            .then((response) => {
              
              this.menuData = response.data;
               console.log("THIS", response.data);
               this.menuDataTable = response.data[0].menuitemlist;
               console.log("Menu Table ", this.menuDataTable)
            })
            .catch(error => {
                console.log("Error getting menu data", error);

            })
      },

      getMenuDataByMenuId: function() {
        
        axios
            .get('menu/'+this.selectedmenu)
            .then((response) => {
              console.log(response.data.menuitemlist);
              this.menuDataTable = response.data.menuitemlist;
            })
            .catch(error => {
                console.log("Error getting menu data", error);

            })

      }
    },
    mounted() {
      this.getAllMenuData();
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.addmenu {
  margin-left: 30px;
}
</style>
