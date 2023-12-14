<template>
  <div class="application">
    <router-link v-bind:to="{name: 'application'}">Back to Applications</router-link>
    <div>
        <h1>Application Details</h1>
        <h2>Application ID: {{ application.applicationId }}</h2>
        <h3>PropertyId : {{ application.propertyId }}</h3>
        <h4>Status : {{ application.status }}</h4>
        <p>
            Full Name : {{ application.fullName }}
        </p>
        <p>
            Email : {{ application.email }}
        </p>
        <p>
            Has Roommates? {{ editApplication.hasRoomates }}
        </p>
        <p>
            Roommates Names: {{ editApplication.roomateNames }}
        </p>
    </div>
    <div>
    <select v-model="editApplication.status" v-on:change="updateApplications" v-show="this.$store.state.showManagerPOV">
        <option value="approved">Approved</option>
        <option value="rejected">Rejected</option>
    </select>
    </div>
    <button class="btn btn-delete" v-on:click="deleteApplication" v-show="!this.$store.state.showManagerPOV">Withdraw Application</button>
  </div>
</template>

<script>
import applicationService from '../services/ApplicationService';

export default {
     props: ['application'],
    data(){
        return {
            editApplication: {
              applicationId: this.$route.params.applicationId,
              propertyId: this.application.propertyId,
              fullName: this.application.fullName,
              email: this.application.email,
              hasRoomates: this.application.hasRoomates,
              roomateNames: this.application.roomateNames,
              status: this.application.status 
            }
        }
    },
    methods: {
        deleteApplication(){
            if(confirm("Are you sure you want to delete this application? This action can not be undone.")){
                applicationService
                .deleteApplication(this.application.applicationId)
                .then(response => {
                if(response.status === 204){
                this.$store.commit('SET_NOTIFICATION',
                    {
                        message: 'Service request has been deleted',
                        type: 'success'
                    });
                this.$router.push({name: 'application'})
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
    },
    getApplicationById(){
        alert(this.$route.params.applicationId);
        applicationService.getApplicationById(this.$route.params.applicationId)
        .then(response => {
            this.editApplication = response.data;
        }) 
        .catch(error => {
            if(error.response){
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting application. API Server could not be reached.");
            }else {
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting application. Application could not be executed.");
            }
        });
    },
    updateApplications(){
        alert('update called');
        let status = this.editApplication.status;
        alert(this.editApplication.applicationId);
        alert(this.editApplication.status);
        if(status === 'approved'){
            alert(status);
            this.editApplication.status = 'STATUS_APPROVED';
            alert(this.editApplication.status);
        } else if(status === 'rejected'){
            this.editApplication.status = 'STATUS_REJECTED';
        }
        applicationService
        .updateApplications(this.editApplication)
        .then(response => {
        if(response.status === 200){
            this.$store.commit('SET_NOTIFICATION',
                {
                    message: 'Application updated',
                    type: 'success'
                });
        } 
        }).catch(error => {
            if(error.response){
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting application. API Server could not be reached.");
            }else {
                this.$store.commit('SET_NOTIFICATION',
                "Error deleting application. Request could not be executed.");
            }
        });
        this.$router.push({name: 'application'})
    }
},
created(){
    this.getApplicationById();
}
}
       
</script>
