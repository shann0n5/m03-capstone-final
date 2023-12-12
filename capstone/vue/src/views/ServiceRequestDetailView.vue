<template>
  <div>
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