<template>
  <form v-on:submit.prevent="submitForm" class="applicationForm">
    <div class="field">
        <div class="info-field">
            <label for="fullName">Full Name:</label>
            <input type="text" class="form-control" id="fullName" name="fullName" v-model="editApplication.fullName">
        </div>
        <div class="info-field">
            <label for="birthdate">BirthDate:</label>
            <input type="date" id="birthdate" class="form-control" name="birthdate" v-model="editApplication.birthdate">
        </div>
        <div class="info-field">
            <label for="email">Email:</label>
            <input type="email" id="email" class="form-control" name="email" v-model="editApplication.email">
        </div>
        <div class="info-field"> 
            <label for="address">Address:</label>
            <input type="text" id="address" class="form-control" name="address" v-model="editApplication.address">
        </div>
        <div class="applicationButton">
            <button class="btn-submit" type="submit">Submit</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </div>
    </div>

  </form>
</template>

<script>
import applicationService from '../services/ApplicationService';
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
        this.$router.push({ name: 'home' });
      }
    }
}
</script>

<style scoped>
.applicationForm {
  padding: 10px;
  margin-bottom: 10px; 
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.info-field {
  margin-bottom: 10px;
  margin-top: 10px;
  font-family: Arial, Helvetica, sans-serif;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}

</style>