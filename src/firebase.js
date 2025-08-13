// src/firebase.js
import { initializeApp } from "firebase/app";
import { getAuth, GoogleAuthProvider, signInWithPopup, signOut } from "firebase/auth";

// Config của bạn từ Firebase Console
const firebaseConfig = {
  apiKey: "AIzaSyAeZZOUcgT_cu5zLqs-4rDYdeIXAFmOKqs",
  authDomain: "asm-sof308-f5f35.firebaseapp.com",
  projectId: "asm-sof308-f5f35",
  storageBucket: "asm-sof308-f5f35.firebasestorage.app",
  messagingSenderId: "1096238927876",
  appId: "1:1096238927876:web:21dc60afed2880f5af2551",
  measurementId: "G-H2C419Y4MC"
};

// Khởi tạo Firebase
const app = initializeApp(firebaseConfig)
const auth = getAuth(app)
const provider = new GoogleAuthProvider()

export { auth, provider, signInWithPopup, signOut }