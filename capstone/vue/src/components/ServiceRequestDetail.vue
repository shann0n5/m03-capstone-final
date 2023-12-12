<template>
  <div class="serviceRequest">
    <router-link v-bind:to="{ name: 'serviceRequest'}">Back to Service Requests</router-link>
    <div>
        <h1>Service Request Details </h1>
        <h2> Service Request ID: {{ serviceRequest.serviceRequestId }}</h2>
        <h2> Tenant ID: {{ serviceRequest.tenantId }}</h2>
        <div>{{ serviceRequest.status }}</div>
        <p> Service Request Details: {{ serviceRequest.requestDetails  }}</p>
    </div>
    <button class="btn btn-delete" v-on:click="deleteServiceRequest">Delete Service Request</button>
  </div>
</template>

<script>
import serviceRequestService from '../services/ServiceRequestService';

export default {
    props: ['serviceRequest'],
    methods: {
        deleteServiceRequest(){
        if(confirm("Are you sure you want to delete this service transaction? This action cannot be undone.")){
            serviceRequestService
            .deleteServiceRequest(this.serviceRequest.serviceRequestId)
            .then(response => {
            if(response.status === 204){
                this.$store.commit('SET_NOTIFICATION',
                {
                message: 'Service request has been deleted',
                type: 'success'
                });
                this.$router.push({ name: 'serviceRequest'});
            }
            }).catch(error => {
            if(error.response){
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting service request. API Server could not be reached.");
            }else {
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting board. Request could not be executed.");
            }
            });
        }
        }
    }
    

}
</script>

<style>

</style>