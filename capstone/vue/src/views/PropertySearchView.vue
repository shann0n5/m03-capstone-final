<template>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'propertyManagerMainPage' }">Back</router-link>
  <header>Search Properties</header>
    
  <div class="search-properties-form">
    <property-search-form v-bind:properties="properties"/>
    
  </div>
</template>

<script>
import PropertySearchForm from '../components/PropertySearchForm.vue';
// import PropertyService from '../services/PropertyService';

export default {
  components: { PropertySearchForm },
  data() {
    return {
       properties : []
    }
  },
  // methods: {
  //   getMyProperties() {
  //             PropertyService.getAllMyProperties().then(response => {
  //                 this.$store.state.commit('SET_MY_PROPERTIES', response.data);
  //                 this.properties = this.$store.state.myProperties;
  //             })
  //         }, 
  // },
  // created() {
  //         this.getMyProperties();

  // }
}
</script>

<style>

</style>
