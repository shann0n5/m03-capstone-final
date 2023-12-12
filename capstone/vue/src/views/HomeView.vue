<template>
  <div class="home">
    <h1>Home</h1>
    <p>Welcome!</p>
  </div>
<div class="tenant-home-btn"> 
  <router-link v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link>
</div>
<div class="manager-home-btn"> 
  <router-link v-bind:to="{name: 'propertyManagerMainPage'}">Property Manager Home</router-link>
</div>
 
</template>

<script>
// import UserService from '../services/UserService';

export default {
  // created() {
  //   let managerId = 0;
  //   let tenantId = 0;
  //   UserService.getManagerIdFromUserId().then(response => {
  //     this.$store.commit('SET_MANAGER_ID', response.data);
  //     alert(managerId);
  //     alert(this.$store.state.managerId);
  //   }).catch(error => {
  //     if (error.response.status === 404) {
  //       this.$store.commit('SET_NOTIFICATION', `Error: managerId was not found.`)
  //       this.$router.push({ name: 'HomeView' });
  //     } else {
  //       this.$store.commit('SET_NOTIFICATION',
  //         "Error getting managerId. Response received was '" + error.response.statusText + "'.");
  //     }
  //   });
  //   UserService.getTenantIdFromUserId().then(response => {
  //     this.$store.commit('SET_MANAGER_ID', response.data);
  //     alert(tenantId);
  //     alert(this.$store.state.tenantId);
  //   }).catch(error => {
  //     if (error.response.status === 404) {
  //       this.$store.commit('SET_NOTIFICATION', `Error: tenantId was not found.`)
  //       this.$router.push({ name: 'HomeView' });
  //     } else {
  //       this.$store.commit('SET_NOTIFICATION',
  //         "Error getting tenantId. Response received was '" + error.response.statusText + "'.");
  //     }
  //   });
  // }

    
  
};
</script>
