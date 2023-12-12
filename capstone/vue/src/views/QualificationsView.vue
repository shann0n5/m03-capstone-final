<template>
    <h2> Please read qualifications of becoming a tenant at a Real-TE property before submitting an application.</h2>
    <p>
      Must be 18</p>
    <p>No pets</p>  
    <p> Must have good credit/ rental history</p>
    <p>Must have first and last month rent</p>
    <p>Must have no prior evictions
      </p>
     
     <div class="application-link-to-register">
      <router-link v-bind:to="{name: 'register'}">Register to Apply</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'application'}">Rental Application</router-link>
    </div>


  </template>
  
  <script>
  
  export default {
  
  }
  </script>
  
  <style>
  
  </style>