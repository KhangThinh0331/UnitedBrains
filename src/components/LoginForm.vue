<template>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
                <a class="navbar-brand" href="">
                    <img :src="item[0].image" alt="" style="width: 150px;" />
                </a>
                <h1 style="color: white;" class="mx-auto">Spotifast</h1>
            </div>
        </nav>
        <section>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="register-tab" data-bs-toggle="tab" data-bs-target="#register"
                        type="button" role="tab" aria-controls="register" aria-selected="true">
                        Đăng ký
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="login-tab" data-bs-toggle="tab" data-bs-target="#login" type="button"
                        role="tab" aria-controls="login" aria-selected="false">
                        Đăng nhập
                    </button>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="register" role="tabpanel" aria-labelledby="register-tab">
                    <div class="container">
                        <h3 class="">Đăng Ký</h3>
                        <div class="mb-3">
                            <label for="" class="form-label">Họ và Tên</label>
                            <input type="text" class="form-control" name="" id="" placeholder="Nhập họ và tên" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Email</label>
                            <input type="text" class="form-control" name="" id="" placeholder="Nhập email" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Số điện thoại</label>
                            <input type="text" class="form-control" name="" id="" placeholder="Nhập số điện thoại" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Mật khẩu</label>
                            <input type="password" class="form-control" name="" id="" placeholder="Nhập mật khẩu" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Xác Nhận Mật Khẩu</label>
                            <input type="password" class="form-control" name="" id="" placeholder="Xác Nhận Mật Khẩu" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Giới tính:</label>
                            <br>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="{3:option1}" />
                                <label class="form-check-label" for="">Nam</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="option2" />
                                <label class="form-check-label" for="">Nữ</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Ngôn ngữ</label>
                            <select class="form-select form-select-lg" name="" id="">
                                <option selected>Tiếng Việt</option>
                                <option value="">Tiếng Anh</option>
                                <option value="">Trung Quốc</option>
                                <option value="">Pháp</option>
                            </select>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" name="" id="condition" type="checkbox" value="checkedValue"
                                aria-label="Text for screen reader" />
                            <label for="condition">Tôi đồng ý với các điều khoản và điều kiện</label>
                        </div>
                        <button type="button" class="btn btn-primary mb-3">Đăng ký</button>
                    </div>
                </div>
                <div class="tab-pane" id="login" role="tabpanel" aria-labelledby="login-tab">
                    <div class="container">
                        <h3 class="">Đăng Nhập</h3>
                        <div class="mb-3">
                            <label for="" class="form-label">Email</label>
                            <input type="email" class="form-control" name="" id="" aria-describedby="emailHelpId"
                                placeholder="Nhập email" />
                        </div>
                        <div class="mb-3">
                            <label for="" class="form-label">Password</label>
                            <input type="password" class="form-control" name="" id="" placeholder="Nhập mật khẩu" />
                        </div>
                        <button type="button" class="btn btn-primary">Đăng nhập</button>
                    </div>
                </div>
            </div>
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
