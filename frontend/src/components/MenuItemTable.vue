<template>
  <div class="menuList">
   List of menu items
  <div>
    Menu Item Data
    <b-table v-if="getmenudata=true" :items="localMenuData"></b-table>
  </div>
  </div>
  
</template>

<script>

import axios from 'axios';

export default {
  name: 'menuList',
  props: {
  },
  data() {
    return { 
      textmenuitemname: "",
      textdescription: "",
      textprice: "",
      getmenudata: false,
      localMenuData=[]
    }},
    methods: {
      sendMenuData: function() {
        console.log("Sending data");
        var menuitemdata = {
          menuitemname: this.textmenuitemname,
          description: this.textdescription,
          price: this.textprice
        }
        console.log("MENU DATA is ", menuitemdata)
        axios
            .post('menuitem/addnewitem', menuitemdata)
            .then((response) => {
              console.log(response)
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
               
            })
            .catch(error => {
                console.log("Error getting data", error);

            })


      }
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
</style>
