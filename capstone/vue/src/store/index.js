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
      showManagerPOV: false,
      users: [],
      applications:[],
      serviceRequests: [],
      rentTransactions: [],
      properties: [],
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
      SET_SHOW_MANAGER_POV(state, showManagerPOV) {
        state.showManagerPOV = showManagerPOV;
      },
      SET_AVAILABILITY_STATUS(state, payload) {
        payload.property.isAvailable = payload.value;
      },
      SET_PROPERTIES(state, properties) {
      
        state.properties = properties;
      },
      SET_MY_PROPERTIES(state, myProperties) {
        state.myProperties = myProperties;
      },
      SET_SERVICE_REQUEST(state, serviceRequests){
        state.serviceRequests = serviceRequests;
      },
      SET_APPLICATION(state, applications){
        state.applications = applications;
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
