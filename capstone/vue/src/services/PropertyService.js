import axios from "axios";

export default{
    getProperties(){
        return axios.get(`/properties`);
    },
    getPropertyById(propertyId){
        return axios.get(`/properties/${propertyId}`);
    },
    getAllMyProperties(){
        return axios.get(`/properties/managing`);
    },
    addProperty(property) {
        return axios.post('/properties', property);
    },
    updateProperty(property) {
        alert('property services');
        alert(property.propertyId);
        return axios.put(`/properties/${property.propertyId}`, property); 
    },
    deleteProperty(propertyId) {
        return axios.delete(`/properties/${propertyId}`);
    }
}