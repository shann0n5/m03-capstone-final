<template>

  <header>Welcome</header>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'serviceRequest' }">Search Properties</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'addProperty' }">Add New Property</router-link>
  <available-property-list />
  <occupied-property-list />



  <!-- ,
  {
    path: '/search-properties',
    name: 'propertySearch',
    component: PropertySearchView,
    meta: {
      requiresAuth: false
    }
  }, 
import PropertySearchView from '../views/PropertySearchView.vue';
-->



</template>

<script>
import AvailablePropertyList from '../components/AvailablePropertyList.vue';
import OccupiedPropertyList from '../components/OccupiedPropertyList.vue';

import PropertyService from '../services/PropertyService';

export default{
 
  // props: ['properties'],
  // data() {
  //   return {
  //     list: {title: '', properties: [] } 
  //   };
    
  // },

  components: { AvailablePropertyList, OccupiedPropertyList },

  //   computed: {
  //     vacant() {
  //       return this.list.properties.filter(property => property.isAvailable == true); 
  //     },
  //     occupied() {
  //       return this.list.properties.filter(property => property.isAvailable == false);
  //     }
  //   },
  // created() {
  //   PropertyService.getAllMyProperties().then(response => {
  //     this.$store.commit('SET_PROPERTIES', response.data);
  //     alert('Created executed')
  //   }).catch(error => {
  //     if (error.response && error.response.status === 404) {
  //       this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
  //     }
  //   });
  // },
  // created() {
  //   PropertyService.getAllMyProperties().then(response => {
  //     this.properties = response.data;
  //     alert('Created executed')
  //   }).catch(error => {
  //     if (error.response && error.response.status === 404) {
  //       this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
  //     }
  //   });
  // },
    
}
</script>

<style>
.btn-submit {
  color: rgba(255, 255, 255, 0.87);
  background-color: #43677c;
  border-color: #43677c;
  text-decoration: none;
  padding: 6px 12px;
  cursor: pointer;
}
</style>