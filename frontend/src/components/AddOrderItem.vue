<template>
  <div class="addorder">
    <button @click="getAllMenu">Refresh</button>
      Choose menu:
      <select v-model="selectedmenu" @change="changeMenu">

        <option :id="item.id" :name="item.id" :key="item.id" v-for="item in menuData" v-bind:value="item.id">{{item.menuname}}</option>
        
      </select>
      <br>
      <br>
      Choose Item:
      <select v-model="selectedmenuitem" @change="changeMenuitem()">

        <option :id="item1.id" :name="item1.id" :key="item1.id" v-for="item1 in menuItemData" v-bind:value="item1">{{item1.menuitemname}}</option>
        
      </select>
      <br>
      <br>

      <b-button @click="sendOrderItemData()">
        Add to order
      </b-button>
      <br>
      <br>

      Order Overview:
      <div class="orderOverview">
        <div>
        <table class="tableOrder">
          <thead>
            <tr>
              <th>Ordered Item</th>
              <th>Status</th>
            </tr> 
          </thead>
          <tbody v-for="chooseItem in localOrderItem" :key="chooseItem.id">
            <tr>
              <td>{{ chooseItem.menuitemname}}</td>
               <td><b-button variant="danger" @click="removeItem(chooseItem)">Remove</b-button></td>
            </tr>
          </tbody>
        </table>
      </div> 
      </div>
       
  </div>
</template>

<script>

import { eventBus } from "@/main.js";
import axios from 'axios';

export default {
  name: 'addorder',
  components: {},
  props: {
    msg: String
  },
  data() {
    return { 
      selectedmenu: "",
      selectedTableId: "",
      selectedmenuitem:{},
      menuData: [],
      menuItemData: [],
      localOrderItem: []
    }},
    methods: {

      getAllMenu: function() {
        console.log("Get");
        axios
            .get('menu/all')
            .then((response) => {
              console.log("Menu data")
              console.log(response.data)
              this.menuData = response.data;

            })
            .catch(error => {
                console.log("Error pushing data", error);

            })

    },

    changeMenu: function() {
      this.getMenuItemsByMenuId();
    },

    changeMenuitem: function() {

    },

    submitOrder: function() {
      console.log("The order list to be sent is ", this.localOrderItem);
      var orderItemList = this.localOrderItem;
      console.log("The selected table id is ", this.selectedTableId);
      axios
            .post('orderItems/addOrder/'+this.selectedTableId, orderItemList)
            .then((response) => {
              console.log("Menu data")
              console.log(response.data)

            })
            .catch(error => {
                console.log("Error pushing data", error);

            })

    },

    sendOrderItemData: function() {
      
      this.localOrderItem.push(this.selectedmenuitem);
      console.log("NEW ORDER LIST IS ", this.localOrderItem);
    },

    getMenuItemsByMenuId: function() {

       axios
            .get('menu/'+this.selectedmenu)
            .then((response) => {
              console.log("Menu data")
              console.log(response.data)
              this.menuItemData = response.data.menuitemlist;

            })
            .catch(error => {
                console.log("Error pushing data", error);

            })

    }

    },

    created() {

      eventBus.$on("prepareorder", (tableid) => {
      console.log("Listening "+ tableid);
      this.selectedTableId = tableid;
      console.log("Saving ", this.selectedTableId);
      this.getAllMenu();
    });

    eventBus.$on("submitOrder", () => {
      this.submitOrder();
    });

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

.orderOverview {
  width: 400px;
  height: 300px;
  border: 2px solid black;
  padding: 50px;
  margin: 20px;
}
</style>
