<template>
  <div class="action-board">
    <h2>{{ title }}</h2>
    <div class="application" v-for="application in applications" 
    v-bind:key="application.applicationId">
        
            <div>
                <router-link v-bind:to="{name: 'applicationDetails', params:{ applicationId: application.applicationId}}">
                <h3>
                    Application ID: {{ application.applicationId }}
                </h3>
                <h4>
                    Property ID: {{ application.propertyId }}
                </h4>
                <div>{{ application }}</div>
                </router-link>
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
.action-board {
  background-color: #6f828e;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}
.application {
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer;
}
</style>