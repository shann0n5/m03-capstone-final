<template>
  <section>
    <h2>Availability Properties </h2>
    <div class="availability-properties">
    <property-container v-for="property in availableProperties" v-bind:property="property" v-bind:key="property.propertyId"  v-bind:enable-add="false" />
    
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
.available-property{
    display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  background-color: #6f828e;
  border-radius: 20px;
  padding: 0 20px 20px 20px;
}
</style>