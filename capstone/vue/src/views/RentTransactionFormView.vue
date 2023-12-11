<template>
  <header>Rent Payment</header>
  <div class="back-to-rent-transactions">
    <router-link v-bind:to="{name:'rentTransaction'}">Back to Rent Transactions</router-link>
    <p></p>
    <rent-transaction-form v-bind:rentTransaction="rentTransaction" />
  </div>
</template>

<script>
import RentTransactionForm from '../components/RentTransactionForm.vue';
import RentTransactionService from '../services/RentTransactionService';

export default {
components: {
  RentTransactionForm},
  data() {
    return {
      rentTransaction: {
        id: 0,
        amount: 0,
        dueDate: '',
        pastDue: false
      }
    };
  },
  created() {
    let rentTransactionId = parseInt(this.$route.params.rentTransactionId);
      RentTransactionService
      . addRentTransactions(rentTransactionId)
      .then(response => {
        this.rentTransaction = response.data;
      })
  
}
}
</script>

<style>

</style>