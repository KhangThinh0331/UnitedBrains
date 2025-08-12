import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/index.vue'
import Songs from './components/Song.vue'
import Artists from './components/Artist.vue'
import Account from './components/LoginForm.vue'
import Premium from './components/Premium.vue'
import SongDetail from './components/SongDetail.vue'
import ArtistDetail from './components/ArtistDetail.vue'

const routes = [
{ path: '/', component: Home },
{ path: '/songs', component: Songs },
{ path: '/artists', component: Artists },
{ path: '/account', component: Account },
{ path: '/premium', component: Premium },
{ path: '/song/:id', component: SongDetail },
{ path: '/artist/:id', component: ArtistDetail }
]

const router = createRouter({
history: createWebHistory(),
routes
})

export default router