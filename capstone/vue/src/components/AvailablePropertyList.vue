<template>
  <section>
    <h2>Available Properties </h2>
    <div class="available-properties">
    <property-container v-bind:property="property"  v-for="property in availableProperties"  v-bind:key="property.propertyId"   ></property-container>
 <!--v-on:click="viewPropertyDetails(property)" v-bind:to="{ name: 'propertyDetails', params: {propertyId: property.propertyId}}"-->
  </div>
  </section>
</template>



<script>
 import PropertyService from '../services/PropertyService';
import PropertyContainer from './PropertyContainer.vue';

export default {
  props: ['properties'],
  // data() {
  // return {
  //   property: {
  //     propertyId: '',
  //     managerId: '',
  //     address: '',
  //     numberOfRooms: '',
  //     rent: '',
  //     isAvailable: ''
  //   }
  // };},

  components: { PropertyContainer },
  methods: {
    viewPropertyDetails(property) {
      this.$router.push({ name: 'propertyDetails', params: { propertyId: property.propertyId }});
    },
    // getAvailableProperties() {
    //   PropertyService.getAllMyProperties().then(response => {
    //     this.properties = response.data;
    //   });
    // }
  },
  computed: {
    availableProperties() {
        return this.$store.state.properties.filter((property)=> {
            return property.isAvailable == true;
        });
    }
    // availableProperties() {
    //     return this.properties.filter((property)=> {
    //         return property.isAvailable == true;
    //     });
    // }
},
//  created() {
//   this.getAvailableProperties();
// }

// created() {
//     PropertyService.getAllMyProperties().then(response => {
//       this.$store.commit('SET_PROPERTIES', response.data);
//       alert('Created executed')
//     }).catch(error => {
//       if (error.response && error.response.status === 404) {
//         this.$store.commit('SET_NOTIFICATION', `Error getting properties.`);
//       }
//     });
//   }
// created() {
//   this.this.$store.state.properties;
// }

// SET_PROPERTIES(state, properties) {
//   state.properties = properties;
// },
}
</script>

<style>

</style>