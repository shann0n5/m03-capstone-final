<template>
  <div class="property-container" >
   <h4 >
      <router-link class="link" v-bind:to="{name: 'propertyDetails', params: { propertyId: property.propertyId }}" >
        <p>#{{ property.propertyId }}:</p> 
        {{ property.address }}  <!-- -->
      </router-link> 
    </h4> 
    <p></p>
    <div class="button-container" > 
       
    <!-- <button v-if="! enableAdd" v-on:click.prevent="addToOccupiedList(property)">Add to Occupied Property List  </button> -->
    </div>

  </div>
</template>

<script>

export default {
  props: 
  {
    property: Object,
    enableAdd: {
        type: Boolean,
        default: false
    }
  },
  created(){
    if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
      this.$store.commit('SET_SHOW_MANAGER_POV', true);
    }
  }
}
</script>

<style scoped>
 .property-container{
  display: flex;
  /* flex-direction: column; */
  justify-content: space-evenly;
  flex-wrap: wrap;
  background-color: #daf0fd;
  border-radius: 45px;
  padding: 0 20px 20px 20px;
  margin-bottom: 20px;
  width: 500px;
} 
.link {
  text-decoration: none;
  color: rgb(53, 72, 95);
  
}
.link:hover {filter: brightness(2);}
</style>