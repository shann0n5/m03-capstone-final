<template>
  <div class="home">
    <h1>Home</h1>
    <p>Welcome!</p>
  </div>
  <div class="manager-home-btn" > 
    <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'propertyManagerMainPage' }">My Properties</router-link>
    <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">View Applications for My Properties</router-link>
    <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link>
  </div>
  <div class="tenant-home-btn" > 
    <!-- <router-link  v-show="!this.$store.state.showManagerPOV" class="btn btn-submit" v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link> -->
    <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'serviceRequest'}">My Service Requests</router-link>
    <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">My Applications</router-link>
    <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'rentTransaction'}"> My Rent Transactions</router-link>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService';

export default {
  created() {
    if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
      this.$store.commit('SET_SHOW_MANAGER_POV', true);
    }
    PropertyService.getAllMyProperties().then(response => {
      this.$store.commit('SET_MY_PROPERTIES', response.data);
    });
    PropertyService.getProperties().then(response => {
      this.$store.commit('SET_PROPERTIES', response.data);
    });
  } 
};
</script>
