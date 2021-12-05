import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/owner',
    name: 'Owner',
    component: () => import('../views/Owner.vue')
  },
  {
    path: '/vet',
    name: 'Vet',
    component: () => import('../views/Vet.vue')
  },
  {
    path: '/official',
    name: 'Official',
    component: () => import('../views/Official.vue')
  },
  {
    path: '/petCase',
    name: 'PetCase',
    component: () => import('../views/PetCase.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
