<template>
  <div class="tableoverview">
     
       <div class="orderOverview">
         <div><b-button @click="getCurrentTableInformation">Refresh</b-button></div>
        <div>
        <table class="tableOrder">
          <thead>
            <tr>
              <th>Ordered Item</th>
              <th>Status</th>
            </tr> 
          </thead>
          <tbody v-for="chooseItem in localOrderItemList" :key="chooseItem.id">
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
import axios from "axios";

export default {
  name: 'tableoverview',
  components: {},
  props: {
    msg: String
  },
  data() {
    return { 
      selectedTableId: "",
      localOrderItemList: []  
    }},
  methods: {

    getCurrentTableInformation: function() {
      axios
            .get('restauranttable/orderitem/'+this.selectedTableId)
            .then((response) => {
              console.log(response.data[0].menuList)
              this.localOrderItemList = response.data[0].menuList;
              
               console.log("Data out ",this.localOrderItemList)
            })
            .catch(error => {
                console.log("Error pushing data", error);

            })
    },

    removeItem: function(orderid) {

    }

  },

  created() {

     eventBus.$on("getCurrentOrder", (tableid) => {
      console.log("Listening to current order "+ tableid);
      this.selectedTableId = tableid;
      console.log("Saving ", this.selectedTableId);
      this.getCurrentTableInformation();
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
  border: 2px solid red;
  padding: 50px;
  margin: 20px;
}
</style>
