<template>
  <header>Rent Payment</header>
  <div class="back-to-rent-transactions">
    <router-link v-bind:to="{name:'requestTransaction'}">back</router-link>
    <p></p>
    <rent-transaction-form v-bind:rentTransaction="rentTransaction" />
  </div>
</template>

<script>
import RentTransactionForm from '../components/RentTransactionForm.vue';
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
    }
  }
}
</script>

<style>

</style>