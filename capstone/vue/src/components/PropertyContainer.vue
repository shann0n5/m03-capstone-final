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
  {
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
.property-container{
    display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  background-color: #a0bdcc;
  border-radius: 500px;
  padding: 0 20px 20px 20px;
  margin-bottom: 20px;
  width: 500px;
}
</style>