<template>
  <form v-on:submit.prevent="submitForm" class="property-form">
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
          <input type="checkbox" id="isAvailable" name="isAvailable" v-model="editProperty.available">
        </div>
       
        <div class="property-form-btn">
            <button class="btn-submit" type="submit">Save Property</button>
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
    editProperty: {
      propertyId: this.property.propertyId,
      managerId: this.property.managerId,
      address: this.property.address,
      numberOfRooms: this.property.numberOfRooms,
      rent: this.property.rent,
      available: this.property.available
    }
    // editProperty: {
    //   propertyId: 0,
    //   managerId: 0,
    //   address: '',
    //   numberOfRooms:'',
    //   rent: '',
    //   available: ''
    // }

  }
},
methods: {
  submitForm() {
    if (!this.validateForm()) {
      return;
    }
    if (this.editProperty.propertyId === 0) {
      PropertyService.addProperty(this.editProperty).then(response => {
        if (response.status === 201 || response.status === 200) {
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
              message: `Property ${this.editCard.propertyId} was updated.`,
              type: 'success'
            }
          );
          this.$router.push({ name: 'propertyManagerMainPage'});
        }
      }).catch(error => {
        this.handleErrorResponse(error, 'updating');
      });
    }
  },
  // clearForm() {
  //   this.editProperty = {
  //     propertyId: '',
  //     managerId: '',
  //     address: '',
  //     numberOfRooms:'',
  //     rent: '',
  //     available: ''
  //   }
  // },
  cancelForm() {
    // this.clearForm();
      this.$router.push({ name: 'propertyManagerMainPage' });
  },
  handleErrorResponse(error, verb) {
      if (error.response) {
        this.$store.commit('SET_NOTIFICATION',
          "Error " + verb + " property. Response received was '" + error.response.statusText + "'.");
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " property. Server could not be reached.");
      } else {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " property. Request could not be created.");
      }
  },
  validateForm() {
      let msg = '';
      if (this.editCard.address.length === 0) {
        msg += 'The new property must have an address. ';
      }
      if (this.editCard.numberOfRooms.length === 0) {
        msg += 'The new property must have a number of rooms.';
      }
      if (this.editCard.rent.length === 0) {
        msg += 'The new property must have a rent.';
      }
      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    },

},
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