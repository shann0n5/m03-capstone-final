<template>
  <div class="application">
    <!-- ROUTER BACK TO APPLICATIONS -->
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
    </div>
    <button class="btn btn-delete" v-on:click="deleteApplication">Delete Application</button>
  </div>
</template>

<script>
import applicationService from '../services/ApplicationService';

export default {
    props: ['application'],
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
                //ROUTER LINK BACK TO APPLICATIONS
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