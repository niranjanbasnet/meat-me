<template>
  <div class="addorder">
      Restaurant Setup
      <div>
        
        <div class="row">
          <tablecard></tablecard>
       
      </div>
      </div>
      
  </div>
</template>

<script>

import tablecard from "@/components/TableCard";

export default {
  name: 'addorder',
  components: {tablecard},
  props: {
    msg: String
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
