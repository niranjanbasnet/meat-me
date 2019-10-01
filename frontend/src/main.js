import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import axios from 'axios'
import router from './router'

Vue.use(BootstrapVue)
Vue.use(axios)
Vue.config.productionTip = false
axios.defaults.baseURL = "http://localhost:8080/"

export const eventBus = new Vue();

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
