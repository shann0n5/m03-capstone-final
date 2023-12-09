import axios from "axios";

export default {

    getAllApplications(){
        return axios.get(`/applications/managing`);
    },
    getApplicationsByPropertyId(propertyId){
        return axios.get(`/applications/managing/${propertyId}`);
    },
    getApplicationsByStatus(status){
        return axios.get(`/applications/status/${status}`);
    },
    getApplicationById(applicationId){
        return axios.get(`/applications/${applicationId}`);
    },
    updateApplications(application){
        return axios.put(`/applications/update/${application.id}`, application);
    },

    
    getAllRentTransactions(){
        return axios.get(`/rent-transactions/managing`);
    },
    getAllRentTransactionsByPropertyId(propertyId){
        return axios.get(`/rent-transactions/managing/${propertyId}`);
    },
    getAllRentTransactionsByPastDue(boolean){
        return axios.get(`/rent-transactions/past-due${boolean}`);
    },
    getRentTransactionById(rentTransactionId){
        return axios.get(`/rent-transactions/${rentTransactionId}`);
    },
    updateRentTransaction(rentTransaction){
        return axios.put(`/rent-transactions/update/${rentTransaction.id}`, rentTransaction);
    },


    getAllMyServiceRequests(){
        return axios.get(`/service-requests`);
    },
    getServiceRequestById(serviceRequestId){
        return axios.get(`/service-requests/${serviceRequestId}`);
    },
    getServiceRequestsByStatus(status){
        return axios.get(`/service-requests/status/${status}`);
    },
    updateServiceRequests(serviceRequest){
        return axios.put(`/service-requests/${serviceRequest.id}`, serviceRequest);
    },

    
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