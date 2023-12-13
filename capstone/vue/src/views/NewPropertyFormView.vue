<template>
     <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
    <router-link class="btn btn-submit" v-bind:to="{ name: 'propertyManagerMainPage' }">Back to My Properties</router-link>
 <header>Add New Property </header>
<div class="property-form">
  <new-property-form v-bind:property="property"/>
</div>
</template>

<script>
import NewPropertyForm from '../components/NewPropertyForm.vue';

export default {
  components: { NewPropertyForm},
  data() {
    return {
      property: {
        propertyId: 0,
        managerId: '',
        address: '',
        numberOfRooms: '',
        rent: '',
        available: ''
      }
    }
  },
  // created() {
  //   PropertyService.addProperty(this.property).then(response => {
  //     this.property = response.data;
  //   });
  // }

}
</script>

<style>

</style>