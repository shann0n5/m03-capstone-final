<template>
    <div class="container">
      <table id="tblProperties">
          <thead>
              <tr>
                  <!----> <th>Availability</th>
                  <th>Property ID</th>
                  <th>Address, City, State, or ZIP code</th>
                  <!--<th>City</th>
                  <th>State</th> 
                  <th>Zipcode</th>-->
                   <th>Number Of Rooms</th>
                  <th>Rent Range</th> 
                  <button class="btn btn-cancel" v-on:click="clearFilter" type="button">Clear</button>
  
                  <!--where to put is available, option for searching the properties you manage??-->
              </tr>
          </thead>
          <tbody>
              <tr>
                 
                  <!-- --><td>
                      <select id="availabilityFilter" v-model="filter.available">
                          <option disabled value="">-- Select --</option>
                          <option value="viewAll">Search All Properties</option>
                          <option value="isAvailable">Available</option>
                          <option value="occupied">Occupied</option>
                          
                      </select>
                  </td>
                  <td><input type="number" id="propertyIdFilter" placeholder="ex: 4001"  v-model="filter.propertyId" v-on:change="filter.propertyId" ></td>
                  <td><input type="text" id="addressFilter" placeholder="ex: 328 N Rodeo Dr, Beverly Hills, CA 90210"  v-model="filter.address"></td>
                  <!--<td><input type="text" id="cityFilter" placeholder="ex: Beverly Hills"  v-model="filter.city"></td>
                  <td><input type="text" id="stateFilter" placeholder="ex: CA" v-model="filter.state"></td> 
                  <td><input type="text" id="zipcodeFilter" placeholder="ex: 90210" v-model="filter.zipcode"></td>-->
                   <td><input type="number" id="numOfRoomsFilter" placeholder="ex: 3" v-model="filter.numberOfRooms"></td> 
                  
                  <!--  --><td>
                      <select id="rentFilter" placeholder="ex:"  v-model="filter.rent">
                          <option disabled value="">----</option>
                          <option value="<1000">Below $1,000</option>
                          <option value="<2000">$2,000 & under</option>
                          <option value="<3000">$3,000 & under</option>
                          <option value="<4000">$4,000 & under</option>
                          <option value="<5000">$5,000 & under</option>
                          <option value="<5000">$6,000 & under</option>
                          <option value="<5000">$7,000 & under</option>
                          <option value="<5000">$8,000 & under</option>
                          <option value="<5000">$9,000 & under</option>
                          <option value="<5000">$10,000 & under</option>
                      </select>
                  </td>
                  <td>&nbsp;</td>
              </tr>
              <!-- -->
              <tr v-for="property in filterProperties" v-bind:key="property.propertyId" > 
                  <td>&nbsp;</td>
                  <td>{{ property.propertyId }}</td>
                  <td>{{ property.address }}</td>
                  <td>{{ property.numberOfRooms }}</td>
                  <td>{{ property.rent }}</td>
              </tr> 
          </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import PropertyService from '../services/PropertyService'
  export default {
      // props: ['properties'],
      data() {
          return {
              filter: {
                  available: '',
                  propertyId: '',
                  address: '',
                  // city: '',
                  // state: '',
                  // zipcode: '',
                  numberOfRooms: '',
                  rent: ''
              },
              
          }
      },
      methods: {
          getProperties() {
              PropertyService.getProperties().then(response => {
                  this.$store.state.commit('SET_PROPERTIES', this.properties);
                  this.properties = this.$store.state.properties;
              })
          }, 
          clearFilter() {
              this.filter = {
                  available: '',
                  propertyId: '',
                  address: '',
                  // city: '',
                  // state: '',
                  // zipcode: '',
                  numberOfRooms: '',
                  rent: ''
              }
          }
      //     getProperties() {
      //         PropertyService.getProperties().then(response => {
      //         this.properties = response.data;
      //         }).catch(error => {
      //             if (error.response) {
      //                 if (error.response.status === 404) {
      //                     this.$store.commit('SET_NOTIFICATION',
      //                     "Error: property was not found.");
      //                     this.$router.push({ name: 'HomeView' });
      //                 } else {
      //                     this.$store.commit('SET_NOTIFICATION',
      //                     "Error getting properties. Response received was '" + error.response.statusText + "'.");
      //                 }
      //             } else if (error.request) {
      //                 this.$store.commit('SET_NOTIFICATION', "Error getting properties. Server could not be reached.");
      //             } else {
      //                 this.$store.commit('SET_NOTIFICATION', "Error getting properties. Request could not be created.");
      //             }
      //         });
      // }
          
      },
      computed: {
          filterProperties() {
              let filteredProperties = this.$store.state.properties;
              if (this.filter.available != '') {
                  // alert(this.filter.available)
                  if (this.filter.available == 'isAvailable') {
                      filteredProperties = filteredProperties.filter(property => {
                          return property.available == true;
                          // return true;
                          
                      })
                  } else if (this.filter.available == 'occupied') {
                      filteredProperties = filteredProperties.filter(property => {
                          return property.available == false;
                      })
                  }
              }
              if (this.filter.propertyId != '') {
                  // alert(this.filter.propertyId)
                  filteredProperties = filteredProperties.filter(property => {
                       return property.propertyId == this.filter.propertyId; 
                      
                  });
              }
              if (this.filter.address != '') {
                  filteredProperties = filteredProperties.filter(property => {
                      return property.address.toLowerCase().includes(this.filter.address.toLowerCase());
                  });
              }
              
              if (this.filter.numberOfRooms != '') {
                  filteredProperties = filteredProperties.filter(property => {
                      return property.numberOfRooms == this.filter.numberOfRooms
                  });
              }
              if (this.filter.rent != '') {
                  filteredProperties = filteredProperties.filter(property => {
                     return property.rent.toLowerCase().includes(this.filter.rent.toLowerCase())
                  });
              }// if (this.filter.city != '') {
              //     filteredProperties = filteredProperties.filter(property => {
              //         property.address.toLowerCase().includes(this.filter.city.toLowerCase())
              //     });
              // }
              // if (this.filter.state != '') {
              //     filteredProperties = filteredProperties.filter(property => {
              //         property.address.toLowerCase().includes(this.filter.state.toLowerCase())
              //     });
              // }
              // if (this.filter.zipcode != '') {
              //     filteredProperties = filteredProperties.filter(property => {
              //         property.address.toLowerCase().includes(this.filter.zipcode.toLowerCase())
              //     });
              // }
              return filteredProperties;
          }
          
      },
      created() {
          this.getProperties();
      // //     PropertyService.getProperties().then(response => {
      // //         this.properties = response.data;
      // //     }).catch(error => {
      // //         if (error.response) {
      // //             if (error.response.status === 404) {
      // //                 this.$store.commit('SET_NOTIFICATION',
      // //                 "Error: property was not found.");
      // //                 this.$router.push({ name: 'HomeView' });
      // //             } else {
      // //                 this.$store.commit('SET_NOTIFICATION',
      // //                 "Error getting properties. Response received was '" + error.response.statusText + "'.");
      // //             }
      // //         } else if (error.request) {
      // //             this.$store.commit('SET_NOTIFICATION', "Error getting properties. Server could not be reached.");
      // //         } else {
      // //             this.$store.commit('SET_NOTIFICATION', "Error getting properties. Request could not be created.");
      // //         }
      // //     });
         
      }
  }
  </script>
  
  <style>
  
  </style>