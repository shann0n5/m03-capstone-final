<template>
  <div class="action-board">
    <h2>{{title}}</h2>
    <div class="service-requests">
        <div class="service-request" v-for="serviceRequest in serviceRequests" v-bind:key="serviceRequest.id" v-on:click="viewServiceRequestDetails(serviceRequest) ">
          <div class="header">
            <h3>Service Request:{{ serviceRequest.id }}</h3>
          </div>
          <div class="footer">
            <span class="date">{{ new Date(serviceRequest.date).toDateString() }}</span>
          </div>
        </div>

    </div>
  </div>
</template>

<script>
export default {
props: ['title','serviceRequest'],

method: {
    viewServiceRequestDetails(serviceRequest) {
      this.$router.push({name: 'ServiceRequestView', params:{serviceRequestId: serviceRequest.id}});
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