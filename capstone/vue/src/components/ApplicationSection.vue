<template>
  <div>
    <h2>{{ title }}</h2>
    <div class="application" v-for="application in applications" v-bind:key="application.applicationId">
        <router-link>
            <div>
                <h3>
                    Application: {{ application.applicationId }}
                </h3>
            </div>
            <div>
                Details: {{ application. }}
            </div>
        </router-link>
    </div>
  </div>
</template>

<script>
export default {
props: ['title', 'applications'],

method: {
    
}
}
</script>

<style>

</style>