import axios from "axios";

export default{
    getAllRentTransactions(){
        return axios.get(`/rent-transactions/managing`);
    },

    getMyRentTransactions(){
        return axios.get(`/rent-transactions`);
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

    addRentTransactions(rentTransaction){
        return axios.post(`/rent-transactions`, rentTransaction);
    },
    deleteRentTransactions(rentTransactionId){
        return axios.delete(`/rent-transactions/${rentTransactionId}`);
    },

}