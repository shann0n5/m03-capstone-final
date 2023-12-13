import { createStore as _createStore } from 'vuex';
import axios from 'axios';
const NOTIFICATION_TIMEOUT = 6000;

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      managerId: 0,
      tenantId: 0,
      users: [
        // {
        //   id: 1001,
        //   userName: 'admin1',
        //   role: 'ROLE_ADMIN',
        //   activated: true
        // },
        // {
        //   id: 1002,
        //   userName: 'admin2',
        //   role: 'ROLE_ADMIN',
        //   activated: true
        // },
        // {
        //   id: 1003,
        //   userName: 'harry',
        //   role: 'ROLE_USER',
        //   activated: true
        // },
        // {
        //   id: 1004,
        //   userName: 'neville',
        //   role: 'ROLE_USER',
        //   activated: true
        // },
        // {
        //   id: 1005,
        //   userName: 'ron',
        //   role: 'ROLE_USER',
        //   activated: true
        // },
        // {
        //   id: 1006,
        //   userName: 'hermione',
        //   role: 'ROLE_USER',
        //   activated: true
        // },
      ],
      applications:[
        {
        applicationId: 5001,
        userId: 1004,
        propertyId: 4001,
        status: 'STATUS_PENDING',
        hasRoomates: false,
        roomateNames: null
      },
      {
        applicationId: 5002,
        userId: 1004,
        propertyId: 4001,
        status: 'STATUS_WITHDRAWN',
        hasRoomates: true,
        roomateNames: 'Luna Lovegood'}
    ],
    serviceRequests: [
      // {
      //   serviceRequestId: 6001,
      //   requestDetails: 'Plumbing needed',
      //   status: 'STATUS_COMPLETE'  
      // },
      // {
      //   serviceRequestId: 6002,
      //   requestDetails: 'Exterminator needed',
      //   status: 'STATUS_IN_PROGRESS',  
      // },
      // {
      //   serviceRequestId: 6003,
      //   requestDetails: 'Stove burner needs fixing',
      //   status: 'STATUS_OPEN'  
      // }
    ],
    rentTransactions: [
      // {
      //   rentTransactionId: 7001,
      //   amount: 2500.00,
      //   dueDate: '2023-01-01',
      //   pastDue: false
      // },
      // {
      //   rentTransactionId: 7002,
      //   amount: 2500.00,
      //   dueDate: '2023-01-01',
      //   pastDue: false
      // },
      // {
      //   rentTransactionId: 7003,
      //   amount: 1500.00,
      //   dueDate: '2023-01-01',
      //   pastDue: true
      // }
    ],
      properties: [
      // {
      //   propertyId: 4001,
      //   managerId: 2001,
      //   numberOfRooms: 3,
      //   rent: 5000.00,
      //   isAvailable: true,
      // },
      // {
      //   propertyId: 4002,
      //   managerId: 2001,
      //   numberOfRooms: 2,
      //   rent: 3500.00,
      //   isAvailable: false,
      // },
      // {
      //   propertyId: 4004,
      //   managerId: 2001,
      //   numberOfRooms: 4,
      //   rent: 5000.00,
      //   isAvailable: true,
      // },
      ],
      myProperties: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_AVAILABILITY_STATUS(state, payload) {
        payload.property.isAvailable = payload.value;
      },
      SET_PROPERTIES(state, properties) {
        state.properties = properties;
      },
      SET_SERVICE_REQUEST(state, serviceRequests){
        state.serviceRequests = serviceRequests;
      },
      SET_RENT_TRANSACTION(state, rentTransactions) {
        state.rentTransactions = rentTransactions;
      },
      SET_MANAGER_ID(state, managerId) {
        state.managerId = managerId;
      },
      SET_TENANT_ID(state, tenantId) {
        state.tenantId = tenantId;
      },
      SET_IS_PAID(state, rentTransaction) {
        rentTransaction.pastDue = ! rentTransaction.pastDue;
      },
      SAVE_PROPERTY(state, property) {
        state.properties.push(property);
      },
      SET_NOTIFICATION(state, notification) {
        if (state.notification) {
          this.commit('CLEAR_NOTIFICATION');
        }
        if (typeof notification === 'string') {
          notification = {
            message: notification,
            type: 'error',
            timeout: NOTIFICATION_TIMEOUT
          }
        } else {
          notification.type = notification.type || 'error';
          notification.timeout = notification.timeout || NOTIFICATION_TIMEOUT;
        }
        state.notification = notification;
        notification.timer = window.setTimeout(() => {
          this.commit('CLEAR_NOTIFICATION');
        }, notification.timeout);
      },
      CLEAR_NOTIFICATION(state) {
        if (state.notification && state.notification.timer) {
          window.clearTimeout(state.notification.timer);
        }
        state.notification = null;
    },
    },
  });
  return store;
}
