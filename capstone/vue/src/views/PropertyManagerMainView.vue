<template>

    <header>Welcome</header>
  <available-property-list />
  <occupied-property-list />

</template>

<script>
import AvailablePropertyList from '../components/AvailablePropertyList.vue';
import OccupiedPropertyList from '../components/OccupiedPropertyList.vue';
export default{
  components: { AvailablePropertyList, OccupiedPropertyList },
}
</script>

<style>

</style>