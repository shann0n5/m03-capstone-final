<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
        <div class="info-field"><label for="fullName">Full Name</label>
        <input type="text" id="fullName" name="fullName" v-model="editApplication.fullName">
        </div>
        <div class="info-field"><label for="birthdate">BirthDate</label>
        <input type="date" id="birthdate" name="birthdate" v-model="editApplication.birthdate">
        </div>
        <div class="info-field"><label for="email">Email</label>
        <input type="email" id="email" name="email" v-model="editApplication.email">
        </div>
        <div class="info-field"> <label for="address"> Address </label>
        <input type="text" id="address" name="address" v-model="editApplication.address">
        </div>
       
        <div class="applicationButton">
            <button class="btn-submit" type="submit">Submit Rental Application</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </div>
    </div>

  </form>
</template>

<script>
import MangementServcies from '../services/ManagementServices';
export default {
    props: {
        application:{
            type: Object,
            required: true
        },
    },
    data() {
        return {
            editApplication: {
            id: this.application.id,
            fullName: this.application.fullName,
            birthdate: this.application.birthdate,
            email: this.application.email,
            address: this.application.address,
            status: this.application.status 
            }
        };
    },
    method: {
        cancelForm() {
      this.$router.push({ name: 'Home', params: { id: this.editApplication.id } });
    }
    }
}
</script>

<style>

</style>