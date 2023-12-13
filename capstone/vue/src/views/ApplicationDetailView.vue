<template>
  <div>
    <application-detail v-bind:application="application"/>
  </div>
</template>

<script>
import ApplicationDetail from '../components/ApplicationDetail.vue';
import applicationService from '../services/ApplicationService';

export default {
    components: {
        ApplicationDetail
    },
    data(){
        return {
            application: {

            },
        }
    },
    created(){
        applicationService
        .getApplicationById(this.$forceUpdate.params.applicationId)
        .then(response => {
            this.application = response.data;
        });
    }

}
</script>

<style>

</style>