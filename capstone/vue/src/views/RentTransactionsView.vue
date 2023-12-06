<template>
  <div class="back-to-tenant-home">
    <router-link v-bind:to="{name:'tenantMainView'}">Back to Tenant Home</router-link>
    <rent-transactions-section v-bind:rentTransaction="rentTransaction" />
  </div>
  <div class="add-new-rent-Transaction">
    <router-link v-bind:to="{name:'addServiceRequest'}">Add New Request</router-link>
    <rent-transaction-section v-bind:rentTransaction="rentTransaction" />
  </div>
  
  <div class="header">
<h1>Rent Transactions</h1>

</div>

  <div class="action-boards">
    <rent-transaction-section title="Upcoming" v-bind:rentTransactions="upcoming" />
    <rent-transaction-section title="Past Due" v-bind:rentTransactions="pastDue" />
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
    rentTransactionBoard: {title: '', rentTransactions: []}
  }
 },
 computed: {
    upcoming() {
      return this.rentTransactionBoard.rentTransactions.filter(rentTransaction => rentTransaction.status === 'Upcoming');
    },
    pastDue() {
      return this.rentTransactionBoard.rentTransactions.filter(rentTransaction => rentTransaction.status === 'Past Due');
    },
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