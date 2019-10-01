<template>
  <div class="addtable">
     
    <div class="row">
      <div class="col">
      Number of available space:<b-form-input v-model="numberofseats" placeholder="Enter number of seats"></b-form-input>
      <br>
      <br>
      Add table description:<b-form-input v-model="texttabledescription" placeholder="Enter table description"></b-form-input>
    </div>
    </div>
     <br>
     <br>
     <b-button variant="primary" @click="sendTableData">Add Table</b-button> 
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'addtable',
  components: {},
  props: {
    
  },
  data() {
    return { 
      numberofseats: null,
      texttabledescription: "",
      occupied: false
    }},
  methods: {
    sendTableData: function() {
      var restaurantdata = {
        numberofseats: this.numberofseats,
        tabledescription: this.texttabledescription,
        occupied: this.occupied
      }
      console.log("Send table data ",restaurantdata);
      axios
            .post('restauranttable/addnewitem/',restaurantdata)
            .then((response) => {
              console.log(response)
              this.getAllTableData();
               console.log("Added")
            })
            .catch(error => {
                console.log("Error pushing data", error);

            })
    },
    getAllTableData: function() {

      axios
            .get('restauranttable/all')
            .then((response) => {
              console.log(response)
               console.log("Data out")
            })
            .catch(error => {
                console.log("Error pushing data", error);

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

.addtable {
  margin-left: 500px;
  margin-right: 500px;
}

</style>
