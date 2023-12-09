import axios from "axios";

export default {
  
    
    getProperty(id) {
        return axios.get(`/properties/${id}`);
    },
    addProperty(property) {
        return axios.post('/properties', property);
    },
    updateProperty(property) {
        return axios.put(`/properties/${property.id}`, property);
    },
    deleteProperty(id) {
        return axios.delete(`/properties/${id}`);
    }
}