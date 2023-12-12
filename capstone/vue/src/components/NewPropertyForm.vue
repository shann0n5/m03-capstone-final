<template>
  <form v-on:submit.prevent="submitForm">
    <div class="field">
        <!-- <div class="info-field">
          <label for="managerId">Manager Id: </label>
          <input type="text" id="managerId" name="managerId" v-model="editProperty.managerId">
        </div> -->
        <div class="info-field"><label for="address">Address: </label>
          <input type="text" id="address" name="address" class="form-control" v-model="editProperty.address">
        </div>
        <div class="info-field"><label for="numberOfRooms">Number of Rooms: </label>
          <input type="text" id="numberOfRooms" name="numberOfRooms" class="form-control" v-model="editProperty.numberOfRooms">
        </div>
        <div class="info-field"><label for="rent">Rent: </label>
          <input type="text" id="rent" name="rent" class="form-control" v-model="editProperty.rent">
        </div>
        <div class="info-field"> <label for="isAvailable">Is Available: </label>
          <input type="checkbox" id="isAvailable" name="isAvailable" v-model="editProperty.isAvailable">
        </div>
       
        <div class="property-form-btn">
            <button class="btn-submit" type="submit">Save New Property</button>
            <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
        </div>
    </div>

  </form>
</template>

<script>
import PropertyService from '../services/PropertyService';
export default {
props: {
  property: {
    type: Object, required: true
  }
},
data() {
  return {
    // editProperty: {
    //   propertyId: this.$store.state.properties.propertyId,
    //   managerId: this.$store.state.properties.managerId,
    //   address: this.$store.state.properties.address,
    //   numberOfRooms: this.$store.state.properties.numberOfRooms,
    //   rent: this.$store.state.properties.rent,
    //   isAvailable: this.$store.state.properties.isAvailable
    // }
    editProperty: {
      propertyId: this.property.propertyId,
      managerId: this.property.managerId,
      address: this.property.address,
      numberOfRooms: this.property.numberOfRooms,
      rent: this.property.rent,
      isAvailable: this.property.isAvailable
    }

  }
},
methods: {
  submitForm() {
    if (!this.validateForm()) {
      return;
    }
    if (this.editProperty.propertyId === 0) {
      PropertyService.addProperty(this.editProperty).then(response => {
        if (response.status === 201) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: 'A new property was added.',
                  type: 'success'
                }
              );
              this.$router.push({ name: 'propertyManagerMainPage' });
            }
      }).catch(error => {
            this.handleErrorResponse(error, 'adding');
          });
    } else {
      PropertyService.updateProperty(this.editProperty).then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_NOTIFICATION', {
              message: `Card ${this.editCard.propertyId} was updated.`,
              type: 'success'
            }
          );
        }
      }).catch(error => {
        this.handleErrorResponse(error, 'updating');
      });
    }
  },
  cancelForm() {
      this.$router.push({ name: 'propertyManagerMainPage' });
  },
  handleErrorResponse(error, verb) {
      if (error.response) {
        this.$store.commit('SET_NOTIFICATION',
          "Error " + verb + " card. Response received was '" + error.response.statusText + "'.");
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " card. Server could not be reached.");
      } else {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " card. Request could not be created.");
      }
  },
  validateForm() {
      let msg = '';
      if (this.editCard.title.length === 0) {
        msg += 'The new property must have a title. ';
      }
      if (this.editCard.status.length === 0) {
        msg += 'The new property must have a status.';
      }
      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    },

}
// , params: { id: this.editPropertyForm.propertyId } 
}
</script>

<style scoped>
.field {
  padding: 10px;
  margin-bottom: 10px;
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