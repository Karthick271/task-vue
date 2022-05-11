import {createWebHistory,createRouter} from 'vue-router'
import HomePage from "./components/HomePage"
import Login from "./components/UserLogin"
  const  routes = [
  {
    name : 'HomePage',
    path: '/',
    component: HomePage,
  },
  { name : 'UserLogin',path : '/login' , component :  Login},
]

const  router = createRouter({
  history : createWebHistory(),
  routes
})

export default router
