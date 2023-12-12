<template>
  <div class="property-container" >
   <h2 ><router-link v-bind:to="{name: 'propertyDetails', params: { propertyId: property.propertyId }}" >
        Property: {{ property.propertyId }}
      </router-link> </h2> 
    <p></p>
    <div class="button-container" > 
       
    <button v-if="! enableAdd" v-on:click.prevent="addToOccupiedList(property)">Add to Occupied Property List  </button>
    </div>

  </div>
</template>

<script>

export default {
  props: 
  // ['title','properties']
  // ['property']
  {
    property: Object,
    enableAdd: {
        type: Boolean,
        default: false
    }
}
,
methods: {
    // openPropertyDetails() {
    //     this.$router.push({name: 'propertyDetails', params: {propertyId: this.$store.state.properties.propertyId}})
    // v-on:click="openPropertyDetails()"
    // },
    addToOccupiedList(property) {
        let addedProperty = Object.assign({isAvailable: false }, property);
        this.$store.commit('SAVE_PROPERTY', addedProperty)
    }
}

}
</script>

<style>
.property-container{
    display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  background-color: #8c979d;
  border-radius: 500px;
  padding: 0 20px 20px 20px;
}
</style>