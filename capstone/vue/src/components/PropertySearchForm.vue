<template>
  <div class="container">
    <table id="tblProperties">
        <thead>
            <tr>
                <th>Availability</th>
                <th>Property Id</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zipcode</th>
                <th>Number Of Rooms</th>
                <th>Rent Range</th>
                <!--where to put is available, option for searching the properties you manage??-->
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <select id="availabilityFilter" v-model="filter.isAvailable">
                        <option value="isAvailable">Available</option>
                        <option value="occupied">Occupied</option>
                        <option value="viewAll">Search All Properties</option>
                    </select>
                </td>
                <td><input type="text" id="propertyIdFilter" v-model="filter.propertyId"></td>
                <td><input type="text" id="addressFilter" v-model="filter.address"></td>
                <td><input type="text" id="cityFilter" v-model="filter.city"></td>
                <td><input type="text" id="stateFilter" v-model="filter.state"></td>
                <td><input type="text" id="zipcodeFilter" v-model="filter.zipcode"></td>
                <td><input type="text" id="numOfRoomsFilter" v-model="filter.numberOfRooms"></td>
                <td>
                    <select id="rentFilter" v-model="filter.rent">
                        <option value="<1000">Below $1000</option>
                        <option value="<2000">$1001 - $2000</option>
                        <option value="<3000">$2001 - $3000</option>
                        <option value="<4000">$3001 - $4000</option>
                        <option value="<5000"></option>
                    </select>
                </td>
            </tr>
            <!-- <tr v-for="property in filteredList" > v-bind:key="propertyId" -->
                <td>&nbsp;</td>
                <td>{{ property.propertyId }}</td>
                <td>{{ property.address }}</td>
                <td>{{ property.numberOfRooms }}</td>
                <td>{{ property.rent }}</td>
            <!-- </tr> -->
            
        </tbody>
    </table>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>