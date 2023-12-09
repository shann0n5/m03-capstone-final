<template>
  <form v-onsubmit.prevent="submitForm" class="serviceRequestForm">
    <div class="form-section">
        <label for="requestDescription">Request Description</label>  
        <input type="text" id="requestDescription" name="requestDescription" v-model="editServiceRequest.description">
    </div>
    <div class="serviceRequestButton">
        <button class="btn-submit" type="submit">Add New Service Request</button>
         <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>

    </div>


  </form>
</template>

<script>
export default {
    props: {
        serviceRequest: {
            type: Object, required: true
        }
    },
    data() {
    return {
        editServiceRequest: {
            id: this.serviceRequest.id,
            description: this.serviceRequest.description
        }
    };
},
    methods: {
        cancelForm() {
      this.$router.push({ name: 'serviceRequest', params: { id: this.editServiceRequest.serviceRequestId } });
    }
    }
}
</script>

<style>

</style>