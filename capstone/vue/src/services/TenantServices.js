import axios from "axios";

export default{
    getMyApplications(){
        return axios.get(`/applications`);
    },
    getApplicationById(applicationId){
        return axios.get(`/applications/${applicationId}`);
    },
    addApplication(application){
        return axios.post(`/applications`, application);
    },
    deleteApplication(applicationId){
        return axios.delete(`/applications/${applicationId}`);
    },

    
    getMyRentTransactions(){
        return axios.get(`/rent-transactions`);
    },
    getMyRentTransactionById(rentTransactionId){
        return axios.get(`/rent-transactions/${rentTransactionId}`);
    },
    addRentTransactions(rentTransaction){
        return axios.post(`/rent-transactions`, rentTransaction);
    },
    deleteRentTransactions(rentTransactionId){
        return axios.delete(`/rent-transactions/${rentTransactionId}`);
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
    addServiceRequest(serviceRequest){
        return axios.post(`/service-requests`, serviceRequest);
    },
    deleteServiceRequest(serviceRequestId){
        return axios.delete(`service-requests/${serviceRequestId}`);
    }
}