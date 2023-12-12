import axios from "axios";

export default {
    getManagerIdFromUserId() {
        return axios.get(`/manager-id`);
    },
    getTenantIdFromUserId() {
        return axios.get(`/tenant-id`);
    }
}