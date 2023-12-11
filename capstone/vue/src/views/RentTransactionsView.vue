<template>
  <div class="back-to-tenant-home">
    <router-link v-bind:to="{name:'tenantMainPage'}">Back to Tenant Home</router-link>
  </div>
 
  
  <div class="header">
<h1>Rent Transactions</h1>
 
</div>

  <div class="action-boards">
    <rent-transaction-section title="Payments" v-bind:rentTransactions="payments" />
    <rent-transaction-section title="Past Due Payments" v-bind:rentTransactions="pastDuePayments" />
    
  </div> 
</template>

<script>
import RentTransactionSection from '../components/RentTransactionSection.vue'
import RentTransactionService from '../services/RentTransactionService';
export default {
  components: { 
    RentTransactionSection,
 },
 data() {
  return {
    rentTransactionBoard: { title: '', rentTransactions: []}
  }
 },
 computed: {
    payments() {
      return this.$store.state.rentTransactions.filter(rentTransaction => rentTransaction.pastDue === false);
    },
    pastDuePayments() {
      return this.$store.state.rentTransactions.filter(rentTransaction => rentTransaction.pastDue === true);
    }
  },
  methods: {
    created() {
      let rentTransactionId = parseInt(this.$route.params.rentTransactionId)
      if(rentTransactionId != 0) {
      RentTransactionService.getRentTransactionById(rentTransactionId)
      .then(response => {
        this.rentTransaction = response.data;
      })
      .catch(error => {
          if (error.response) {
            this.$store.commit('SET_NOTIFICATION',
              "Error getting rent transactions list. Response received was '" + error.response.statusText + "'.");
          } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION', "Error getting rent transactions list. Server could not be reached.");
          } else {
            this.$store.commit('SET_NOTIFICATION', "Error getting rent transactions list. Request could not be created.");
          }
        });
    }
    }
  }
  };

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