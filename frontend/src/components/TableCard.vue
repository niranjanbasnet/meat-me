<template>
<div class="col-md-6 col-lg-3">
  <div class="tablecard">
     <b-button variant="primary" @click="getAllTableData">Refresh</b-button>
     <br>
     <br>
     <div class="mb-0" v-for="(item,index) in localCards" :key="item.id">
      <b-card
        :title="'Table '+(index+1)"
        tag="article"
        bg-variant="secondary" text-variant="white"
        style="max-width: 20rem;"
        
      >
          <b-card-text>
            Number of customers: {{item.numberofseats}}
            <br>
            Occupied: {{item.occupied}}
          </b-card-text>

          <b-button v-if="item.occupied===false" variant="primary" v-b-modal.modal-1 @click="prepareOrder(item.id)">Order for Table</b-button>
          <b-button variant="primary" v-b-modal.modal-2 @click="getOrder(item.id)">Review Order</b-button>
      </b-card>
  </div>
      <br>
      <br>
  </div>
  </div>
</template>

<script>

import axios from 'axios';
import { eventBus } from "@/main.js";

export default {
  name: 'tablecard',
  components: {},
  props: {
    msg: String
  },
  data() {
    return { 
      localCards: [],
      menus: [],
      menuItems: [],
      selectedMenuId: ""   
    }},
  methods: {
    getAllTableData: function() {

      axios
            .get('restauranttable/all')
            .then((response) => {
              console.log(response)
              this.localCards = response.data;
               console.log("Data out")
            })
            .catch(error => {
                console.log("Error pushing data", error);

            })

    },

    prepareOrder(tableid) {

      console.log("prepare table id ",tableid);
      eventBus.$emit("prepareorder", tableid);

    },

    getOrder: function(tableid) {

      console.log("Get current orders for table id ",tableid);
      eventBus.$emit("getCurrentOrder", tableid);

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

.table-card {
  padding-bottom: 5px;
}

.mb-0 {
  padding-bottom: 20px;
}

</style>
