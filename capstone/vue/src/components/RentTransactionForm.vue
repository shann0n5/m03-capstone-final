<template>
    <form  v-on:click.prevent="submitPayment" class="rentTransactionForm">
      <div class="form-section">
    

        <div v-bind:key="rentTransaction.rentTransactionId">Paymemt Due: {{ this.rentTransaction.amount }}</div>
          <label for="rentPayment">Amount you would like to pay:  </label>  
          <input type="number" id="rentPayment" name="rentPayment" v-model="editRentTransaction.amount">
      </div>
      <div v-if="rentTransaction.pastDue">Is this payment past due? {{ editRentTransaction.pastDue}}</div>
      <div class="serviceRequestButton">
      
          <button class="btn-submit" type="submit" >Complete Payment</button>&nbsp;|&nbsp;
           <button class="btn-cancel" type="button" v-on:click="cancelPayment">Cancel</button>
  
      </div>
  
  
    </form>
  </template>

  <script>
import RentTransactionService from '../services/RentTransactionService'

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
                rentTransactionId: this.rentTransaction.rentTransactionId,
                amount: this.rentTransaction.amount,
                dueDate: this.rentTransaction.dueDate,
                pastDue: this.rentTransaction.pastDue
            }
        }
    },
    methods: {
      submitPayment() {
      if (!this.validateTransaction()) {
        return;
      }
      if(this.editRentTransaction.rentTransactionId === 0) {
        RentTransactionService. addRentTransactions(this.editRentTransaction)
        .then(response => {
          if (response.status === 201) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: 'Thank you for your payment!',
                  type: 'success'
                }
              );
              this.$router.push({ name: 'rentTransaction', params: { rentTransactionId: this.editRentTransaction.rentTransactionId } });
            }
        })
        .catch(error => {
            this.handleErrorResponse(error, 'updating');
          });
      }
    },
        cancelPayment() {
      this.$route.push({ name: 'rentTransaction' });
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        this.$store.commit('SET_NOTIFICATION',
          "Error " + verb + " rent transaction. Response received was '" + error.response.statusText + "'.");
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " rent transaction. Server could not be reached.");
      } else {
        this.$store.commit('SET_NOTIFICATION', "Error " + verb + " rent transaction. Request could not be created.");
      }
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
    },
    
    }
}
</script>