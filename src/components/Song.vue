<template>
    <section class="container row-g3"
        style="background-color: #f2f1ff; max-width: 100%; margin-top: 0; padding-top: 0;">
        <div class="row">
            <aside class="col-sm-4 p-5 rounded-3"
                style="background-color: #3f3d56; margin-top: 50px; margin-bottom: 50px;">

                <!-- Tabs -->
                <ul class="nav nav-tabs" id="favoriteTabs" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="songs-tab" data-bs-toggle="tab" data-bs-target="#songs"
                            type="button" role="tab" aria-controls="songs" aria-selected="true">
                            Bài hát yêu thích
                        </button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="artists-tab" data-bs-toggle="tab" data-bs-target="#artists"
                            type="button" role="tab" aria-controls="artists" aria-selected="false">
                            Nghệ sĩ yêu thích
                        </button>
                    </li>
                </ul>

                <!-- Tab Content -->
                <div class="tab-content mt-3" id="favoriteTabsContent">

                    <!-- Tab 1: Bài hát yêu thích -->
                    <div class="tab-pane fade show active" id="songs" role="tabpanel" aria-labelledby="songs-tab">
                        <ul class="list-group">
                            <li v-for="song in favoriteSongs" :key="song.id"
                                class="list-group-item d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center gap-3">
                                    <img :src="song.image" alt="" style="width: 75px; height: 75px; object-fit: cover;"
                                        class="rounded-circle" />
                                    <span>{{ song.title }}</span>
                                </div>
                                <div class="d-flex gap-2">
                                    <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-play-fill"></i>
                                    </button>
                                    <button @click="favoritesStore.removeFavorite(song)"
                                        class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-dash"></i>
                                    </button>
                                </div>
                            </li>
                            <li v-if="favoriteSongs.length === 0" class="list-group-item text-center text-muted">Chưa có
                                bài hát yêu thích</li>
                        </ul>
                    </div>

                    <!-- Tab 2: Nghệ sĩ yêu thích -->
                    <div class="tab-pane fade" id="artists" role="tabpanel" aria-labelledby="artists-tab">
                        <ul class="list-group">
                            <li v-for="artist in favoriteArtists" :key="artist.id"
                                class="list-group-item d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center gap-3">
                                    <img :src="artist.image" alt=""
                                        style="width: 75px; height: 75px; object-fit: cover;" class="rounded-circle" />
                                    <span>{{ artist.title }}</span>
                                </div>
                                <div class="d-flex gap-2">

                                    <button @click="favoritesStore.removeFavoriteArtist(artist)"
                                        class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-dash"></i>
                                    </button>
                                </div>
                            </li>
                            <li v-if="favoriteArtists.length === 0" class="list-group-item text-center text-muted">Chưa
                                có
                                nghệ sĩ yêu thích</li>
                        </ul>
                    </div>
                </div>


            </aside>
            <article class="col-sm-8 p-5">
                <div class="input-group mb-3 custom-search">
                    <span class="input-group-text border-0 bg-transparent text-white">
                        <i class="bi bi-search"></i>
                    </span>
                    <input type="text" class="form-control custom-search-input" placeholder="Tìm kiếm bài hát..."
                        v-model="searchQuery" />
                </div>
                <h2 class="mb-3" style="color: #42399f;">Danh sách bài hát</h2>
                <div class="card p-3" style="background-color: #3f3d56; color: #fff;">
                    <div class="d-flex flex-wrap gap-3 justify-content-start">
                        <div v-for="(song, index) in filteredSongs" :key="index" class="text-center"
                            style="width: 200px;">
                            <router-link :to="`/song/${song.id}`">
                                <img :src="song.image" :alt="song.title"
                                    style="width: 150px; height: 150px; object-fit: cover; cursor: pointer;"
                                    class="rounded-circle mb-2" />
                            </router-link>
                            <p class="card-text fs-5">{{ song.title }}</p>
                            <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                <i class="bi bi-play-fill"></i>
                            </button>
                            <button @click="addToFavorites(song)" class="btn rounded-circle pink-button"
                                style="width: 40px; height: 40px;">
                                <i class="bi bi-plus"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </section>
</template>

<script setup>
import { ref } from 'vue'
import img1 from '../assets/images/musicLogo.png'
import img2 from '../assets/images/tadakiminihare.jpg'
import img3 from '../assets/images/lovestory.png'
import img4 from '../assets/images/bacbling.jpg'
import img5 from '../assets/images/yorushika.jpg'
import img6 from '../assets/images/taylorswift.jpg'
import img7 from '../assets/images/ado.jpg'
import img8 from '../assets/images/haru.png'
import img9 from '../assets/images/idol.jpg'
import img10 from '../assets/images/ussewa.jpg'
import img11 from '../assets/images/show.jpg'
import img12 from '../assets/images/gurenge.jpg'
import img13 from '../assets/images/yorunikakeru.jpg'
import img14 from '../assets/images/lionheart.jpg'
import img15 from '../assets/images/unstoppable.jpg'
import img16 from '../assets/images/blankspace.jpg'
import img17 from '../assets/images/legendsneverdie.jpg'
import img18 from '../assets/images/hope.jpg'
import img19 from '../assets/images/youdidntknow.jpg'
const item = ref([
    { image: img1 },
    { image: img2 },
    { image: img3 },
    { image: img4 },
    { image: img5 },
    { image: img6 },
    { image: img7 },
    { image: img8 },
    { image: img9 },
    { image: img10 },
    { image: img11 },
    { image: img12 },
    { image: img13 },
    { image: img14 },
    { image: img15 },
    { image: img16 },
    { image: img17 },
    { image: img18 },
    { image: img19 }
])

const songs = ref([
    { id: 8, image: img8, title: '晴る' },
    { id: 9, image: img9, title: 'アイドル' },
    { id: 10, image: img10, title: 'うっせぇわ' },
    { id: 11, image: img11, title: 'Show' },
    { id: 12, image: img12, title: '紅蓮華' },
    { id: 13, image: img13, title: '夜に駆ける' },
    { id: 14, image: img14, title: 'Lion Heart' },
    { id: 15, image: img15, title: 'Unstoppable' },
    { id: 16, image: img16, title: 'Blank Space' },
    { id: 17, image: img17, title: 'Legends Never Die' },
    { id: 18, image: img18, title: 'Hope Is the Thing With Feathers' },
    { id: 19, image: img19, title: 'You Didn’t Know' },
])

import { computed } from 'vue'
import { useFavoritesStore } from '../favorites.js'

const favoritesStore = useFavoritesStore()
const favoriteSongs = computed(() => favoritesStore.favorites)
const favoriteArtists = computed(() => favoritesStore.favoriteArtist)

function addToFavorites(song) {
    favoritesStore.addFavorite(song)
}

const searchQuery = ref('')

// Tạo danh sách đã lọc
const filteredSongs = computed(() => {
    const keyword = searchQuery.value.trim().toLowerCase()
    if (!keyword) return songs.value
    return songs.value.filter(song =>
        song.title.toLowerCase().includes(keyword)
    )
})
</script>

<style scoped>
.tab-content .container {
    max-width: 90% !important;
}

.container {
    margin-top: 40px;
}

h3 {
    color: #42399f;
    font-weight: 600;
    text-align: center;
    margin-bottom: 30px;
}

.custom-search {
    background-color: #3f3d56;
    border-radius: 12px;
    box-shadow: inset 0 0 0 1px #555;
    transition: box-shadow 0.3s ease, background-color 0.3s ease;
    height: 52px;
    /* Tăng chiều cao khung */
}

.custom-search:hover {
    box-shadow: 0 0 6px rgba(255, 255, 255, 0.2);
}

.custom-search-input {
    background-color: #3f3d56;
    color: white;
    border: none;
    border-radius: 0 12px 12px 0;
    height: 100%;
    /* Chiều cao bằng nhóm input */
    font-size: 1rem;
}

.custom-search-input:focus {
    outline: none;
    box-shadow: none;
    background-color: #484660;
    color: white;
}

.input-group-text {
    background-color: #3f3d56;
    border: none;
    border-radius: 12px 0 0 12px;
    height: 100%;
}

.input-group-text i {
    color: white;
    font-size: 1.2rem;
}

.custom-search-input::placeholder {
    color: white;
    opacity: 1;
    /* Đảm bảo không bị mờ nhạt */
}

.nav-tabs .nav-link.active {
    background-color: #ff38ca;
    color: #3f3d56;
    border: none;
    border-radius: 8px 8px 0 0;
}

.nav-tabs .nav-link {
    color: #ff38ca;
    font-weight: 500;
}

.carousel-item img {
    transition: transform 4s ease;
}

.carousel-item.active img {
    transform: scale(1.05);
}

.pink-button {
    background-color: #ffc0e0;
    border: none;
    transition: all 0.3s ease;
}

.pink-button i {
    color: #ff38ca;
    font-size: 1.2rem;
    transition: transform 0.3s ease, color 0.3s ease;
}

.pink-button:hover {
    background-color: #ffaad8;
    /* màu hồng đậm hơn khi hover */
    transform: scale(1.1);
    /* phóng to nhẹ toàn bộ nút */
}

.pink-button:hover i {
    color: #e60099;
    /* đổi màu icon khi hover */
    transform: scale(1.2);
    /* phóng to icon nhẹ */
}

.card img:hover {
    transform: scale(1.1);
    transition: transform 0.8s ease;
}

aside .list-group-item {
    background-color: #555272;
    color: white;
}

aside .list-group-item:hover {
    background-color: #726e97;
}
</style>