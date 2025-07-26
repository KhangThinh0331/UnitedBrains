<template>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <a class="navbar-brand" href="">
                    <img :src="item[0].image" alt="" style="width: 150px;" />
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa-solid fa-film"></i>Bài hát</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa-solid fa-circle-info"></i>Nghệ sĩ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href=""><i class="fa-solid fa-user"></i>Tài khoản</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="row">
            <aside class="col-sm-4 p-5">Side bar</aside>
            <article class="col-sm-8 p-5">
                
            </article>
        </section>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import logo from '../assets/images/musicLogo.png'
const item = ref([{ image: logo }]) 
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
.tab-content .container{
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

.form-control,
.form-select {
    border-radius: 10px;
    padding: 10px 15px;
    font-size: 16px;
}

.btn-primary {
    background-color: #ff38ca;
    border: none;
    padding: 10px 30px;
    border-radius: 8px;
    font-weight: bold;
    transition: 0.3s;
}

.btn-primary:hover {
    background-color: #ff1dc3;
}

.form-check-label {
    margin-left: 5px;
}

.form-check-input {
    margin-top: 7px;
}

.tab-content .container {
    background-color: #e5e2ff;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 0 20px #5659fd7c;
    max-width: 600px;
    margin: 0 auto;
    color: #3f3d56;
    font-weight: bold;
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
</style>