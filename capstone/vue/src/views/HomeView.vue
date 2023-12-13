<template>
  <div class="home">
    <h1>Home</h1>
    <p>Welcome!</p>
  </div>
<!--   <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <router-link v-bind:to="{name: 'propertyManagerMainPage'}">Property Manager Home</router-link> -->
<div class="manager-home-btn"> 
  

  <router-link class="btn btn-submit"  v-bind:to="{ name: 'propertyManagerMainPage' }">My Properties</router-link>
  <router-link class="btn btn-submit"  v-bind:to="{ name: 'propertySearch' }">Search Properties</router-link>
  <router-link class="btn btn-submit"  v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link>
</div>
<div class="tenant-home-btn"> 
  <router-link v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link>
</div>

 
</template>

<script>
import UserService from '../services/UserService';

export default {
  data() {
    return {
      showManagerPOV: false,
      // SET_SHOW_MANAGER_POV(state, showManagerPOV) {
      //   state.showManagerPOV = showManagerPOV;
      // },
    }
  },
  created() {
    // let managerId = 0;
    // let tenantId = 0;
    UserService.getManagerIdFromUserId().then(response => {
      this.$store.commit('SET_MANAGER_ID', response.data);
      // alert(managerId);
      // alert(`Manager Id: ${this.$store.state.managerId}`);
    }).catch(error => {
      if (error.response.status === 404) {
        this.$store.commit('SET_NOTIFICATION', `Error: managerId was not found.`)
        this.$router.push({ name: 'HomeView' });
      } else {
        this.$store.commit('SET_NOTIFICATION',
          "Error getting managerId. Response received was '" + error.response.statusText + "'.");
      }
    });
    UserService.getTenantIdFromUserId().then(response => {
      this.$store.commit('SET_TENANT_ID', response.data);
      // alert(tenantId);
      // alert(`Tenant Id: ${this.$store.state.tenantId}`);
    }).catch(error => {
      if (error.response.status === 404) {
        this.$store.commit('SET_NOTIFICATION', `Error: tenantId was not found.`)
        this.$router.push({ name: 'HomeView' });
      } else {
        this.$store.commit('SET_NOTIFICATION',
          "Error getting tenantId. Response received was '" + error.response.statusText + "'.");
      }
    });

    if (this.$store.state.managerId > 0) {
      this.showManagerPOV = true;
    } else {
      this.showManagerPOV = false;
    }
    // alert(`Logging in ${this.$store.state.showManagerPOV}.`);
    // alert(this.showManagerPOV);
  }

    
  
};
</script>
