<template>
  <div class="back-to-tenant-home">
    <router-link v-bind:to="{name:'tenantMainPage'}">Back to Tenant Home</router-link>
  </div>
 
  
  <div class="header">
<h1>Rent Transactions</h1>
 <div class="add-new-rent-Transaction">
    <router-link v-bind:to="{name:'createRentTransaction'}">Pay Rent</router-link>
    
  </div>
</div>

  <div class="action-boards">
    <rent-transaction-section title="Upcoming Payments" v-bind:rentTransactions="upcoming" />
    <rent-transaction-section title="Past Due Payments" v-bind:rentTransactions="pastDue" />
    <rent-transaction-section title="Completed Payments" v-bind:rentTransactions="complete" />
  </div> 
</template>

<script>
import RentTransactionSection from '../components/RentTransactionSection.vue'
import TenantServices from '../services/TenantServices';
export default {
  components: { 
    RentTransactionSection,
 },
 data() {
  return {
    rentTransaction: {title: '', rentTransactions: []}
  }
 },
 computed: {
    upcoming() {
      return this.$store.state.rentTransactions.filter(rentTransaction => rentTransaction.pastDue === false);
    },
    pastDue() {
      return this.$store.state.rentTransactions.filter(rentTransaction => rentTransaction.pastDue === true);
    }
  }

}
</script>

<style>
.action-boards{
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
.header{
  display: flex;
  align-items: center;
}
.header h1 {
  flex-grow: 1;
}
service-request-actions {
  display: flex;
  
}
</style>