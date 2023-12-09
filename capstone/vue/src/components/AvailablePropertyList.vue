<template>
  <section>
    <h2>Availability Properties </h2>
    <div class="availability-properties">
    <property-container v-bind:property="property"  v-for="property in availableProperties"  v-bind:key="property.propertyId"  v-bind:enable-add="false"/>

  </div>
  </section>
</template>

<script>
import PropertyContainer from './PropertyContainer.vue';
export default {
  components: { PropertyContainer },
computed: {
    availableProperties() {
        return this.$store.state.properties.filter((property)=> {
            return property.isAvailable === true;
        });
    }
}
}
</script>

<style>

</style>