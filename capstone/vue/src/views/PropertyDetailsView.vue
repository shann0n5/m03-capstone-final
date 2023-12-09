<template>
 <header>Property:</header>
 <div class="back-to-management-home">
  
  <router-link v-bind:to="{name:'propertyManagerMainPage'}">Back to Property Manager Home</router-link>
 </div>
  <div class="property-details">
<property-details  

/>
  </div>
  
</template>

<script>
import PropertyDetails from '../components/PropertyDetails.vue'
export default {
components: {PropertyDetails}
}
</script>

<style>

</style>