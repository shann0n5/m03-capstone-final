<template>
    <form class="rentTransactionForm">
      <div class="form-section">
    

        <div v-bind:key="rentTransaction.rentTransactionId">Paymemt Due: {{ rentTransaction.amount }}</div>
          <label for="rentPayment">Amount you would like to pay:  </label>  
          <input type="number" name="paymentInput" ref="paymentInput">
      </div>
      <div v-if="rentTransaction.pastDue">Is this payment past due? {{ rentTransaction.pastDue}}</div>
      <div class="serviceRequestButton">
      
          <button v-bind:to="{name:'rentTransaction'}" class="btn-submit" type="submit" v-on:click="submitPayment">Complete Payment</button>&nbsp;|&nbsp;
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
      return false;

  }
}
}
     </script>
 <!-- // let msg = '';\ -->
  <!-- // msg += 
      // if (msg.length > 0) {
      //   this.$store.commit('SET_NOTIFICATION', msg);
      //   return false;
      // }
    
    
   
// } -->
