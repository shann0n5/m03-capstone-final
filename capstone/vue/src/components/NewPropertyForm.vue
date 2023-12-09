<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
        <div class="info-field"><label for="managerId">Manager Id: </label>
        <input type="number" id="managerId" name="managerId" v-model="editPropertyForm.managerId">
        </div>
        <div class="info-field"><label for="address">Address: </label>
        <input type="text" id="address" name="address" v-model="editPropertyForm.address">
        </div>
        <div class="info-field"><label for="numberOfRooms">Number of Rooms: </label>
        <input type="number" id="numberOfRooms" name="numberOfRooms" v-model="editPropertyForm.numberOfRooms">
        </div>
        <div class="info-field"><label for="rent">Rent</label>
        <input type="number" id="rent" name="rent" v-model="editPropertyForm.rent">
        </div>
        <div class="info-field"> <label for="isAvailable">Is Available: </label>
        <input type="checkbox" id="isAvailable" name="isAvailable" v-model="editPropertyForm.isAvailable">
        </div>
       
        <div class="property-form-btn">
            <button class="btn-submit" type="submit">Save New Property</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </div>
    </div>

  </form>
</template>

<script>
import MangementServcies from '../services/MangementServcies';
export default {
prop: {
  property: {
    type: Object, required: true
  }
},
data() {
  return {
    editPropertyForm: {
      propertyId: this.$store.state.properties.propertyId,
      managerId: this.$store.state.properties.managerId,
      address: this.$store.state.properties.address,
      numberOfRooms: this.$store.state.properties.numberOfRooms,
      rent: this.$store.state.properties.rent,
      isAvailable: this.$store.state.properties.isAvailable
    }
  }
},
methods: {
  cancelForm() {
      this.$router.push({ name: 'propertyManagerMainPage', params: { id: this.editPropertyForm.propertyId } });
    }
}
}
</script>

<style>

</style>