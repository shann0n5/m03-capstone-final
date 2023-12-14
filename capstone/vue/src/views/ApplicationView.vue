<template>
  <div>
    <div class="back-to-home">
        <router-link v-bind:to="{name: 'home'}">Back to Home</router-link>
    </div>
    <div class="header">
        <h1>Applications</h1>
        <!-- ROUTER LINK TO APPLICATION FORM -->
    </div>
    <div class="action-boards">
        <application-section title="Pending" v-bind:applications="pending"/>
        <application-section title="Approved" v-bind:applications="approved"/>
        <application-section title="Rejected" v-bind:applications="rejected"/>
    </div>
  </div>
</template>

<script>
import ApplicationSection from '../components/ApplicationSection.vue';
import applicationService from '../services/ApplicationService';

export default {
    components: {
        ApplicationSection
    },
    data(){
        return {
            applicationList: { title: '', applications: [] }
        };
    },
    computed: {
        pending(){
            return this.$store.state.applications.filter(application => application.status === 'STATUS_PENDING');
        },
        approved(){
            return this.$store.state.applications.filter(application => application.status === 'STATUS_APPROVED');
        },
        rejected(){
            return this.$store.state.applications.filter(application => application.status === 'STATUS_REJECTED');
        }

    },
    created(){
        if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'){
        applicationService
        .getAllApplications()
        .then(response => {
            // alert(response.data);
            this.$store.commit('SET_APPLICATION', response.data);
            // this.applications = this.$store.state.applications;
        })
        .catch(error => {
            if(error.response && error.response.status === 404){
                this.$store.commit('SET_NOTIFICATION', `Error getting applications.`)
                //ROUTER TO APPLICATIONS
            }
        });
        } else if (this.$store.state.user.authorities[0].name === 'ROLE_USER'){
        applicationService
        .getMyApplications()
        .then(response => {
            // alert(response.data);
            this.$store.commit('SET_APPLICATION', response.data);
            // this.applications = this.$store.state.applications;
        })
        .catch(error => {
            if(error.response && error.response.status === 404){
                this.$store.commit('SET_NOTIFICATION', `Error getting applications.`)
                //ROUTER TO APPLICATIONS
            }
        });
        }
        
    }

}
</script>

<style>

</style>