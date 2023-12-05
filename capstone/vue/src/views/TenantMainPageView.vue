<template>
  <h1> Welcome, Tenant First Name </h1>
  
<div id="tenant-service-boards">
  <router-link v-bind:to="{name: 'serviceRequestView'}">Service Request</router-link>&nbsp;|&nbsp;
  <router-link v-bind:to="{name: 'rentTransactionView'}">Rent Transactions</router-link>&nbsp;|&nbsp;
<TenantHomeSections  v-bind:tenantHomeSections="tenantHomeSection" />
 
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