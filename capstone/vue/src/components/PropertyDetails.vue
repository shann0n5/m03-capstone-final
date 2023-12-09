<template>
  <div class="property-container"  v-bind:class="{isAvailable: property.isAvailable}">
<!-- <property-container v-bind:property="property" v-for="property in this.$store.state.properties" v-bind:key="property.propertyId" /> -->
        <header class="header" >Property: {{ property.propertyId }} </header>
          
    <h2>{{ property.managerId }}</h2>
       <div>{{ property.address }}</div> 
       <div>{{ property.numberOfRooms }}</div>
       <div>{{ property.isAvailable }}</div> 
    <div class="occupied-button-container" v-if="! enableAdd">
          <button class="mark-occupied" v-on:click.prevent="setOccupied(true)" v-if="! property.isAvailable">Set Property to Occupied</button>
          <button class="mark-unoccupied" v-on:click.prevent="setOccupied(false)" v-if=" property.isAvailable">Unset Property as Occupied</button>
        </div>
          <button v-if="enableAdd" v-on:click.prevent="addToOccupiedList(property)">Add to Occupied Properties List</button>
      

  </div>
</template>

<script>

export default {
  
  props: ['property'],
    methods: {
        setOccupied(value) {
            this.$store.commit('SET_AVAILABILITY_STATUS', { property: this.property, value: value });
        },
        addToOccupiedList(property) {
            let addedProperty = Object.assign({ isAvailable: false }, property);
            
            this.$store.commit('SAVE_PROPERTY', addedProperty);
        }
    },

}
</script>

<style>

</style>