<template>
  <div>
    <router-link v-bind:to="{ name: 'ServiceRequestView'}">Back to Service Requests</router-link>
    <service-request-detail v-bind:serviceRequest="serviceRequest"/>
  </div>
</template>

<script>
import ServiceRequestDetail from '../components/ServiceRequestDetail.vue'
import serviceRequestService from '../services/ServiceRequestService';

export default {
  components: { 
    ServiceRequestDetail 
  },
  data(){
    return {
        serviceRequest: {
            id: this.serviceRequest.id,
            title: this.serviceRequest.title,
            requestDetails: this.serviceRequest.requestDetails,
            status: this.serviceRequest.status
        },
    }
  },
  created(){
    serviceRequestService
    .getServiceRequestById(this.$route.params.serviceRequestId)
    .then(response => {
        this.serviceRequest = response.data;
    });

  }

}
</script>

<style>

</style>