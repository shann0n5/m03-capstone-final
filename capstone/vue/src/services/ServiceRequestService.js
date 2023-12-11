import axios from "axios";

export default{
    getAllMyServiceRequests(){
        return axios.get(`/service-requests`);
    },

    getServiceRequestById(serviceRequestId){
        return axios.get(`/service-requests/${serviceRequestId}`);
    },

    getServiceRequestsByStatus(status){
        return axios.get(`/service-requests/status/${status}`);
    },

    updateServiceRequest(serviceRequest){
        return axios.put(`/service-requests/${serviceRequest.id}`, serviceRequest);
    },

    addServiceRequest(serviceRequest){
        return axios.post(`/service-requests`, serviceRequest);
    },

    deleteServiceRequest(serviceRequestId){
        return axios.delete(`service-requests/${serviceRequestId}`);
    }
}