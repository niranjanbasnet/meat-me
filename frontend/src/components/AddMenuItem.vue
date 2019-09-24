<template>
  <div class="addmenu">
    Add Menu
    <b-form @submit="onSubmit" @reset="onReset">
      Menu Item Name:<b-form-input v-model="textmenuitemname" placeholder="Enter your menu item name"> </b-form-input>
      Add description:<b-form-input v-model="textdescription" placeholder="Enter your description"></b-form-input>
      Add price:<b-form-input v-model="textprice" placeholder="Enter your price"></b-form-input>
      <br>
       <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
  </div>
</template>

<script>
export default {
  name: 'AddMenu',
  props: {
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
