<template>
  <div class="home">
    <h1>Home</h1>
    <p>Welcome!</p>
  </div>
<div class="tenant-home-btn"> 
  <router-link v-bind:to="{name: 'tenantMainPage'}">Tenant Home</router-link>
</div>
 
</template>

<script>
export default {
};
</script>
