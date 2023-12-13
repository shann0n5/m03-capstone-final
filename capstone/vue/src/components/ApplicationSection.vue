<template>
  <div>
    <h2>{{ title }}</h2>
    <div class="application" v-for="application in applications" v-bind:key="application.applicationId">
        <router-link>
            <div>
                <h3>
                    Application: {{ application.applicationId }}
                </h3>
                <h4>
                    PropertyId : {{ application.propertyId }}
                </h4>
            </div>
            <!-- <p>
                Full Name : {{ application.fullName }}
            </p>
            <p>
                Email : {{ application.email }}
            </p>
            <p>
                Roomates???
            </p> -->
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