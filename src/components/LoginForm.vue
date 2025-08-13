<template>
  <section>
    <div v-if="!authStore.user" class="login-container">
      <h3>Đăng Nhập</h3>
      <button type="button" class="btn btn-google w-100" @click="authStore.loginWithGoogle">
        <i class="fab fa-google me-2"></i> Đăng nhập bằng Google
      </button>
    </div>
  </section>
</template>

<script setup>
import { useAuthStore } from '../authStore'
const authStore = useAuthStore()
</script>

<style scoped>
.login-container {
  background-color: #e5e2ff;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 0 20px #5659fd7c;
  max-width: 700px; /* tăng chiều ngang */
  margin: 50px auto;
  color: #3f3d56;
  font-weight: bold;
}

h3 {
  color: #42399f;
  font-weight: 600;
  text-align: center;
  margin-bottom: 30px;
}

.btn-google {
  background-color: #fff;
  color: #444;
  border: 1px solid #ddd;
  padding: 15px 30px; /* to hơn cho cân đối */
  border-radius: 8px;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 18px;
}

.btn-google:hover {
  background-color: #f5f5f5;
}

.btn-google i {
  color: #db4437;
  font-size: 20px;
}
</style>
