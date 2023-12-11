<template>

    <header>Welcome</header>
  <available-property-list />
  <occupied-property-list />

</template>

<script>
import AvailablePropertyList from '../components/AvailablePropertyList.vue';
import OccupiedPropertyList from '../components/OccupiedPropertyList.vue';

import PropertyService from '../services/PropertyService';

export default{
 
  // props: ['properties'],
  data() {
    return {
      properties: []
      
    };
    
  },

  components: { AvailablePropertyList, OccupiedPropertyList },
  // created() {
  //   PropertyService.getAllMyProperties().then(response => {
  //     this.$store.commit('SET_PROPERTIES', response.data);
  //     alert('Created executed')
  //   }).catch(error => {
  //     if (error.response && error.response.status === 404) {
  //       this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
  //     }
  //   });
  // }
}
</script>

<style>

</style>