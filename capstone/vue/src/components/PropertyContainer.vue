<template>
  <div class="property-container">
    <div v-bind:property="property" v-for="property in $store.state.properties" v-bind:key="property.propertyId"> 
      <router-link v-bind:to="{name: 'propertyDetails', params: {propertyId: property.propertyId}}" >
         
    </router-link>
    </div>
   
   
   
    <h2 class="property-id">Property: {{ property.propertyId }} </h2>
    <p></p>
    
    <div class="button-container" > 
    <button v-if="! enableAdd" v-on:click.prevent="addToOccupiedList(property)">Add to Occupied Property List  </button>
    </div>

  </div>
</template>

<script>
export default {
props: {
    property: Object,
    enableAdd: {
        type: Boolean,
        default: false
    }
},
methods: {
    addToOccupiedList(property) {
        let addedProperty = Object.assign({isAvailable: false }, property);
        this.$store.commit('SAVE_PROPERTY', addedProperty)
    }
}

}
</script>

<style>

</style>