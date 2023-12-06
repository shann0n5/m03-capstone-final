<template>
    <form v-onsubmit.prevent="submitForm" class="rentTransactionForm">
      <div class="form-section">
          <label for="rentPayment">Pay</label>  
          <input type="number" id="rentPayment" name="rentPayment" v-model="editServiceRequest.description">
      </div>
      <div class="serviceRequestButton">
          <button class="btn-submit" type="submit">Add New Service Request</button>
           <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
  
      </div>
  
  
    </form>
  </template>

  <script>
import TenantServices from '../services/TenantServices';

export default {
    props: {
        rentTransaction: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            editRentTransaction: {
                id: this.rentTransaction.id,
                amount: this.rentTransaction.amount
                
            }
        }
    }
}
</script>