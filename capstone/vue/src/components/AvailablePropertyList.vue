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
    }).catch(error => {
      if (error.response && error.response.status === 404) {
        this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
      }
    });
    if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
      this.$store.commit('SET_SHOW_MANAGER_POV', true);
    }
  }
}
</script>

<style>


</style>