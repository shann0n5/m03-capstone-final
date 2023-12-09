import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      users: [
        {
          id: 1001,
          userName: 'admin1',
          role: 'ROLE_ADMIN',
          activated: true
        },
        {
          id: 1002,
          userName: 'admin2',
          role: 'ROLE_ADMIN',
          activated: true
        },
        {
          id: 1003,
          userName: 'harry',
          role: 'ROLE_USER',
          activated: true
        },
        {
          id: 1004,
          userName: 'neville',
          role: 'ROLE_USER',
          activated: true
        },
        {
          id: 1005,
          userName: 'ron',
          role: 'ROLE_USER',
          activated: true
        },
        {
          id: 1006,
          userName: 'hermione',
          role: 'ROLE_USER',
          activated: true
        },
        {
          id: 1007,
          userName: 'ginny',
          role: 'ROLE_USER',
          activated: true
        }
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
      {
        serviceRequestId: 6001,
        requestDetails: 'Plumbing needed',
        status: 'STATUS_COMPLETE'  
      },
      {
        serviceRequestId: 6002,
        requestDetails: 'Exterminator needed',
        status: 'STATUS_IN_PROGRESS',  
      },
      {
        serviceRequestId: 6003,
        requestDetails: 'Stove burner needs fixing',
        status: 'STATUS_OPEN'  
      }
    ],
    rentTransactions: [
      {
        transactionId: 7001,
        amount: 2500.00,
        dueDate: '2023-01-01',
        pastDue: false
      },
      {
        transactionId: 7002,
        amount: 2500.00,
        dueDate: '2023-01-01',
        pastDue: false
      },
      {
        transactionId: 7003,
        amount: 1500.00,
        dueDate: '2023-01-01',
        pastDue: true
      }
    ],
      properties: [
      {
        propertyId: 4001,
        managerId: 2001,
        numberOfRooms: 3,
        rent: 5000.00,
        isAvailable: true,
        isOwner: true
      },
      {
        propertyId: 4002,
        managerId: 2001,
        numberOfRooms: 2,
        rent: 3500.00,
        isAvailable: false,
        isOwner: true
      },
      {
        propertyId: 4003,
        managerId: 2002,
        numberOfRooms: 1,
        rent: 1500.00,
        isAvailable: false,
        isOwner: true
      }
      ]
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
      SAVE_PROPERTY(state, property) {
        state.properties.push(property);
      }
    },
  });
  return store;
}
