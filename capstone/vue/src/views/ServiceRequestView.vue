<!-- similar to BoardView -->
<template>
    <div>
      <div class="back-to-tenant-home">
        <router-link v-bind:to="{name:'tenantMainPage'}">Back to Home Page</router-link>
      </div>
      <div class="header">
        <h1>Service Requests</h1>
        <div class="add-new-service-request">
        <router-link v-bind:to="{name:'addServiceRequest'}">Add New Request</router-link>
      </div>
    </div>
    <div class="action-boards">
        <service-request-section title="Open"  v-bind:serviceRequests="open"/>
        <service-request-section title="In Progress"  v-bind:serviceRequests="inProgress"/>
        <service-request-section title="Complete" v-bind:serviceRequests="complete"/>
    </div>
  </div>
</template>

<script>
import ServiceRequestSection from '../components/ServiceRequestSection.vue'
import serviceRequestService from '../services/ServiceRequestService';

export default {
  components: {
    ServiceRequestSection
  },
  data() {
      return {
          serviceBoard: { title: '', serviceRequests: [] }
      };
      
  },
  computed: {
    open() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_OPEN');
    },
    inProgress() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_IN_PROGRESS');
    },
    complete() {
      return this.$store.state.serviceRequests.filter(serviceRequest => serviceRequest.status === 'STATUS_COMPLETE');
    }
  },
  methods: {
    // deleteServiceRequest(){
    //   if(confirm("Are you sure you want to delete this service transaction? This action cannot be undone.")){
    //     serviceRequestService
    //     .deleteServiceRequest(this.serviceBoard.id)
    //     .then(response => {
    //       if(response.status === 200){
    //         this.$store.commit('SET_NOTIFICATION',
    //         {
    //           message: 'Service request has been deleted',
    //           type: 'success'
    //         });
    //         this.$router.push({ name: 'serviceRequest'});
    //       }
    //     }).catch(error => {
    //       if(error.response){
    //         this.$store.commit('SET_NOTIFICATION',
    //         "Error deleting service request. API Server could not be reached.");
    //       }else {
    //         this.$store.commit('SET_NOTIFICATION',
    //         "Error deleting board. Request could not be executed.");
    //       }
    //     });
    //   }
    // }
    
  },
  created(){
        serviceRequestService
          .getAllMyServiceRequests()
          .then(response => {
            this.$store.commit('SET_SERVICE_REQUEST', response.data);
          })
          .catch(error => {
            if (error.response && error.response.status === 404){
              this.$store.commit('SET_NOTIFICATION', `Error getting service request. This service request may have been deleted or you have entered an invalid service request ID.`);
              this.$router.push({ name: 'serviceRequest' });
            }
          });
      
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