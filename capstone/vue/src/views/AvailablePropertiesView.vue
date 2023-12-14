<template>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <h2>Search Rentals</h2>
  <div class="search-properties-form">
    <search-rentals-form class="form"/>
  
</div>
  
</template>

<script>
import SearchRentalsForm from '../components/SearchRentalsForm.vue';

export default {
  components: { SearchRentalsForm },
  data() {
  return {
      properties : []
  }
  },
}
</script>

<style scoped>
h2{
  display: flex;
 justify-content: center;
 padding-bottom: 20px;
}
.form{
  display: flex;
  justify-content: center;
}


</style>
