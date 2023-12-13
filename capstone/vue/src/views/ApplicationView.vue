<template>
  <div>
    <div class="back-to-home">
        <router-link v-bind:to="{name: 'home'}">Back to Home</router-link>
    </div>
    <div class="header">
        <h1>Applications</h1>
        <!-- ROUTER LINK TO APPLICATION FORM -->
    </div>
    <div>
        <application-section title="Pending" v-bind:application="pending"/>
        <application-section title="Approved" v-bind:application="approved"/>
        <application-section title="Rejected" v-bind:application="rejected"/>
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
            applicationBoard: { title: '', applications: [] }
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
        applicationService
        .getAllApplications()
        .then(response => {
            this.$store.commit('SET_APPLICATION', response.data);
        })
        .catch(error => {
            if(error.response && error.response.status === 404){
                this.$store.commit('SET_NOTIFICATION', `Error getting applications.`)
                //ROUTER TO APPLICATIONS
            }
        })
    }

}
</script>

<style>

</style>