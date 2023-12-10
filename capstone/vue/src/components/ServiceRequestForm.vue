<template>
  <form v-onsubmit.prevent="submitForm" class="serviceRequestForm">
    <div class="info-field">
        <label for="title">Title:</label>
         <input id="title" type="text" class="form-control" v-model="editServiceRequest.title"/>
    </div>
    <div class="info-field">
        <label for="requestDescription">Request Description:</label>  
        <textarea id="requestDescription" class="form-control" v-model="editServiceRequest.description"></textarea>
    </div>
    <div class="serviceRequestButton">
        <button class="btn-submit" type="submit">Add New Service Request</button>
         <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>

    </div>


  </form>
</template>

<script>
import serviceRequestService from '../services/ServiceRequestService';

export default {
    props: {
        serviceRequest: {
            type: Object, 
            required: true
        }
    },
    data() {
    return {
        editServiceRequest: {
            id: this.serviceRequest.id,
            title: this.serviceRequest.title,
            description: this.serviceRequest.description
        }
    };
},
    methods: {
        submitForm(){
            if(!this.validateForm()){
                return;
            }
            if(this.editServiceRequest.id === 0){
                serviceRequestService
                    .addServiceRequest(this.serviceRequest)
                    .then(response => {
                        if(response.status === 201){
                            this.$store.commit(
                                'SET_NOTIFICATION',
                                {
                                    message: 'A new service request was added.',
                                    type: 'success'
                                }
                            );
                            this.$router.push({ name: 'serviceRequest', params})
                        }
                    })
            }
        },
        cancelForm(){
            this.$router.push({ name: 'serviceRequest', params: { id: this.editServiceRequest.serviceRequestId } });
        },
        validateForm(){
            let msg = '';
            if(this.editServiceRequest.title.length === 0){
                msg += 'The new service request must have a title.';
            }
            if(this.editServiceRequest.description.length === 0){
                msg += 'The new service request must have a description.';
            }
            if(msg.length > 0){
                this.$store.commit('SET_NOTIFICATION', msg);
                return false;
            }
            return true;
        }
    }
}
</script>

<style>

.serviceRequestForm {
  padding: 10px;
  margin-bottom: 10px; 
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.info-field {
  margin-bottom: 10px;
  margin-top: 10px;
  font-family: Arial, Helvetica, sans-serif;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
</style>