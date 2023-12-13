<template>
  <div class="home">
    <h1>Home</h1>
    <p>Welcome!</p>
  </div>
<!--   <router-link class="btn btn-submit" v-bind:to="{ name: 'home' }">Back To Home</router-link>
  <router-link v-bind:to="{name: 'propertyManagerMainPage'}">Property Manager Home</router-link> -->
<div class="manager-home-btn" > 
  <router-link class="btn btn-submit" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'propertyManagerMainPage' }">My Properties Page</router-link>
  <!-- <router-link class="btn btn-submit" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'propertySearch' }">Search Properties</router-link> -->
  <router-link class="btn btn-submit" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">View Applications for My Properties</router-link>
  <router-link class="btn btn-submit" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link>
</div>
<div class="tenant-home-btn" > 
  <router-link  v-show="!this.$store.state.showManagerPOV" class="btn btn-submit" v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link>
  <router-link class="btn btn-submit" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'serviceRequest'}">Service Request</router-link>
  <router-link class="btn btn-submit" v-show="!this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">View My Applications</router-link>
  <router-link class="btn btn-submit" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'rentTransaction'}">Rent Transactions</router-link>
</div>
<div>
  {{ this.$store.state.user.authorities[0].name }}
</div>

 
</template>

<script>
import UserService from '../services/UserService';
import PropertyService from '../services/PropertyService';

export default {
  // props: ['showManagerPOV'],
  data() {
    // return {
    //   showManagerPOV: false,
    //   // SET_SHOW_MANAGER_POV(state, showManagerPOV) {
    //   //   state.showManagerPOV = showManagerPOV;
    //   // },
    // }
  },methods: {
  },
  created() {

    if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
      this.$store.commit('SET_SHOW_MANAGER_POV', true);
    }

    // let managerId = 0;
    // let tenantId = 0;
    // let managerId = this.$store.state.managerId;
    // alert(`managerId : ${this.$store.state.managerId}`)

    // let tenantId = this.$store.state.tenantId;
    // alert(`tenantId : ${this.$store.state.tenantId}`)

    // let showManagerPOV = this.$store.state.showManagerPOV;
    // alert(`showManagerPOV : ${showManagerPOV}`)
 // alert(`showManagerPOV after : ${this.showManagerPOV}`)
    // UserService.getManagerIdFromUserId().then(response => {
    //   this.$store.commit('SET_MANAGER_ID', response.data);

    //   if (this.$store.state.managerId > 0) {
    //     this.$store.commit('SET_SHOW_MANAGER_POV', true);
    //     // this.showManagerPOV = this.$store.state.showManagerPOV;
    
    //     alert(`showManagerPOV the store : ${this.$store.state.showManagerPOV}`)
    //   } else {
    //     this.$store.commit('SET_SHOW_MANAGER_POV', false);
    //   }

    //   // alert(managerId);
    //   // alert(`Manager Id: ${this.$store.state.managerId}`);
    // }).catch(error => {
    //   if (error.response.status === 404) {
    //     this.$store.commit('SET_NOTIFICATION', `Error: managerId was not found.`)
    //     this.$router.push({ name: 'HomeView' });
    //   } else {
    //     this.$store.commit('SET_NOTIFICATION',
    //       "Error getting managerId. Response received was '" + error.response.statusText + "'.");
    //   }
    // });
    // UserService.getTenantIdFromUserId().then(response => {
    //   this.$store.commit('SET_TENANT_ID', response.data);
    //   let tenantId = this.$store.state.tenantId;

    //   // if (this.$store.state.managerId > 0) {
    //   //   this.$store.commit('SET_SHOW_MANAGER_POV', true);
    //   // } else {
    //   //   this.$store.commit('SET_SHOW_MANAGER_POV', false);
    //   // }
    //   // alert(`Tenant Id: ${tenantId}`);
    //   // alert(`Tenant Id: ${this.$store.state.tenantId}`);
    // }).catch(error => {
    //   if (error.response.status === 404) {
    //     this.$store.commit('SET_NOTIFICATION', `Error: tenantId was not found.`)
    //     this.$router.push({ name: 'HomeView' });
    //   } else {
    //     this.$store.commit('SET_NOTIFICATION',
    //       "Error getting tenantId. Response received was '" + error.response.statusText + "'.");
    //   }
    // });

    // if (this.$store.state.managerId > 0) {
    //   showManagerPOV = true;
    // } else {
    //   showManagerPOV = false;
    // }
    //  if (this.$store.state.managerId > 0) {
    //     this.$store.commit('SET_SHOW_MANAGER_POV', true);
    //     showManagerPOV = this.$store.state.showManagerPOV;
    //     // alert(`showManagerPOV : ${showManagerPOV}`)
    //     // alert(`the store : ${this.$store.state.showManagerPOV}`)
    //   } else {
    //     this.$store.commit('SET_SHOW_MANAGER_POV', false);
    //   }    


    PropertyService.getAllMyProperties().then(response => {
      this.$store.state.commit('SET_MY_PROPERTIES', response.data);
    });
    PropertyService.getProperties().then(response => {
      this.$store.state.commit('SET_PROPERTIES', response.data);
    });
    // alert(`Logging in ${this.$store.state.showManagerPOV}.`);
    // alert(this.showManagerPOV);
  }


          
      
   
  
};
</script>
