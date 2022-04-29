import { createApp } from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css";
import routes from './routes'
 

createApp(App).use(routes).mount('#app')
