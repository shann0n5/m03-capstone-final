<template>
    <form v-onsubmit.prevent="submitForm" class="rentTransactionForm">
      <div class="form-section">
    

        <div v-bind:key="rentTransaction.transactionId">Paymemt Due: {{ rentTransaction.amount }}</div>
          <label for="rentPayment">Amount you would like to pay:  </label>  
          <input type="number" id="rentPayment" name="rentPayment" v-model="editRentTransaction.amount">
      </div>
      <div v-if="rentTransaction.pastDue">Is this payment past due? {{ this.pastDue }}</div>
      <div class="serviceRequestButton">
      
          <button class="btn-submit" type="submit">Complete Payment</button>&nbsp;|&nbsp;
           <button class="btn-cancel" type="button" v-on:click="cancelTransaction">Cancel</button>
  
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
        cancelTransaction() {
      this.$router.push({ name: 'rentTransaction', params: { id: this.editRentTransaction.transactionId } });
    },
    validateTransaction() {
      let msg = '';
      if (this.editRentTransaction.amount.length > 0) {
        msg += 'Rent payment amount must be more than 0. ';
      }
      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    }
    }
}
</script>