<template>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <router-link class="navbar-brand" to="/">
                    <img :src="item[0].image" alt="Logo" style="width: 150px;" />
                </router-link>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <router-link class="nav-link" to="/songs">
                                <i class="fa-solid fa-film"></i> Bài hát
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/artists">
                                <i class="fa-solid fa-circle-info"></i> Nghệ sĩ
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/account">
                                <i class="fa-solid fa-user"></i> Tài khoản
                            </router-link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
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
                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[12].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>ただ君に晴れ</span>
                                    </div>
                                    <div class="d-flex gap-2">
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-play-fill"></i>
                                        </button>
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>

                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[13].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>Love Story</span>
                                    </div>
                                    <div class="d-flex gap-2">
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-play-fill"></i>
                                        </button>
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>

                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[14].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>Bắc Bling</span>
                                    </div>
                                    <div class="d-flex gap-2">
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-play-fill"></i>
                                        </button>
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>
                            </ul>
                        </div>

                        <!-- Tab 2: Nghệ sĩ yêu thích -->
                        <div class="tab-pane fade" id="artists" role="tabpanel" aria-labelledby="artists-tab">
                            <ul class="list-group">
                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[15].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>ヨルシカ</span>
                                    </div>
                                    <div class="d-flex gap-2">
                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>

                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[16].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>Taylor Swift</span>
                                    </div>
                                    <div class="d-flex gap-2">

                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>

                                <li class="list-group-item d-flex align-items-center justify-content-between">
                                    <div class="d-flex align-items-center gap-3">
                                        <img :src="item[17].image" alt=""
                                            style="width: 75px; height: 75px; object-fit: cover;"
                                            class="rounded-circle" />
                                        <span>Ado</span>
                                    </div>
                                    <div class="d-flex gap-2">

                                        <button class="btn rounded-circle pink-button"
                                            style="width: 40px; height: 40px;">
                                            <i class="bi bi-dash"></i>
                                        </button>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>


                </aside>
                <article class="col-sm-8 p-5">

                    <div id="carouselExample" class="carousel slide carousel-fade" data-bs-ride="carousel"
                        data-bs-interval="5000">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <a href="#">
                                    <div class="carousel-img-wrapper">
                                        <img :src="item[1].image" class="carousel-img d-block w-100" alt="Ảnh 1" />
                                        <div class="caption">Cruel Summer</div>
                                    </div>
                                </a>
                            </div>

                            <div class="carousel-item">
                                <a href="#">
                                    <div class="carousel-img-wrapper">
                                        <img :src="item[2].image" class="carousel-img d-block w-100" alt="Ảnh 2" />
                                        <div class="caption">春泥棒</div>
                                    </div>
                                </a>
                            </div>

                            <div class="carousel-item">
                                <a href="#">
                                    <div class="carousel-img-wrapper">
                                        <img :src="item[3].image" class="carousel-img d-block w-100" alt="Ảnh 3" />
                                        <div class="caption">Lovesick Girls</div>
                                    </div>
                                </a>
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
                    <div class="card p-3" style="background-color: #3f3d56; color: #fff;">
                        <div class="d-flex flex-wrap gap-3 justify-content-start">
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[4].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    ただ君に晴れ
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-play-fill"></i> </button> <button
                                    class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[5].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    What is Love?
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-play-fill"></i> </button> <button
                                    class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[6].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    Love Story
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-play-fill"></i> </button> <button
                                    class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[7].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    Bắc Bling
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-play-fill"></i> </button> <button
                                    class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                        </div>
                    </div>
                    <br>
                    <h2 class="mb-3" style="color: #42399f;">Nghệ sĩ nổi bật</h2>
                    <div class="card p-3" style="background-color: #3f3d56; color: #fff;">
                        <div class="d-flex flex-wrap gap-3 justify-content-start">
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[8].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    ヨルシカ
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[9].image" alt="" style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    Taylor Swift
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[10].image" alt=""
                                    style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    BLACKPINK
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                            <div class="text-center" style="width: 200px;">
                                <img :src="item[11].image" alt=""
                                    style="width: 150px; height: 150px; object-fit: cover;"
                                    class="rounded-circle mb-2" />
                                <p class="card-text fs-5">
                                    Ado
                                </p>
                                <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;"> <i
                                        class="bi bi-plus"></i> </button>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </section>
    </div>
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
    { image: img18 }
])
</script>

<style scoped>
body {
    font-family: 'Poppins', sans-serif;
    background-color: #f4f4f9;
    color: #333;
}

.navbar {
    background-color: #3f3d56 !important;
    font-size: large;
}

.nav-link,
.dropdown-item {
    color: #ffffff !important;
}

.dropdown-menu {
    background-color: #3f3d56 !important;
    font-size: large;
}

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