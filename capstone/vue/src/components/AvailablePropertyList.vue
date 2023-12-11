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
 import PropertyContainer from './PropertyContainer.vue';

export default {
  
  components: { PropertyContainer },
  methods: {
    viewPropertyDetails(property) {
      this.$router.push({ name: 'propertyDetails', params: { propertyId: property.propertyId }});
    }
  },
  computed: {
    availableProperties() {
        return this.$store.state.properties.filter((property)=> {
            return property.isAvailable == true;
        });
    }
}
}
</script>

<style>

</style>