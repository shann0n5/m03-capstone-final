<template>
  <header>New Service Request</header>
  <div class="back-to-service-request">
    <router-link v-bind:to="{name:'serviceRequest'}">back</router-link>
    <p></p>
    
  </div>
  <p></p>
  <service-request-form v-bind:serviceRequest="serviceRequest"/>


</template>

<script>
import ServiceRequestForm from '../components/ServiceRequestForm.vue'

export default {
  components: { ServiceRequestForm },
  data() {
    return {
      serviceRequest: {
        id:0,
        requestDetails: '',
        status: 'STATUS_OPEN'
      }
    }
  }

}
</script>

<style>

</style>