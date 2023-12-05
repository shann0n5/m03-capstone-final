<template>
  <div class="rent-transaction-view">
    <router-link v-bind:to="{name:'tenantMainView'}">Back to Tenant Home</router-link>
    <rent-transactions-list v-bind:rentTransaction="rentTransaction" />
  </div>
</template>

<script>
import RentTransactionsList from '../components/RentTransactionsList.vue'
export default {
  components: { 
    RentTransactionsList
 },

}
</script>

<style>

</style>