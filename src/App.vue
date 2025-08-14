<template>
  <div class="container-fluid">
    <nav class="navbar navbar-expand-sm">
      <div class="container-fluid">
        <router-link class="navbar-brand" to="/">
          <img src="./assets/images/musicLogo.png" alt="Logo" style="width: 100px; border-radius: 50px;" />
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav me-auto">
            <li class="nav-item">
              <router-link class="nav-link" to="/songs">
                <i class="fa-solid fa-film"></i> Bài hát
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/artists">
                <i class="fa-solid fa-circle-info"></i> Nghệ sĩ
              </router-link>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle text-dark" href="#" role="button" data-bs-toggle="dropdown">
                <i class="fa-solid fa-user"></i>
                <span v-if="authStore.user">{{ authStore.user.displayName }}</span>
                <span v-else>Tài khoản</span>
              </a>
              <ul class="dropdown-menu">
                <li v-if="!authStore.user">
                  <router-link class="dropdown-item" to="/account">Đăng nhập</router-link>
                </li>
                <li v-else>
                  <button class="dropdown-item" @click="authStore.logout">Đăng xuất</button>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <router-link class="btn btn-light rounded-pill fw-bold premium-btn" to="/premium">
                Khám phá Premium
              </router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <router-view />
    <footer class="footer mt-auto py-4">
      <div class="container text-center text-white">
        <div class="mb-2">
          <a href="#" class="text-white mx-2"><i class="fab fa-facebook-f"></i></a>
          <a href="#" class="text-white mx-2"><i class="fab fa-instagram"></i></a>
          <a href="#" class="text-white mx-2"><i class="fab fa-twitter"></i></a>
          <a href="#" class="text-white mx-2"><i class="fab fa-youtube"></i></a>
        </div>
        <p class="mb-0">&copy; 2025 Music App. All rights reserved.</p>
        <small>Designed with ❤️ for music lovers</small>
      </div>
    </footer>
  </div>
  <Audio />
</template>

<script setup>
import { useAuthStore } from './authStore' // đường dẫn tới store của bạn
const authStore = useAuthStore()
import Audio from './components/AudioPlayer.vue'
</script>

<style scoped>
body {
  font-family: 'Poppins', sans-serif;
  /* background-color: #f4f4f9; */
  color: #333;
}

.navbar {
  background-color: rgba(0, 0, 0, 0.5);
  /* background-color: #3f3d56 !important; */
  font-size: large;
  border-radius: 20px;
  margin-top: 10px;
}

.navbar-brand{
  /* height: 50px;
  width: 50px; */
}

.nav-link{
  margin-left: 10px;
}

.nav-link,
.dropdown-item {
  color: #ffffff !important;
}

.nav-item{
  margin-left: 10px;
}

.dropdown-menu {
  background-color: #3f3d56 !important;
  font-size: large;
}

.premium-btn {
  transition: transform 0.3s ease, background-color 0.3s ease;
}

.premium-btn:hover {
  transform: scale(1.05);
}

.footer {
  background-color: rgba(0, 0, 0, 0.5);
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-bottom: 8px;
  border-radius: 20px;
  height: 120px;
}

.footer .social-links {
  display: flex;
  gap: 20px; /* Khoảng cách giữa các icon */
  margin-bottom: 10px;
  align-items: center;
  justify-content: center;
}

.footer a {
  color: #ffffff;
  transition: transform 0.3s ease, color 0.3s ease;
  font-size: 1.3rem;
}

.footer a:hover {
  color: #ffcc00;
  transform: scale(1.2);
}

.footer p,
.footer small {
  margin: 2px 0;
  color: #ffffff;
}
</style>
