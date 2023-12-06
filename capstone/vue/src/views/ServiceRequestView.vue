<template>
<div class="back-to-tenant-home">
    <router-link v-bind:to="{name:'tenantMainPage'}">Back to Tenant Home</router-link>
    <service-request-section v-bind:serviceRequest="serviceRequest" />
  </div>
  <div class="add-new-service-request">
    <router-link v-bind:to="{name:'addServiceRequest'}">Add New Request</router-link>
    <service-request-section v-bind:serviceRequest="serviceRequest" />
  </div>
  
  <div class="header">
<h1>Service Requests</h1>

</div>

  <div class="action-boards">
    <service-request-section title="open" v-bind:serviceRequests="open" />
    <service-request-section title="In Progress" v-bind:serviceRequests="inProgress" />
    <service-request-section title="Closed" v-bind:serviceRequests="closed" />
  </div> 
</template>

<script>
import TenantServices from '../services/TenantServices'
import ServiceRequestSection from '../components/ServiceRequestSection.vue'

export default {
components: {
    
ServiceRequestSection
},
data() {
    return {
        serviceBoard: { title: '', serviceRequests: []}
    };
    
},
  computed: {
    open() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_OPEN');
    },
    inProgress() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_IN_PROGRESS');
    },
    closed() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_COMPLETE');
    }
  }
}
</script>

<style>

.action-boards{
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
.header{
  display: flex;
  align-items: center;
}
.header h1 {
  flex-grow: 1;
}
service-request-actions {
  display: flex;
  
}
</style>