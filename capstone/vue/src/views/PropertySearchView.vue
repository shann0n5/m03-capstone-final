<template>
  <router-link class="btn btn-submit" v-bind:to="{ name: 'propertyManagerMainPage' }">Back</router-link>
  <header>Search Properties</header>
  <div class="search-properties-form">
    <property-search-form v-bind:properties="properties"/>
  </div>
</template>

<script>
import PropertySearchForm from '../components/PropertySearchForm.vue';

export default {
  components: { PropertySearchForm },
  data() {
    return {
       properties : []
    }
  },
}
</script>

<style>

</style>
