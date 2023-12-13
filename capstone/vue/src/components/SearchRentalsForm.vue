 <template>
    <div class="container">
      <table id="tblProperties">
          <thead>
              <tr>
                  <th>Availability</th>
                  <th>Property ID</th>
                  <th>Address, City, State, or ZIP code</th>
                   <th>Number Of Rooms</th>
                  <th>Maximum Rent: $</th> 
                  <td>&nbsp;</td>
              </tr>
          </thead>
          <tbody>
              <tr>
                 
                  <td>
                      <select id="availabilityFilter" v-model="filter.available">
                          <option disabled value="">-- Select --</option>
                          <option value="viewAll">Search All Rentals</option>
                          <option value="isAvailable">Available</option>
                          <option value="occupied">Occupied</option>
                      </select>
                  </td>
                  <td><input type="number" id="propertyIdFilter" placeholder="ex: 4001"  v-model="filter.propertyId" v-on:change="filter.propertyId" ></td>
                  <td><input type="text" id="addressFilter" placeholder="ex: 328 N Rodeo Dr, Beverly Hills, CA 90210"  v-model="filter.address"></td>
                 <!-- <td><input type="text" id="cityFilter" placeholder="ex: Beverly Hills"  v-model="filter.city"></td> 
                  <td><input type="text" id="stateFilter" placeholder="ex: CA" v-model="filter.state"></td> 
                  <td><input type="text" id="zipcodeFilter" placeholder="ex: 90210" v-model="filter.zipcode"></td>-->
                    <td><input type="number" id="numOfRoomsFilter" placeholder="ex: 3" v-model="filter.numberOfRooms"></td> 
                  

                    <td><input type="number" id="rent" placeholder="ex: 5000" v-model="filter.rent"></td> 

                  <button class="btn btn-cancel" v-on:click="clearFilter" type="button">Clear</button>
              </tr>
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
                numberOfRooms: '',
                rent: ''
            },
        }
    },
    methods: {
      getProperties() {
          PropertyService.getProperties().then(response => {
              this.$store.state.commit('SET_PROPERTIES', response.data);
              this.properties = this.$store.state.properties;
          })
      }, 
        clearFilter() {
            this.filter = {
                available: '',
                propertyId: '',
                address: '',
                numberOfRooms: '',
                rent: ''
            }
        }   
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
                    return property.numberOfRooms == this.filter.numberOfRooms;
                });
            }
            if (this.filter.rent != '') {
                filteredProperties = filteredProperties.filter(property => {
                    return property.rent < this.filter.rent;
                });
            }
            return filteredProperties;
        }
        
    },
      created() {
          this.getProperties(); 
      }
  }
  </script>
  
  <style>
  
  </style> 
 