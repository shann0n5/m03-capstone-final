<template>
  <section>
    <h4>Available Properties </h4>
    <div class="available-properties">
     <property-container v-for="property in availableProperties" v-bind:key="property.propertyId" v-bind:property="property"></property-container> 
  </div>
  </section>
</template>

<script>
import PropertyService from '../services/PropertyService';
import PropertyContainer from './PropertyContainer.vue';

export default {
  components: { PropertyContainer },
  computed: {
    availableProperties() {
        return this.$store.state.myProperties.filter((property)=> {
            return property.available == true;
        });
    }
},
created() {
    PropertyService.getAllMyProperties().then(response => {
      this.$store.commit('SET_MY_PROPERTIES', response.data);
      // alert(response.data[0].propertyId);
    }).catch(error => {
      if (error.response && error.response.status === 404) {
        this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
      }
    });
  }
}
</script>

<style>


</style>