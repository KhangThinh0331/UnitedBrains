<template>
  <div v-show="player.currentSong" class="audio-player fixed-bottom w-100 bg-dark text-white p-2 d-flex align-items-center">
    <img :src="player.currentSong?.image" alt="" style="width:50px;height:50px;object-fit:cover;border-radius:5px;">
    <div class="mx-3 flex-grow-1">
      <p class="mb-0">{{ player.currentSong?.title }}</p>
      <input type="range" min="0" :max="duration" step="1" v-model="currentTime" class="w-100" />
      <div class="d-flex justify-content-between" style="font-size: 0.8rem;">
        <span>{{ formatTime(currentTime) }}</span>
        <span>{{ formatTime(duration) }}</span>
      </div>
    </div>
    <button @click="togglePlay" class="btn btn-sm btn-primary ms-2">
      {{ player.isPlaying ? 'Pause' : 'Play' }}
    </button>
    <audio ref="audio" :src="player.currentSong?.audio"></audio>
  </div>
</template>

<script setup>
import { ref, watch, nextTick } from 'vue'
import { usePlayerStore } from '../player'

const player = usePlayerStore()
const audio = ref(null)
const currentTime = ref(0)
const duration = ref(0)

watch(() => player.currentSong, async () => {
  if (!player.currentSong) return
  await nextTick()  // đợi DOM render xong
  if (!audio.value) return

  audio.value.src = player.currentSong.audio
  audio.value.load()
  audio.value.play().catch(() => console.log('User interaction needed'))

  // Gắn event listener mỗi lần bài mới được set
  audio.value.ontimeupdate = () => {
    currentTime.value = Math.floor(audio.value.currentTime)
  }
  audio.value.onloadedmetadata = () => {
    duration.value = Math.floor(audio.value.duration)
  }
})

// Play / Pause
watch(() => player.isPlaying, () => {
  if (!audio.value) return
  if (player.isPlaying) audio.value.play().catch(() => {})
  else audio.value.pause()
})

// Cập nhật progress

function togglePlay() {
  player.togglePlay()
}

function formatTime(seconds) {
  const m = Math.floor(seconds / 60).toString().padStart(2, '0')
  const s = Math.floor(seconds % 60).toString().padStart(2, '0')
  return `${m}:${s}`
}
</script>

<style scoped>
.audio-player {
  box-shadow: 0 -2px 5px rgba(0,0,0,0.2);
}
input[type="range"] {
  -webkit-appearance: none;
  background: #555;
  height: 4px;
  border-radius: 2px;
}
input[type="range"]::-webkit-slider-thumb {
  -webkit-appearance: none;
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: #ffcc00;
  cursor: pointer;
}
</style>