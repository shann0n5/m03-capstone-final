<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" v-model="editApplication.name">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" v-model="editApplication.email">
        <label for="birthDate">BirthDate</label>
        <input type="text" id="birthDate" name="birthdate" v-model="editApplication.birthDate">
        <label for="address"> Address </label>
        <input type="text" id="address" name="address" v-model="editApplication.address">
        <div class="applicationButton">
            <button class="btn-submit" type="submit">Submit Rental Application</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </div>
    </div>

  </form>
</template>

<script>
import MangementServcies from '../services/MangementServcies';
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
            name: this.application.name,
            email: this.application.email,
            birthDate: this.application.birthDate,
            address: this.application.address 
            }
        };
    }
}
</script>

<style>

</style>