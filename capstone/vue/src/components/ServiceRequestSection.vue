<!-- similar to board section -->
<template>
  <div class="action-board">
    <h2>{{title}}</h2>
    <div class="service-requests">
        <div class="service-request" v-for="serviceRequest in serviceRequests" v-bind:key="serviceRequest.serviceRequestId" v-on:click="viewServiceRequestDetails">
          <router-link v-bind:to="{name: 'serviceRequestDetails', params:{serviceRequestId: serviceRequest.serviceRequestId}}">
          <!-- <router-link v-bind:to="{name: 'serviceRequestDetails', params:{serviceRequestId: serviceRequest.id}}">Service Details</router-link> -->
          <div class="header">
            <h3>
              <!-- <router-link v-bind:to="{name: 'serviceRequestDetails', params:{serviceRequestId: serviceRequest.id}}">Service Details</router-link> -->
              Service Request:{{ serviceRequest.serviceRequestId }}
            </h3>
          </div>
         
          <div>Details: {{ serviceRequest.requestDetails }}</div>
        </router-link>

        </div>
      
    </div>
  </div>
</template>

<script>
export default {
props: ['title', 'serviceRequests'],

method: {
    viewServiceRequestDetails() {
      alert('here');
      // this.$router.push({name: 'serviceRequestDetails', params:{serviceRequestId: serviceRequest.serviceRequestId}});
    }
}
}
</script>

<style>
.action-board {
  background-color: #6f828e;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}

.service-requests {
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer;
}

.service-request{
  border-style: ridge;
  border-radius: 0.25rem;
  padding: 10px;
}

.service-request:last-child {
  margin-bottom: 0px;
}

.service-request h3 {
  margin-top: 0px;
  font-size: 0.875rem;
}

.service-request .header {
  display: flex;
  justify-content: space-between;
}

.service-request .footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 20px 0 10px 0;
  font-size: 0.75rem;
}
</style>