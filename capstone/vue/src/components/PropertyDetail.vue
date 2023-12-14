<template>
    <div class="property-details-section">
      <div class="property-details"   >
    <!-- <property-container v-bind:property="property" v-for="property in this.$store.state.properties" v-bind:key="property.propertyId" v-for="property in $store.state.properties" v-bind:key="property.propertyId"/> -->
        <h1 class="header">Property: {{ property.propertyId }} </h1>
        
        <h2> Property Manager Id: {{ property.managerId }}</h2>
          <div>Property Address: {{ property.address }}</div> 
          <div>Number of Rooms: {{ property.numberOfRooms }}</div>
          <div>Is property available? {{ property.available }}</div> 
        <div class="occupied-button-container" v-if="! enableAdd">
            <button class="mark-occupied" v-on:click.prevent="setOccupied(true)" v-if="! property.available">Set Property to Occupied</button>
            <button class="mark-unoccupied" v-on:click.prevent="setOccupied(false)" v-if=" property.available">Unset Property as Occupied</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  
  export default {
    
    props: ['property']
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
  },
    created(){
      if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
        this.$store.commit('SET_SHOW_MANAGER_POV', true);
      }
    }
  }
  
  </script>
  
  <style>
  
  </style>