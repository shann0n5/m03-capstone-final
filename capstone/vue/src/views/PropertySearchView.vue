<template>
    <header>Search Properties</header>
    <router-link class="btn btn-submit" v-bind:to="{ name: 'addProperty' }">Back</router-link>
  <div class="search-properties-form">
    <property-search-form />
    
  </div>
</template>

<script>
import PropertySearchForm from '../components/PropertySearchForm.vue';

export default {
  components: { PropertySearchForm },
  data() {
    return {
        
    }
  }

}
</script>

<style>

</style>