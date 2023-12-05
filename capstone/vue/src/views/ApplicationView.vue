<template>
  <div class="application-header">
    <header>Real-TE Tenant Application</header>
  </div>
  <div>
    <application-form v-bind:application="application"/>
  </div>
</template>

<script>
import ApplicationForm from '../components/ApplicationForm.vue';

export default {
    components: {
        ApplicationForm
    }
}
</script>

<style>

</style>