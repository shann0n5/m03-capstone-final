<template>
  <div class="serviceRequest">
    <h1>{{ serviceRequest.serviceRequestId }}</h1>
    <p>{{ serviceRequest.requestDetails  }}</p>
    <router-link v-bind:to="{ name: 'ServiceRequestView'}">Back to Service Requests</router-link>
    <button class="btn btn-cancel" v-on:click="deleteServiceRequest">Delete Service Request</button>
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
            if(response.status === 200){
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
    },

}
</script>

<style>

</style>