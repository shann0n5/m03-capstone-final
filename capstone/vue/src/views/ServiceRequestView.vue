<template>

  <div class="service-request-actions">
    <router-link v-bind:to="{name:'tenantMainPageView'}">Back to Tenant Home</router-link>

    <service-request-section v-bind:serviceRequest="serviceRequest" />
  </div>
  <div class="header">
<h1>Service Request</h1>
 
</div>

  <!-- <div class="request-boards">
    <service-request-section title="Open" v-bind:serviceRequests="open" />
    <service-request-section title="In Progress" v-bind:serviceRequests="inProgress" />
    <service-request-section title="Closed" v-bind:serviceRequests="closed" />
  </div> -->
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
        serviceBoard:{
            title: '',
            serviceRequests: []
        }
    }
    
},
  computed: {
    open() {
      return this.serviceBoard.serviceRequests.filter(serviceRequest => serviceRequest.status === 'Open');
    },
    inProgress() {
      return this.board.cards.filter(card => card.status === 'In Progress');
    },
    closed() {
      return this.board.cards.filter(card => card.status === 'Closed');
    }
  }
}
</script>

<style>

.request-boards{
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
</style>