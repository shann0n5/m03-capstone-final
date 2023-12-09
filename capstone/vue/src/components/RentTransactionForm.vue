<template>
    <form v-onsubmit.prevent="submitForm" class="rentTransactionForm">
      <div class="form-section">
        
          <label for="rentPayment">Rent Payment Id:  </label>  
          <input type="search" id="rentPayment" name="rentPayment" v-model="editRentTransaction.transactionId">
      

        <div >Paymemt Due: {{ rentTransaction.amount }}</div>
          <label for="rentPayment">Amount you would like to pay:  </label>  
          <input type="number" id="rentPayment" name="rentPayment" v-model="editRentTransaction.amount">
      </div>
      <div v-if="rentTransaction.pastDue">Is this payment past due? {{ rentTransaction.pastDue }}</div>
      <div class="serviceRequestButton">
        <div class="info-field"> <label for="isAvailable">Is Available: </label>
        <input type="checkbox" id="isAvailable" name="isAvailable" v-model="editRentTransaction.isConfirmed">
        </div>
          <button class="btn-submit" type="submit">Complete Payment</button>&nbsp;|&nbsp;
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
                id: this.rentTransaction.transactionId,
                amount: this.rentTransaction.amount,
                isConfirmed: this.rentTransaction.confirmed
                
            }
        }
    },
    methods: {
        cancelForm() {
      this.$router.push({ name: 'rentTransaction', params: { id: this.editRentTransaction.transactionId } });
    }
    }
}
</script>