<template>
    <div>

      <b-modal id="modal-1" title="Add New Order" @ok="submitOrder">
          <addorderitem></addorderitem>
      </b-modal>

      <b-modal id="modal-2" title="Order Preview" @ok="saveOrder">
          <tableoverview></tableoverview>
      </b-modal>

      <button class="tablink" @click="openPage('Contact',this,'white')">Restaurant Setup</button>
      <button class="tablink" @click="openPage('Home', this, 'green')">Menu Settings</button>
      <button class="tablink" @click="openPage('News', this, 'red')" id="defaultOpen">Table Settings</button>
      <button class="tablink" @click="openPage('About', this, 'red')">Calculate Orders</button>

      <div id="Home" class="tabcontent">
        <menusettings></menusettings>
      </div>

     <div id="News" class="tabcontent">
        <addtable></addtable>
      </div>

      <div id="Contact" class="tabcontent">
        
          <restaurantsetup></restaurantsetup>
  
      </div>

      <div id="About" class="tabcontent">
        <h3>About</h3>
        <p>Who we are and what we do.</p>
      </div> 
          </div>
    
</template>

<script>

import menusettings from "@/components/AddMenuItem";
import addtable from "@/components/AddTable"
import tableoverview from "@/components/TableOverview"
import restaurantsetup from "@/components/RestaurantSetup";
import addorderitem from "@/components/AddOrderItem";
import { eventBus } from "@/main.js";


export default {
  name: 'Dashboard',
  components: {
    menusettings,
    addtable,
    restaurantsetup,
    addorderitem,
    tableoverview
    },
  props: {
    
  },
  methods: {

  submitOrder: function() {
    console.log("Submitted")
    eventBus.$emit("submitOrder", "");
  },

  openPage(pageName,elmnt,color) {
    // console.log("PARA IS ", pageName,elmnt,color);
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
  document.getElementById("defaultOpen").click();
}

// Get the element with id="defaultOpen" and click on it
//document.getElementById("defaultOpen").click();

}}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* Set height of body and the document to 100% to enable "full page tabs" */
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial;
}

/* Style tab links */
.tablink {
  background-color: #555;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 25%;
}

.tablink:hover {
  background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
  color: white;
  display: none;
  padding: 100px 20px;
  height: 100%;
}

#Home {background-color: green;}
#News {background-color: red;}
#Contact {background-color: blue;}
#About {background-color: orange;}


</style>
