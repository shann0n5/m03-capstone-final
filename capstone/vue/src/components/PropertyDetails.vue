<template>
  <div class="property-details-section">
    <div class="property-details"   >
  <!-- <property-container v-bind:property="property" v-for="property in this.$store.state.properties" v-bind:key="property.propertyId" v-for="property in $store.state.properties" v-bind:key="property.propertyId"/> -->
      <header class="header">Property: {{ property.propertyId }} </header>
            
      <h2> Property Manager Id: {{ property.managerId }}</h2>
        <div>Property Address: {{ property.address }}</div> 
        <div>Number of Rooms: {{ property.numberOfRooms }}</div>
        <div>Is property available? {{ property.isAvailable }}</div> 
      <div class="occupied-button-container" v-if="! enableAdd">
          <button class="mark-occupied" v-on:click.prevent="setOccupied(true)" v-if="! property.isAvailable">Set Property to Occupied</button>
          <button class="mark-unoccupied" v-on:click.prevent="setOccupied(false)" v-if=" property.isAvailable">Unset Property as Occupied</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  
  props: ['card']
  // {
  //   property: Object,
  //   enableAdd: {
  //     type:Boolean,
  //     default:false
  //   }
  // } 
  ,
  methods: {
        setOccupied(value) {
            this.$store.commit('SET_AVAILABILITY_STATUS', { property: this.property, value: value });
        }
}
}

</script>

<style>

</style>