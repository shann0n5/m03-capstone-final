<template>
  <h2>My Properties</h2>
  <router-link class="btn btn-primary" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <router-link class="btn btn-primary" v-bind:to="{ name: 'propertySearch' }">Search Properties</router-link>
  <!-- <router-link class="btn btn-primary" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link> -->
  <!-- <router-link class="btn btn-primary" v-bind:to="{name: 'application'}">See Applications</router-link> -->
  <router-link class="btn btn-primary" v-bind:to="{ name: 'addProperty', params: {propertyId: 0 } }">Add New Property</router-link>
  <available-property-list/>
  <occupied-property-list/>

</template>

<script>
import AvailablePropertyList from '../components/AvailablePropertyList.vue';
import OccupiedPropertyList from '../components/OccupiedPropertyList.vue';

export default{
  components: { AvailablePropertyList, OccupiedPropertyList },
}
</script>

<style>
/*.btn-submit {
  color: rgba(25, 27, 29, 0.87);
  background-color: #b7cddb;
  border-color: #43677c;
  text-decoration: none;
  padding: 6px 12px;
  cursor: pointer;
}
.btn-cancel {
  color: rgba(255,255,255,0.7);
  background-color: #b65d65;
  border-color: #b65d65;
  padding: 6px 12px;
}
 header, footer, nav, main, aside {
        font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        font-size: 24px;
        text-transform: uppercase;
    } */
</style>