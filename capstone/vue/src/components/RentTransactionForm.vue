<template>
    <form class="rentTransactionForm">
      <div class="form-section">
        <div class="info-field" v-bind:key="rentTransaction.rentTransactionId">Paymemt Due: {{ rentTransaction.amount }}</div>
        <div class="info-field">
        <label for="rentPayment">Amount you would like to pay:  </label>  
          <input type="number" name="paymentInput" ref="paymentInput"></div> 
      </div>
      <div class="info-field" v-if="rentTransaction.pastDue">Is this payment past due? {{ rentTransaction.pastDue}}</div>
      <div  class="serviceRequestButton">
      
          <button v-bind:to="{name:'rentTransaction'}" class="btn-submit" type="submit" v-on:click="submitPayment">Complete Payment</button>&nbsp;&nbsp;
           <button class="btn-cancel" type="button" v-on:click="cancelPayment">Cancel</button>
  
      </div>
  
  
    </form>
  </template>

  <script>
import RentTransactionService from '../services/RentTransactionService'

export default {
  // Props are read-only, can use just this to call different values 
  // since not editing any parameters in the pay rent form from tenant side..
    props: {
        rentTransaction: {
            type: Object,
            required: true
        }
    },
    methods: {
      submitPayment() {
      if (this.validateTransaction()) {
          this.$router.push({ name: 'rentTransaction'});
      }
    
      //   return alert('Thank you for your payment');
      // if(this.rentTransaction.rentTransactionId === 0) {
        // RentTransactionService.getRentTransactionById(this.transactionId)
        // .then(response => {
        //   if (response.status === 200) {
        //       this.$store.commit(
        //         'SET_NOTIFICATION',
        //         {
        //           message: 'Thank you for your payment!',
        //           type: 'success'
        //         }
        //       );
        //       this.$router.push({ name: 'rentTransaction'});
        //     }
        // })
        // .catch(error => {
        //     this.handleErrorResponse(error, 'updating');
        //   });
      // }
    },
        cancelPayment() {
      this.$router.push({ name: 'rentTransaction'});
    // },
    // handleErrorResponse(error, verb) {
    //   if (error.response) {
    //     this.$store.commit('SET_NOTIFICATION',
    //       "Error " + verb + " rent transaction. Response received was '" + error.response.statusText + "'.");
    //   } else if (error.request) {
    //     this.$store.commit('SET_NOTIFICATION', "Error " + verb + " rent transaction. Server could not be reached.");
    //   } else {
    //     this.$store.commit('SET_NOTIFICATION', "Error " + verb + " rent transaction. Request could not be created.");
    //   }
    },
    validateTransaction() {
      
      if(this.rentTransaction.amount == this.$refs.paymentInput.value)
      {
        alert('Thank you for your payment! ');
        return true;
      } else
        {
          alert('Please enter valid amount')}
      return false

  }
}
}
     </script>
<style>
.rentTransactionForm{
  background-color: #6f828e;
  border-style: ridge;
  border-radius: 0.25rem;
  padding: 10px;
  
}
.info-field{
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer
  
}

.form-section{
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer;
  border-style: ridge;
  
  
}


</style>