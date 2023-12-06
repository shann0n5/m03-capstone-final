<template>
    <div class="action-board">
      <h2>{{title}}</h2>
      <div class="rent-transactions">
          <div class="rent-transaction" v-for="rentTransaction in rentTransactions" v-bind:key="rentTransaction.transactionId" v-on:click="viewRentTransactionDetails(rentTransaction)">
          <div class="header">
            <h3>Rent Transaction Id: {{ rentTransaction.transactionId }}</h3> </div>
         </div> 
         
         <!-- <div> Amount Due: {{ rentTransaction.amount }}</div>
         
         <div>Payment Due Date: {{ rentTransaction.dueDate }}</div>
         
         <div>  {{ rentTransaction.pastDue }}</div> -->
        </div>
    </div>
  </template>
  
  <script>
  export default {
  props: ['title', 'rentTransactions'],
  
  method: {
     
      viewRentTransactionDetails(rentTransaction) {
        this.$router.push({name: 'rentTransaction', params:{rentTransactionId: rentTransaction.transactionId}});
      }
  }
  }
</script>
<style>
.action-board {
  background-color: #6f828e;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}

.rent-transactions {
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer;
}

.rent-transaction:last-child {
  margin-bottom: 0px;
}

.rent-transaction h3 {
  margin-top: 0px;
  font-size: 0.875rem;
}

.rent-transaction .header {
  display: flex;
  justify-content: space-between;
}

</style>