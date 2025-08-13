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
                <div class="card p-3" style="background-color: #3f3d56; color: #fff;">
                    <div v-if="artist" class="artist-detail"
                        style="display: flex; align-items: center; gap: 20px; margin-bottom: 20px;">
                        <img :src="artist.image" alt="" class="rounded"
                            style="width: 200px; height: 200px; object-fit: cover;" />
                        <div class="d-flex flex-row gap-3">
                            <button @click="addArtists(artist)" class="btn rounded-circle pink-button" style="width: 120px; height: 120px;">
                                <i class="bi bi-plus" style="font-size: 4rem;"></i>
                            </button>
                        </div>
                    </div>

                    <h2>{{ artist.name }}</h2>
                    <div>{{ artist.info }}</div>
                    <br />
                    <ul style="list-style: none; padding: 0;">
                        <li v-for="song in artist.songs" :key="song.id"
                            style="display: flex; align-items: center; gap: 10px; margin-bottom: 10px; padding: 5px 10px; border-radius: 6px; transition: background-color 0.3s;"
                            @mouseover="hover = song.id" @mouseleave="hover = null"
                            :style="{ backgroundColor: hover === song.id ? '#5a5a82' : 'transparent' }">
                            <img :src="song.image" alt="song image"
                                style="width: 60px; height: 60px; object-fit: cover; border-radius: 8px;" />
                            <span style="flex-grow: 1;">{{ song.title }}</span>
                            <div style="display: flex; gap: 6px;">
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                    <i class="bi bi-play-fill"></i>
                                </button>
                                <button @click="addToFavorites(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                    <i class="bi bi-plus"></i>
                                </button>
                            </div>
                        </li>
                    </ul>
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
import img8 from '../assets/images/taylorswift.jpg'
import img9 from '../assets/images/yorushika.jpg'
import img10 from '../assets/images/yoasobi.jpg'
import img11 from '../assets/images/ado.jpg'
import img12 from '../assets/images/lisa.jpg'
import img13 from '../assets/images/apple.jpg'
import img14 from '../assets/images/sia.jpg'
import img15 from '../assets/images/blackpink.jpg'
import img16 from '../assets/images/ariana.jpg'
import img17 from '../assets/images/snsd.jpg'
import img18 from '../assets/images/hope.jpg'
import img19 from '../assets/images/kda.jpg'
import img20 from '../assets/images/harudorobou.jpg'
import img21 from '../assets/images/lovesickgirls.jpg'
import img22 from '../assets/images/taylorswiftlover.jpg'
import img24 from '../assets/images/blankspace.jpg'
import img25 from '../assets/images/haru.png'
import img26 from '../assets/images/idol.jpg'
import img27 from '../assets/images/ussewa.jpg'
import img28 from '../assets/images/show.jpg'
import img29 from '../assets/images/gurenge.jpg'
import img30 from '../assets/images/yorunikakeru.jpg'
import img31 from '../assets/images/unstoppable.jpg'
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
    { image: img19 },
    { image: img20 },
    { image: img21 },
    { image: img22 },
    { image: img24 },
    { image: img25 },
    { image: img26 },
    { image: img27 },
    { image: img28 },
    { image: img29 },
    { image: img30 },
    { image: img31 }
])

import { useRoute } from 'vue-router'

const route = useRoute()
const artists = [
    {
        id: 1, image: img9, name: 'ヨルシカ', info: 'Yorushika (ヨルシカ) là một nhóm nhạc pop-rock Nhật Bản được thành lập vào năm 2017, gồm hai thành viên chính là n-buna (nhạc sĩ kiêm nhà sản xuất) và suis (ca sĩ chính). Nhóm nổi tiếng với giai điệu nhẹ nhàng, đầy cảm xúc cùng lời ca sâu sắc thường khai thác chủ đề về tình yêu, cuộc sống và những khía cạnh trăn trở của tuổi trẻ. Các ca khúc tiêu biểu như "Just a Sunny Day for You", "Say It." và "だから僕は音楽を辞めた". Yorushika nhanh chóng nhận được sự yêu mến lớn ở Nhật Bản cũng như quốc tế nhờ phong cách âm nhạc độc đáo và lời nhạc đậm chất thơ.',
        songs: [
            { id: 1, title: 'ただ君に晴れ', image: img2 },
            { id: 2, title: '春泥棒', image: img20 },
            { id: 3, title: '晴る', image: img25 }
            //...
        ]
    },
    { id: 2, image: img8, name: 'Taylor Swift', info: 'Taylor Swift là ca sĩ kiêm nhạc sĩ người Mỹ nổi tiếng toàn cầu, sinh năm 1989. Cô bắt đầu sự nghiệp với dòng nhạc country và nhanh chóng chuyển sang pop, tạo nên hàng loạt hit đình đám như Love Story, Shake It Off, Blank Space. Taylor được biết đến với khả năng kể chuyện qua lời ca khúc, phong cách đa dạng và liên tục đổi mới âm nhạc. Cô đã giành nhiều giải Grammy và là một trong những nghệ sĩ có ảnh hưởng lớn nhất thế giới.',
        songs: [
            { id: 1, title: 'Love Story', image: img3 },
            { id: 2, title: 'Cruel Summer', image: img22 },
            { id: 3, title: 'Blank Space', image: img24 }
        ]
     },
    { id: 3, image: img15, name: 'BLACKPINK', info: 'BLACKPINK là nhóm nhạc nữ Hàn Quốc gồm 4 thành viên: Jisoo, Jennie, Rosé và Lisa, ra mắt năm 2016 dưới công ty YG Entertainment. Nhóm nổi tiếng với phong cách âm nhạc kết hợp K-pop, hip-hop và EDM, sở hữu nhiều hit đình đám như Ddu-Du Ddu-Du, Kill This Love, How You Like That. BLACKPINK là một trong những nhóm nhạc nữ K-pop hàng đầu thế giới, có lượng fan đông đảo và ảnh hưởng toàn cầu.',
        songs: [
            { id: 1, title: 'Lovesick Girls', image: img21 },
        ]
     },
    { id: 4, image: img11, name: 'Ado', info: 'Ado là ca sĩ Nhật Bản nổi tiếng với giọng hát nội lực và phong cách âm nhạc hiện đại, đặc biệt trong thể loại J-pop và nhạc điện tử. Cô gây chú ý mạnh mẽ qua ca khúc Usseewa ra mắt năm 2020, nhanh chóng trở thành hit lớn và tạo dấu ấn trong giới trẻ Nhật. Ado được biết đến với khả năng biểu cảm sâu sắc và phong cách âm nhạc độc đáo.',
        songs: [
            { id: 1, title: 'うっせぇわ', image: img27 },
            { id: 2, title: 'Show', image: img28 }
        ]
     },
    { id: 5, image: img8, name: 'Taylor Swift', info: 'Taylor Swift là ca sĩ kiêm nhạc sĩ người Mỹ nổi tiếng toàn cầu, sinh năm 1989. Cô bắt đầu sự nghiệp với dòng nhạc country và nhanh chóng chuyển sang pop, tạo nên hàng loạt hit đình đám như Love Story, Shake It Off, Blank Space. Taylor được biết đến với khả năng kể chuyện qua lời ca khúc, phong cách đa dạng và liên tục đổi mới âm nhạc. Cô đã giành nhiều giải Grammy và là một trong những nghệ sĩ có ảnh hưởng lớn nhất thế giới.',
        songs: [
            { id: 1, title: 'Love Story', image: img3 },
            { id: 2, title: 'Cruel Summer', image: img22 },
            { id: 3, title: 'Blank Space', image: img24 }
        ]
     },
    { id: 6, image: img9, name: 'ヨルシカ', info: 'Yorushika (ヨルシカ) là một nhóm nhạc pop-rock Nhật Bản được thành lập vào năm 2017, gồm hai thành viên chính là n-buna (nhạc sĩ kiêm nhà sản xuất) và suis (ca sĩ chính). Nhóm nổi tiếng với giai điệu nhẹ nhàng, đầy cảm xúc cùng lời ca sâu sắc thường khai thác chủ đề về tình yêu, cuộc sống và những khía cạnh trăn trở của tuổi trẻ. Các ca khúc tiêu biểu như "Just a Sunny Day for You", "Say It." và "だから僕は音楽を辞めた". Yorushika nhanh chóng nhận được sự yêu mến lớn ở Nhật Bản cũng như quốc tế nhờ phong cách âm nhạc độc đáo và lời nhạc đậm chất thơ.',
        songs: [
            { id: 1, title: 'ただ君に晴れ', image: img2 },
            { id: 2, title: '春泥棒', image: img20 },
            { id: 3, title: '晴る', image: img25 }
            //...
        ]
     },
    { id: 7, image: img10, name: 'YOASOBI', info: 'Yoasobi là nhóm nhạc J-pop của Nhật Bản gồm hai thành viên: Ayase (nhà sản xuất âm nhạc) và Ikura (ca sĩ chính). Họ nổi tiếng với việc chuyển thể các truyện ngắn thành bài hát, kết hợp âm nhạc điện tử và pop, tạo ra nhiều ca khúc hit như "Yoru ni Kakeru" – bản hit đình đám giúp họ nổi bật trong làng nhạc Nhật từ năm 2019.',
        songs: [
            { id: 1, title: 'アイドル', image: img26 },
            { id: 2, title: '夜に駆ける', image: img30 }
        ]
     },
    { id: 8, image: img11, name: 'Ado', info: 'Ado là ca sĩ Nhật Bản nổi tiếng với giọng hát nội lực và phong cách âm nhạc hiện đại, đặc biệt trong thể loại J-pop và nhạc điện tử. Cô gây chú ý mạnh mẽ qua ca khúc Usseewa ra mắt năm 2020, nhanh chóng trở thành hit lớn và tạo dấu ấn trong giới trẻ Nhật. Ado được biết đến với khả năng biểu cảm sâu sắc và phong cách âm nhạc độc đáo.',
        songs: [
            { id: 1, title: 'うっせぇわ', image: img27 },
            { id: 2, title: 'Show', image: img28 }
        ]
     },
    { id: 9, image: img12, name: 'LiSA', info: 'LiSA là ca sĩ Nhật Bản nổi tiếng với nhiều ca khúc anime đình đám. Cô bắt đầu sự nghiệp âm nhạc vào năm 2010 và nhanh chóng trở thành một trong những nghệ sĩ J-pop hàng đầu. Các bài hát của cô thường mang âm hưởng rock mạnh mẽ và đầy cảm xúc, thu hút đông đảo người hâm mộ.',
        songs: [
            { id: 1, title: '紅蓮華', image: img29 },
        ]
     },
    { id: 10, image: img14, name: 'Sia', info: 'Sia là ca sĩ- nhạc sĩ người Úc, nổi tiếng với giọng hát mạnh mẽ và phong cách âm nhạc độc đáo. Cô bắt đầu sự nghiệp vào những năm 2000 và nhanh chóng gặt hái được nhiều thành công với các bản hit như "Chandelier", "Elastic Heart" và "Cheap Thrills". Sia cũng được biết đến với việc sáng tác cho nhiều nghệ sĩ nổi tiếng khác.',
        songs: [
            { id: 1, title: 'Unstoppable', image: img31 },
        ]
     },
    { id: 11, image: img15, name: 'BLACKPINK', info: 'BLACKPINK là nhóm nhạc nữ Hàn Quốc gồm 4 thành viên: Jisoo, Jennie, Rosé và Lisa, ra mắt năm 2016 dưới công ty YG Entertainment. Nhóm nổi tiếng với phong cách âm nhạc kết hợp K-pop, hip-hop và EDM, sở hữu nhiều hit đình đám như Ddu-Du Ddu-Du, Kill This Love, How You Like That. BLACKPINK là một trong những nhóm nhạc nữ K-pop hàng đầu thế giới, có lượng fan đông đảo và ảnh hưởng toàn cầu.',
        songs: [
            { id: 1, title: 'Lovesick Girls', image: img21 },
        ]
     },
    { id: 12, image: img18, name: 'Robin', info: 'Robin trong Honkai Star Rail là "Ca sĩ Ngân Hà" với giọng hát trong trẻo, mê hoặc và phong cách âm nhạc huyền bí, mang đến cảm xúc sâu lắng và phiêu linh cho người nghe. Cô được yêu thích nhờ khả năng truyền tải cảm xúc qua từng giai điệu, tạo nên nét độc đáo trong thế giới âm nhạc vũ trụ của trò chơi.',
        songs: [
            { id: 1, title: 'Hope Is the Thing With Feathers', image: img18 },
        ]
     },
]

const artist = artists.find(s => s.id === parseInt(route.params.id))

import { computed } from 'vue'
import { useFavoritesStore } from '../favorites.js'

const favoritesStore = useFavoritesStore()
const favoriteSongs = computed(() => favoritesStore.favorites)
const favoriteArtists = computed(() => favoritesStore.favoriteArtist)

function addArtists(artist) {
  favoritesStore.addFavoriteArtist(artist)
}
function addToFavorites(song) {
  favoritesStore.addFavorite(song)
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