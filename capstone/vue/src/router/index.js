import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import AvailablePropertiesView from '../views/AvailablePropertiesView.vue'
import ContactUsView from '../views/ContactUsView.vue';
import QualificationsView from '../views/QualificationsView.vue'
import AboutUsView from '../views/AboutUsView.vue';
import ApplicationView from '../views/ApplicationView.vue';
import TenantMainPageView from '../views/TenantMainPageView.vue';
import ServiceRequestView from '../views/ServiceRequestView.vue';
import ServiceRequestFormView from '../views/AddServiceRequestView.vue'
import RentTransactionsView from '../views/RentTransactionsView.vue';
import RentTransactionFormView from '../views/RentTransactionFormView.vue';
import PropertyManagerMainView from '../views/PropertyManagerMainView.vue';
import NewPropertyFormView from '../views/NewPropertyFormView.vue';
import PropertyDetailsView from '../views/PropertyDetailsView.vue';


/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/available-properties",
    name: "availableProperties",
    component: AvailablePropertiesView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/contact-us",
    name: "contactUs",
    component: ContactUsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/qualifications",
    name: "qualifications",
    component: QualificationsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/application",
    name: "application",
    component: ApplicationView
  },
  {
    path: "/about-us",
    name: "aboutUs",
    component: AboutUsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/home/tenant-main-page",
    name: "tenantMainPage",
    component: TenantMainPageView,
     meta: {
      requiresAuth: false
     }
  },
  {
    path: "/service-request-view",
    name: "serviceRequest",
    component: ServiceRequestView,
    meta:{
      requiresAuth: false
    }
  },
  {
    path: "/rent-transaction-view",
    name: "rentTransaction",
    component: RentTransactionsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/service-request/create",
    name:"addServiceRequest",
    component: ServiceRequestFormView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/rent-transaction/create",
    name: "createRentTransaction",
    component: RentTransactionFormView,
    meta: {
      requiresAuth: false
    }
  },
    {
      path: "/property-manager-main-view",
      name: "propertyManagerMainPage",
      component: PropertyManagerMainView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties/create",
      name: "addProperty",
      component: NewPropertyFormView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/property-details/:propertyId",
      name: "propertyDetails",
      component: PropertyDetailsView,
      meta: {
        requiresAuth: false
      }
    }

];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
