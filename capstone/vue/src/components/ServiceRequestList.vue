<template>
  <div class="action-boards">
    <router-link v-for="actionBoard in actionBoards" v-bind:key="actionBoard.id"
    v-bind:to="{name: 'ServiceRequestView', params: {id: actionBoard.id}}">
    <div class="action-board">{{ actionBoard.title }}</div>
    </router-link>

  </div>
</template>

<script>
export default {
props: ['action-boards']
}
</script>

<style>

</style>