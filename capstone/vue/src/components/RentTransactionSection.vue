<template>
    <div class="action-board">
      <h2>{{title}}</h2>
      <div class="rent-transactions" v-for="rentTransaction in rentTransactions" v-bind:key="rentTransaction.rentTransactionId">
         
         <div class="transaction-section-details">
            <div>Rent Payment Id: {{rentTransaction.transactionId}}</div> 
        
         <div > Amount Due: {{ rentTransaction.amount }} </div>
         
         <div>Payment Due Date: {{ rentTransaction.dueDate }}</div>
         
         <div> Is this payment past due?  {{ rentTransaction.pastDue }}</div>
         <div class="add-new-rent-Transaction">
    <router-link v-bind:to="{name:'RentTransactionForm', params:{rentTransactionId: rentTransaction.transactionId} }">Pay Rent</router-link>
   
  </div>
         </div>
        
        </div>

    </div>
  </template>
  
  <script>
  export default {
  props: ['title', 'rentTransactions'],
  

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