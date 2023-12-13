<template>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'propertyManagerMainPage' }">Back</router-link>
  <header>Search Properties</header>
    
  <div class="search-properties-form">
    <property-search-form v-bind:properties="properties"/>
    
  </div>
</template>

<script>
import PropertySearchForm from '../components/PropertySearchForm.vue';
import PropertyService from '../services/PropertyService';

export default {
  components: { PropertySearchForm },
  data() {
    return {
        properties : []
    }
  },
  methods: {
    
  }
    // created() {
    //     PropertyService.getProperties().then(response => {
    //         this.properties = response.data;
    //     }).catch(error => {
    //         if (error.response) {
    //             if (error.response.status === 404) {
    //                 this.$store.commit('SET_NOTIFICATION',
    //                 "Error: property was not found.");
    //                 this.$router.push({ name: 'HomeView' });
    //             } else {
    //                 this.$store.commit('SET_NOTIFICATION',
    //                 "Error getting properties. Response received was '" + error.response.statusText + "'.");
    //             }
    //         } else if (error.request) {
    //             this.$store.commit('SET_NOTIFICATION', "Error getting properties. Server could not be reached.");
    //         } else {
    //             this.$store.commit('SET_NOTIFICATION', "Error getting properties. Request could not be created.");
    //         }
    //     });
       
    // }

}
</script>

<style>

</style>
