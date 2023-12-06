import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      users: [
        {
          userId: 1001,
          userName: 'admin1',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_ADMIN'
        },
        {
          userId: 1002,
          userName: 'admin2',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ADMIN'
        },
        {
          userId: 1003,
          userName: 'harry',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_USER'
        },
        {
          userId: 1004,
          userName: 'neville',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_USER'
        },
        {
          userId: 1005,
          userName: 'ron',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_USER'
        },
        {
          userId: 1006,
          userName: 'hermione',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_USER'
        },
        {
          userId: 1007,
          userName: 'ginny',
          passwordHash: '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
          role: 'ROLE_USER'
        }
      ],
      applications:[
        {
        applicationId: 3001,
        userId: 1004,
        propertyId: 2001,
        status: 'STATUS_PENDING',
        has_roomates: false,
        roomate_names: null
      },
      {
        applicationId: 3002,
        userId: 1004,
        propertyId: 2001,
        status: 'STATUS_WITHDRAWN',
        has_roomates: true,
        roomate_names: 'Luna Lovegood'}
    ],
    serviceRequests: [
      {
        serviceRequestId: 4001,
        request_details: 'Plumbing needed',
        status: 'STATUS_COMPLETE'  
      },
      {
        serviceRequestId: 4002,
        request_details: 'Exterminator needed',
        status: 'STATUS_IN_PROGRESS',  
      },
      {
        serviceRequestId: 4003,
        request_details: 'Stove burner needs fixing',
        status: 'STATUS_OPEN'  
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
      }
    },
  });
  return store;
}
