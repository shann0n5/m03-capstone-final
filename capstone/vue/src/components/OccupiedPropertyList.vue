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
export default {
  components: { PropertyContainer },
computed: {
    occupiedProperties(){
        return this.$store.state.properties.filter((property)=>{
            return property.isAvailable === false;
        });
    }
}
}
</script>

<style>

</style>