import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useFavoritesStore = defineStore('favorites', () => {
  const favorites = ref([])

  function addFavorite(song) {
    if (!favorites.value.find(item => item.id === song.id)) {
      favorites.value.push(song)
    }
  }

   function removeFavorite(song) {
    favorites.value = favorites.value.filter(item => item.id !== song.id)
  }

  return { favorites, addFavorite, removeFavorite }
})