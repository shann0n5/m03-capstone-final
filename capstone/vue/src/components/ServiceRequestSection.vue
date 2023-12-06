<template>
  <div class="action-board">
    <h2>{{title}}</h2>
    <div class="service-requests">
        <div class="service-request" v-for="serviceRequest in serviceRequests" v-bind:key="serviceRequest.id" v-on:click="viewServiceRequestDetails(serviceRequest) ">

        </div>

    </div>
  </div>
</template>

<script>
export default {
props: ['serviceRequest'],

method: {
    viewServiceRequestDetails(serviceRequest) {
      this.$route.push({name: 'ServiceRequestView', params:{actionBoardId: serviceRequest.actionBoardId, serviceRequestId: serviceRequest.id}});
    }
}
}
</script>

<style>

</style>