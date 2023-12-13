<template>
  <section>
    <h2>Occupied Properties</h2>
    <div class="occupied-properties">
    <property-container v-for="property in occupiedProperties" v-bind:property="property" v-bind:key="property.propertyId" v-bind:enable-add="true" />

    </div>
  </section>
</template>

<script>
import PropertyContainer from './PropertyContainer.vue'
 import PropertyService from '../services/PropertyService';

export default {
  components: { PropertyContainer },
computed: {
    occupiedProperties(){
        return this.$store.state.myProperties.filter((property)=>{
            return property.available === false;
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