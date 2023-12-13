<template>

  <header>Welcome</header>
   <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'propertySearch' }">Search Properties</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link>
  <router-link class="btn btn-submit" v-bind:to="{name: 'application'}">See Applications</router-link>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'addProperty', params: {propertyId: 0 } }">Add New Property</router-link>
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
  color: rgba(25, 27, 29, 0.87);
  background-color: #b7cddb;
  border-color: #43677c;
  text-decoration: none;
  padding: 6px 12px;
  cursor: pointer;
}
.btn-cancel {
  color: rgba(255,255,255,0.7);
  background-color: #b65d65;
  border-color: #b65d65;
  padding: 6px 12px;
}
/* header, footer, nav, main, aside {
        font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        font-size: 24px;
        text-transform: uppercase;
    } */
</style>