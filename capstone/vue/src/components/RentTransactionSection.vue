<template>
    <div class="rent-transaction-board">
      <h2>Rent Transactions</h2>
      <div class="rent-transactions">
          <div class="rentTransaction" v-for="rentTransaction in rentTransactions" v-bind:key="rentTransaction.id" v-on:click="viewRentTransactionDetails(rentTransaction)">
  
          </div>
  
      </div>
    </div>
  </template>
  
  <script>
  export default {
  props: [ 'rentTransaction'],
  
  method: {
     
      viewRentTransactionDetails(rentTransaction) {
        this.$route.push({name: 'RentRequestView', params:{actionBoardId: rentTransaction.actionBoardId, rentTransactionId: rentTransaction.id}});
      }
  }
  }
</script>
<style>

</style>