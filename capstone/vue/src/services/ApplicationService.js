import axios from "axios";

export default{
    getAllApplications(){
        return axios.get(`/applications/managing`);
    },

    getMyApplications(){
        return axios.get(`/applications`);
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
    
    addApplication(application){
        return axios.post(`/applications`, application);
    },
    
    deleteApplication(applicationId){
        alert('delete was called');
        return axios.delete(`/applications/${applicationId}`);
    }
}