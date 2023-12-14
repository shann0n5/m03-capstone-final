<template>
    <div class="serviceRequest">
      <router-link v-bind:to="{ name: 'serviceRequest'}">Back to Service Requests</router-link>
      <div>
          <h2>Service Request Details </h2>
          <div>
          <h3> Service Request ID: {{ serviceRequest.serviceRequestId }}</h3>
          </div>
          <div>
          <h4> Tenant ID: </h4>
          {{ serviceRequest.tenantId }}
          </div>
          <div>
            <h4>Status:</h4>
            {{ serviceRequest.status }}
          </div>
          <div> <h4>Service Request Details:</h4> 
            {{ serviceRequest.requestDetails  }}
          </div>
      </div>
      <div>
        <select v-model="editServiceRequest.status" v-on:change="updateServiceRequest" v-show="this.$store.state.showManagerPOV">
            <option value="inProgress">In Progress</option>
            <option value="complete">Complete</option>
        </select>
      <button class="btn btn-outline-danger" v-on:click="deleteServiceRequest" v-show="!this.$store.state.showManagerPOV">Delete Service Request</button>
    </div>
    </div>
  </template>
  
  <script>
  import serviceRequestService from '../services/ServiceRequestService';
  
  export default {
      props: ['serviceRequest'],
      data(){
        return{
        editServiceRequest: {
              serviceRequestId: this.$route.params.serviceRequestId,
              title: this.serviceRequest.title,
              requestDetails: this.serviceRequest.requestDetails,
              status: this.serviceRequest.status
          }
        }
      },
      methods: {
          deleteServiceRequest(){
          if(confirm("Are you sure you want to delete this service request? This action cannot be undone.")){
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
                  "Error deleting service request. Request could not be executed.");
              }
              });
          }
          },
          getServiceRequestById(){
            serviceRequestService.getServiceRequestById(this.$route.params.serviceRequestId)
            .then(response => {
                this.editServiceRequest = response.data;
            })
            .catch(error => {
            if(error.response){
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting service request. API Server could not be reached.");
            }else {
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting service request. Request could not be executed.");
            }
        });
          },
          updateServiceRequest(){
            alert('update called');
            let status = this.editServiceRequest.status;
            if(status === 'inProgress'){
                this.editServiceRequest.status = 'STATUS_IN_PROGRESS';
            } else if (status === 'complete'){
                this.editServiceRequest.status = 'STATUS_COMPLETE';
            }
            serviceRequestService
            .updateServiceRequest(this.editServiceRequest)
            .then(response => {
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
            if(response.status === 200){
                this.$store.commit('SET_NOTIFICATION',
                {
                    message: 'Service request updated',
                    type: 'success'
                });
            }
            }).catch(error => {
            if(error.response){
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting service request. API Server could not be reached.");
            }else {
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting service request. Request could not be executed.");
            }
          });
          this.$router.push({name: 'serviceRequest'})
      },

    } ,
    created(){
        this.getServiceRequestById();
    }
  
  }
  </script>
  
  <style>
  
  </style>