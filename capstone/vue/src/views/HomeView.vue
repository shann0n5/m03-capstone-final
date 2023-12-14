<template class="main-page">
  <div class="home">
    <h1>Home</h1>
    <p></p>
  </div>
  <div class="manager-home-btn" > 
    <!-- <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'propertyManagerMainPage' }">My Properties</router-link>
    <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">View Applications for My Properties</router-link>
    <router-link class="btn btn-primary" v-show="this.$store.state.showManagerPOV" v-bind:to="{ name: 'serviceRequest' }">See Service Requests</router-link> -->
    <a class="btn btn-outline-primary btn-lg " href="/property-manager-main-view" target="_self" v-show="this.$store.state.showManagerPOV">My Properties </a>&nbsp;&nbsp
   
    <a class=" btn btn-outline-primary  btn-lg " href="/application-view" target="_self"  v-show="this.$store.state.showManagerPOV">View Applications for My Properties</a> &nbsp;&nbsp
    
    <a class="btn btn-outline-primary  btn-lg " href="/service-request-view" target="_self" >See Service Requests</a>
  </div>


  <div class="tenant-home-btn" > 
    <!-- <router-link  v-show="!this.$store.state.showManagerPOV" class="btn btn-submit" v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link> -->
    <!-- <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'serviceRequest'}">My Service Requests</router-link>
    <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{ name: 'application' }">My Applications</router-link>
    <router-link class="btn btn-primary" v-show="!this.$store.state.showManagerPOV" v-bind:to="{name: 'rentTransaction'}"> My Rent Transactions</router-link> -->

    <a class="btn btn-outline-primary nav btn-lg flex-column"   href="/service-request-view" target="_self" v-show="!this.$store.state.showManagerPOV">My Service Requests</a>
    <a class="btn btn-outline-primary nav btn-lg flex-column"  href="/application-view" target="_self" v-show="!this.$store.state.showManagerPOV" >My Applications</a>
    <a class="btn btn-outline-primary nav btn-lg flex-column"   href="/rent-transaction-view" target="_self" v-show="!this.$store.state.showManagerPOV">My Rent Transactions</a>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService';

export default {
  created() {
    if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
      alert(`before the mutation ${this.$store.state.showManagerPOV}`)
      this.$store.commit('SET_SHOW_MANAGER_POV', true);
      alert(`AFTER the mutation ${this.$store.state.showManagerPOV}`)
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

<style >
.manager-home-btn{
display: flex;
margin: 10px;
padding: 10px;
justify-content: center;


}

.tenant-home-btn{
display: flex;
margin: 10px;
padding: 10px;
justify-content: center;

}
.btn-btn-outline-primary-btn-lg {
  padding-left: 10px;
  margin-left: 10px;
  justify-content: center;
}
h1{
  display: flex;
  justify-content: center;
}



</style>