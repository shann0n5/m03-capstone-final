<template>
 <header>New Property </header>
<div class="property-form">
  <new-property-form />
</div>
</template>

<script>
import NewPropertyForm from '../components/NewPropertyForm.vue'

export default {
  components: { NewPropertyForm},
  data() {
    return {
      property:{
        id: 0,
        managerId: parseInt(this.$store.state.managerId),
        address: '',
        numberOfRooms: 0,
        rent: 0,
        isAvailable: true


      }
    }
  }

}
</script>

<style>

</style>