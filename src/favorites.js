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
    favorites.value = favorites.value.filter(item => String(item.id) !== String(song.id))
  }

  const favoriteArtist = ref([])

  function addFavoriteArtist(artist) {
    const exists = favoriteArtist.value.find(
      item => item.title.trim().toLowerCase() === artist.title.trim().toLowerCase()
    )
    if (!exists) {
      favoriteArtist.value.push(artist)
    }
  }

  function removeFavoriteArtist(artist) {
    favoriteArtist.value = favoriteArtist.value.filter(
      item => item.title?.trim().toLowerCase() !== artist.title?.trim().toLowerCase()
    )
  }

  return {
    favorites, addFavorite, removeFavorite,
    favoriteArtist, addFavoriteArtist, removeFavoriteArtist
  }
})