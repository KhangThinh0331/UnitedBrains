// src/stores/authStore.js
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { auth, provider, signInWithPopup, signOut } from './firebase'
import { onAuthStateChanged } from 'firebase/auth'
import router from './router'

export const useAuthStore = defineStore('auth', () => {
  const user = ref(null)

  const loginWithGoogle = async () => {
    try {
      const result = await signInWithPopup(auth, provider)
      user.value = {
        displayName: result.user.displayName,
        email: result.user.email,
        photoURL: result.user.photoURL,
        uid: result.user.uid
      }
      router.push('/')
    } catch (error) {
      console.error('Lỗi đăng nhập:', error)
    }
  }

  const logout = async () => {
    await signOut(auth)
    user.value = null
    router.push('/account')
  }

  // Lắng nghe trạng thái đăng nhập khi load trang
  onAuthStateChanged(auth, (firebaseUser) => {
    if (firebaseUser) {
      user.value = {
        displayName: firebaseUser.displayName,
        email: firebaseUser.email,
        photoURL: firebaseUser.photoURL,
        uid: firebaseUser.uid
      }
    } else {
      user.value = null
    }
  })

  return { user, loginWithGoogle, logout }
})