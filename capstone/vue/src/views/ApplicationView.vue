<template>
  <div class="application-header">
    <header>Real-TE Tenant Application</header>
    <application-form v-bind:application="application"/>
  </div>
</template>

<script>
import ApplicationForm from '../components/ApplicationForm.vue';

export default {
    components: {
        ApplicationForm
    },
    data() {
      return {
        application: {
          id: 0,
          applicationId: parseInt(this.$route.params.applicationId),
          firstName: '',
          lastName: '',
          birthdate: '',
          email: '',
          address: '',
          status: 'STATUS_PENDING'
        }
      }
    }
}
</script>

<style>

</style>