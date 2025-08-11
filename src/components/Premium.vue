<template>
  <div class="premium-container">
    <!-- Tiêu đề -->
    <h1 class="title">🎵 Nâng cấp Premium</h1>
    <p class="subtitle">Trải nghiệm nghe nhạc không giới hạn dành cho khách hàng thân thiết ☕</p>

    <div class="content">
      <!-- Danh sách gói -->
      <div class="plans">
        <div v-for="plan in plans" :key="plan.id" class="plan-card">
          <h2>{{ plan.name }}</h2>
          <p class="price">{{ formatNumber(plan.price) }}₫</p>
          <ul>
            <li v-for="(benefit, i) in plan.benefits" :key="i">✔ {{ benefit }}</li>
          </ul>
          <button class="btn-add" @click="addToCart(plan)">Thêm vào giỏ</button>
        </div>
      </div>

      <!-- Giỏ hàng -->
      <div class="cart">
        <h2>🛒 Giỏ hàng</h2>
        <div v-if="cart.length === 0" class="empty">Chưa có gói nào</div>
        <div v-else>
          <div v-for="(item, index) in cart" :key="index" class="cart-item">
            <span>{{ item.name }}</span>
            <span>{{ formatNumber(item.price) }}₫</span>
          </div>
          <div class="total">
            <strong>Tổng:</strong> <span>{{ formatNumber(totalPrice) }}₫</span>
          </div>
          <button class="btn-checkout" @click="checkout">Thanh toán</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue"

const plans = ref([
  { id: 1, name: "Gói 1 tháng", price: 59000, benefits: ["Không quảng cáo", "Nghe offline", "Âm thanh chất lượng cao"] },
  { id: 2, name: "Gói 6 tháng", price: 299000, benefits: ["Tiết kiệm hơn 15%", "Không quảng cáo", "Nghe offline"] },
  { id: 3, name: "Gói 12 tháng", price: 549000, benefits: ["Tiết kiệm 22%", "Không quảng cáo", "Nghe offline"] },
])

const cart = ref([])

function addToCart(plan) {
  cart.value.push(plan)
}

const totalPrice = computed(() => cart.value.reduce((sum, item) => sum + item.price, 0))

function checkout() {
  alert("Thanh toán thành công! 🎉")
  cart.value = [] // Xóa giỏ hàng sau khi thanh toán
}

function formatNumber(n) {
  return n ? n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") : "0"
}

</script>

<style scoped>
.premium-container {
  background: #f2f1ff;
  padding: 2rem;
  color: #42399f;
  font-family: "Segoe UI", sans-serif;
}

.title {
  font-size: 2rem;
  font-weight: bold;
  color: #42399f;
}

.subtitle {
  font-size: 1rem;
  margin-bottom: 1.5rem;
}

.content {
  display: flex;
  gap: 2rem;
}

/* Gói Premium */
.plans {
  flex: 2;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 1.5rem;
}

.plan-card {
  background: white;
  padding: 1rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.05);
  border: 1px solid #ddd;
}

.plan-card h2 {
  color: #42399f;
}

.price {
  font-size: 1.4rem;
  color: #ff38ca;
  font-weight: bold;
}

.btn-add {
  background: #ff38ca;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  border-radius: 8px;
  cursor: pointer;
  margin-top: 1rem;
}
.btn-add:hover {
  background: #ff5ad6;
}

/* Giỏ hàng */
.cart {
  flex: 1;
  background: white;
  padding: 1rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.05);
  border: 1px solid #ddd;
  position: sticky;
  top: 20px;
}

.cart h2 {
  margin-bottom: 1rem;
}

.cart-item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.5rem;
}

.total {
  display: flex;
  justify-content: space-between;
  font-weight: bold;
  margin-top: 1rem;
}

.btn-checkout {
  background: #42399f;
  color: white;
  width: 100%;
  padding: 0.7rem;
  border: none;
  border-radius: 8px;
  margin-top: 1rem;
  cursor: pointer;
}
.btn-checkout:hover {
  background: #574fd6;
}

.empty {
  text-align: center;
  color: gray;
}
</style>
