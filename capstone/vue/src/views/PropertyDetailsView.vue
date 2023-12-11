<template>
 <header>Property:</header>
 <div class="back-to-management-home">
  
  <router-link v-bind:to="{name:'propertyManagerMainPage'}">Back to Property Manager Home</router-link>
 </div>
  <div class="property-details">
<property-detail  v-bind:property="property"

/>
  </div>
  
</template>

<script>
import PropertyDetail from '../components/PropertyDetail.vue';
import PropertyService from '../services/PropertyService';

export default {
components: {PropertyDetail},
data() {
  return {
    property: {
      propertyId: '',
      managerId: '',
      address: '',
      numberOfRooms: '',
      rent: '',
      isAvailable: ''
    }
  };
},
created() {
    PropertyService.getPropertyById(this.$route.params.propertyId).then(response => {
      this.property = response.data;
    });
  }
}
</script>

<style>

</style>