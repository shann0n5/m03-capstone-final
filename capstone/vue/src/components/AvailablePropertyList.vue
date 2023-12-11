<template>
  <section>
    <h2>Available Properties </h2>
    <div class="available-properties">
    <property-container v-bind:property="property"  v-for="property in availableProperties"  v-bind:key="property.propertyId"   ></property-container>
 <!--v-on:click="viewPropertyDetails(property)" v-bind:to="{ name: 'propertyDetails', params: {propertyId: property.propertyId}}"-->
  </div>
  </section>
</template>



<script>
 import PropertyService from '../services/PropertyService';
import PropertyContainer from './PropertyContainer.vue';

export default {
  data() {
    return {
      properties: []
    }
  },
  components: { PropertyContainer },
  methods: {
    viewPropertyDetails(property) {
      this.$router.push({ name: 'propertyDetails', params: { propertyId: property.propertyId }});
    },
    getAvailableProperties() {
      PropertyService.getAllMyProperties().then(response => {
        this.properties = response.data;
      });
    }
  },
  computed: {
    availableProperties() {
        return this.$store.state.properties.filter((property)=> {
            return property.isAvailable == true;
        });
    }
    // availableProperties() {
    //     return this.properties.filter((property)=> {
    //         return property.isAvailable == true;
    //     });
    // }
},
// created() {
//   this.this.$store.state.properties;
// }
}
</script>

<style>

</style>