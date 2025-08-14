<template>
    <section class="container row-g3"
        style="background-color: transparent; max-width: 100%; margin-top: 0; padding-top: 0;">
        <div class="row">
            <aside class="col-sm-4 p-5 rounded-3"
                style="background-color: rgba(0, 0, 0, 0.7); margin-top: 50px; margin-bottom: 50px;">

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
                                    <button @click="audioPlay(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-play-fill"></i>
                                    </button>
                                    <button @click="favoritesStore.removeFavorite(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
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
                                    <img :src="artist.image" alt="" style="width: 75px; height: 75px; object-fit: cover;"
                                        class="rounded-circle" />
                                    <span>{{ artist.title }}</span>
                                </div>
                                <div class="d-flex gap-2">
                                    
                                    <button @click="favoritesStore.removeFavoriteArtist(artist)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-dash"></i>
                                    </button>
                                </div>
                            </li>
                            <li v-if="favoriteArtists.length === 0" class="list-group-item text-center text-muted">Chưa có
                                nghệ sĩ yêu thích</li>
                        </ul>
                    </div>
                </div>


            </aside>
            <article class="col-sm-8 p-5">

                <div id="carouselExample" class="carousel slide carousel-fade" data-bs-ride="carousel"
                    data-bs-interval="5000">
                    <div class="carousel-inner">
                        <div v-for="(slide, index) in carouselSlides" :key="index"
                            :class="['carousel-item', { active: index === 0 }]">
                            <div class="carousel-img-wrapper">
                                <router-link :to="`/song/${slide.id}`">
                                    <img :src="slide.image" class="carousel-img d-block w-100"
                                        :alt="'Ảnh ' + (index + 1)" />
                                </router-link>
                                <div class="caption">{{ slide.title }}</div>
                            </div>
                        </div>
                    </div>
                    <!-- Điều khiển trái/phải -->
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    </button>

                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExample"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    </button>
                </div>

                <br>
                <h2 class="mb-3" style="color: #42399f;">Bài hát nổi bật</h2>
                <div class="card p-3" style="background-color: rgba(0, 0, 0, 0.7); color: #fff;">
                    <div class="d-flex flex-wrap gap-3 justify-content-start">
                        <div v-for="(song, index) in songs" :key="index" class="text-center" style="width: 200px;">
                            <router-link :to="`/song/${song.id}`">
                                <img :src="song.image" :alt="song.title"
                                    style="width: 150px; height: 150px; object-fit: cover; cursor: pointer;"
                                    class="rounded-circle mb-2" />
                            </router-link>
                            <p class="card-text fs-5">{{ song.title }}</p>
                            <button @click="audioPlay(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                <i class="bi bi-play-fill"></i>
                            </button>
                            <button @click="addToFavorites(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                <i class="bi bi-plus"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <br>
                <h2 class="mb-3" style="color: #42399f;">Nghệ sĩ nổi bật</h2>
                <div class="card p-3" style="background-color: rgba(0, 0, 0, 0.7); color: #fff;">
                    <div class="d-flex flex-wrap gap-3 justify-content-start">
                        <div v-for="(artist, index) in artists" :key="index" class="text-center" style="width: 200px;">
                            <router-link :to="`/artist/${artist.id}`">
                                <img :src="artist.image" :alt="artist.title"
                                    style="width: 150px; height: 150px; object-fit: cover; cursor: pointer;"
                                    class="rounded-circle mb-2" />
                            </router-link>
                            <p class="card-text fs-5">{{ artist.title }}</p>
                            <button @click="addArtists(artist)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                    class="bi bi-plus"></i> </button>
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
import img2 from '../assets/images/taylorswiftlover.jpg'
import img3 from '../assets/images/harudorobou.jpg'
import img4 from '../assets/images/lovesickgirls.jpg'
import img5 from '../assets/images/tadakiminihare.jpg'
import img6 from '../assets/images/whatislove.jpg'
import img7 from '../assets/images/lovestory.png'
import img8 from '../assets/images/bacbling.jpg'
import img9 from '../assets/images/yorushika.jpg'
import img10 from '../assets/images/taylorswift.jpg'
import img11 from '../assets/images/blackpink.jpg'
import img12 from '../assets/images/ado.jpg'
import img13 from '../assets/images/tadakiminihare.jpg'
import img14 from '../assets/images/lovestory.png'
import img15 from '../assets/images/bacbling.jpg'
import img16 from '../assets/images/yorushika.jpg'
import img17 from '../assets/images/taylorswift.jpg'
import img18 from '../assets/images/ado.jpg'
import img19 from '../assets/music/ヨルシカ - ただ君に晴れ (MUSIC VIDEO) - ヨルシカ _ n-buna Official.mp3'
import img20 from '../assets/music/TWICE What is Love M_V - JYP Entertainment.mp3'
import img21 from '../assets/music/Taylor Swift - Love Story - TaylorSwiftVEVO.mp3'
import img22 from '../assets/music/BẮC BLING (BẮC NINH)  OFFICIAL MV  HOÀ MINZY ft NS XUÂN HINH x MASEW x TUẤN CRY - Hòa Minzy.mp3'
const items = ref([
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
    { image: img18 }
])

const carouselSlides = ref([
    { id: 1, image: img2, title: 'Cruel Summer' },
    { id: 2, image: img3, title: '春泥棒' },
    { id: 3, image: img4, title: 'Lovesick Girls' }
])

import { computed } from 'vue'

// Nhận prop từ component cha
const props = defineProps({
    item: {
        type: Array,
        required: true
    }
})

// Tính toán danh sách bài hát hiển thị
const songs = computed(() => [
    { id: 4, image: img5, title: 'ただ君に晴れ', audio: img19 },
    { id: 5, image: img6, title: 'What is Love?', audio:  img20},
    { id: 6, image: img7, title: 'Love Story', audio:  img21},
    { id: 7, image: img8, title: 'Bắc Bling', audio:  img22}
])

const artists = computed(() => [
    { id: 1, image: img9, title: 'ヨルシカ' },
    { id: 2, image: img10, title: 'Taylor Swift' },
    { id: 3, image: img11, title: 'BLACKPINK' },
    { id: 4, image: img12, title: 'Ado' }
])

import { useFavoritesStore } from '../favorites.js'
import { usePlayerStore } from '../player.js'

const audioPlayer = usePlayerStore()
function audioPlay(song) {
  audioPlayer.playSong(song)
}
const favoritesStore = useFavoritesStore()
const favoriteSongs = computed(() => favoritesStore.favorites)
const favoriteArtists = computed(() => favoritesStore.favoriteArtist)

function addToFavorites(song) {
  favoritesStore.addFavorite(song)
}

function addArtists(artist) {
  favoritesStore.addFavoriteArtist(artist)
}
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

.carousel-img-wrapper {
    position: relative;
    overflow: hidden;
    border-radius: 20px;
    box-shadow: 0 10px 30px rgba(63, 61, 86, 0.25);

    height: 400px;
    /* Cố định chiều cao */
}

.carousel-img {
    border: 4px solid #ff38ca;
    border-radius: 20px;
    transition: transform 2s ease;

    width: 100%;
    height: 100%;
    /* cho ảnh đầy container */
    object-fit: cover;
    /* giữ tỉ lệ, cắt nếu cần */
}

/* Hiệu ứng zoom khi ảnh active */
.carousel-item.active .carousel-img {
    transform: scale(1.05);
}

/* Caption mờ lên từ dưới */
.caption {
    position: absolute;
    bottom: 20px;
    left: 30px;
    font-size: 2rem;
    font-weight: 700;
    font-family: 'Pacifico', cursive;
    color: #ff38ca;
    /* Màu hồng nổi bật */
    background-color: rgba(0, 0, 0, 0.6);
    /* Nền tối hơn */
    padding: 8px 16px;
    border-radius: 10px;
    text-shadow: 3px 3px 8px rgba(0, 0, 0, 0.95);
    /* Bóng chữ đậm hơn */
    animation: fadeInUp 1.2s ease forwards;
    opacity: 0;
    -webkit-text-fill-color: unset;
}

.carousel-item.active .caption {
    opacity: 1;
}

@keyframes fadeInUp {
    0% {
        opacity: 0;
        transform: translateY(20px);
    }

    100% {
        opacity: 1;
        transform: translateY(0);
    }
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