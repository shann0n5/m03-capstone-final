<template>
  <div class="management-action-boards">
    <div class="available-properties-board" v-for="property in $store.state.properties" v-bind:key="property.propertyId" v-on:click="viewpropertytDetails(propertyId)">
    <h2>Available Property</h2>
    
    </div>
    <div class="occupied-properties-board" v-for="property in $store.state.properties" v-bind:key="property.propertyId" v-on:click="viewpropertytDetails(propertyId)">
    <h2>Occupied Properties</h2>
    
    
  </div>
  </div>
</template>

<script>
export default {
props: ['propertyId']
}
</script>

<style>

</style>