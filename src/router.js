import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/index.vue'
import Songs from './components/Song.vue'
import Artists from './components/Artist.vue'
import Account from './components/LoginForm.vue'

const routes = [
{ path: '/', component: Home },
{ path: '/songs', component: Songs },
{ path: '/artists', component: Artists },
{ path: '/account', component: Account }
]

const router = createRouter({
history: createWebHistory(),
routes
})

export default router