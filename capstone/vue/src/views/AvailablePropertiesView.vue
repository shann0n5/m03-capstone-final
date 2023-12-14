<template>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <header>Search Rentals</header>
  <div class="search-properties-form">
    <search-rentals-form />
  
</div>
  
</template>

<script>
import SearchRentalsForm from '../components/SearchRentalsForm.vue';
// import PropertyService from '../services/PropertyService';

export default {
  components: { SearchRentalsForm },
  data() {
  return {
      properties : []
  }
  },
  // methods: {
  //   getProperties() {
  //             PropertyService.getProperties().then(response => {
  //                 this.$store.state.commit('SET_PROPERTIES', response.data);
  //                 this.properties = this.$store.state.properties;
  //             })
  //         },
  // },
  // created() {
  //     this.getProperties(); 
  // }
}
</script>

<style>

</style>
