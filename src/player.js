import { defineStore } from 'pinia'
import { ref } from 'vue'

export const usePlayerStore = defineStore('player', () => {
  const currentSong = ref(null)  // bài đang phát
  const isPlaying = ref(false)

  function playSong(song) {
    currentSong.value = song
    isPlaying.value = true
  }

  function togglePlay() {
    isPlaying.value = !isPlaying.value
  }

  return { currentSong, isPlaying, playSong, togglePlay }
})