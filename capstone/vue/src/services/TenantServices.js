import axios from "axios";

export default{
    
    addServiceRequest() {
        return axios.post('/service-request')
    },
    getServiceRequests() {
        return axios.get('/service-requests');
    },
    getServiceRequestByTenantId(id){
        return axios.get('/service-request/tenants/${id}');
    },
    getServiceRequestById(id) {
        return axios.get(`/service-requests/${id}`);
    },
    getServiceRequestByStatus(serviceRequest) {
        return axios.get(`/service-requests/${serviceRequest.status}`)
    },
    updateServiceRequestApproved(id) {
        return axios.put(`/service-requests/approve/${id}`);
    },
    updateServiceRequestStatusRejected(id) {
        return axios.put(`/service-requests/reject/${id}`)
    }
}