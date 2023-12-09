<template>
  <h1> Welcome, Tenant Name </h1>
  
<div id="tenant-service-boards">
  <div class="back-home-btn"> <router-link v-bind:to="{name: 'home'}">Back Home</router-link> </div>
  <router-link v-bind:to="{name: 'serviceRequest'}">Service Request</router-link>&nbsp;|&nbsp;
  <router-link v-bind:to="{name: 'rentTransaction'}">Rent Transactions</router-link>&nbsp;|&nbsp;
<tenant-home-sections  v-bind:tenantHomeSections="tenantHomeSection" />
 
</div>
<div >

</div>
</template>

<script>
import TenantHomeSections from '../components/TenantHomeSections.vue';
export default {
components: {
    TenantHomeSections
}
}
</script>

<style>

</style>