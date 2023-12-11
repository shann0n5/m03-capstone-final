<!-- similar to AddCardView -->

<template>
  <div>
    <h1>New Service Request</h1>
    <!-- <div class="back-to-service-request">
      <router-link v-bind:to="{name:'serviceRequest'}">Back to Service Requests</router-link> 
    </div> -->
    <service-request-form v-bind:serviceRequest="serviceRequest"/>
  </div>
</template>

<script>
import ServiceRequestForm from '../components/ServiceRequestForm.vue';
import serviceRequestService from '../services/ServiceRequestService';

export default {
  components: { 
    ServiceRequestForm
  },
  data() {
    return {
      serviceRequest: {
        id:0,
        requestDetails: '',
        status: 'STATUS_OPEN'
      }
    }
  },
  //MOVED TO Service Request View
  // created(){
  //   let serviceRequestId = parseInt(this.$route.params.serviceRequestId);
  //   if(serviceRequestId != 0){
  //     serviceRequestService
  //       .getServiceRequestById(serviceRequestId)
  //       .then(response => {
  //         this.serviceRequest = response.data;
  //       })
  //       .catch(error => {
  //         if (error.response && error.response.status === 404){
  //           this.$store.commit('SET_NOTIFICATION', `Error getting service request ${serviceRequestId}. This service request may have been deleted or you have entered an invalid service request ID.`);
  //           this.$router.push({ name: 'serviceRequest' });
  //         }
  //       });
  //   }
  // }

}
</script>

