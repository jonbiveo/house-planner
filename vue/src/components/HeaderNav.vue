<template>
  <div class="banner">
    <router-link :to="{name:'landing'}" v-if="$store.state.token === ''">
      <div class="logo">
        <h1 class="name">LMTV</h1>
        <label class="tag">House Planner</label>
        <i class="fas fa-home"></i>
        <img src="../../public/home-solid.svg" />
      </div>
    </router-link>
    <router-link :to="{name:'plans'}" v-if="$store.state.token !== ''">
      <div class="logo">
        <h1 class="name">LMTV</h1>
        <label class="tag">House Planner</label>
        <i class="fas fa-home"></i>
        <img src="../../public/home-solid.svg" />
      </div>
    </router-link>
    <div class="nav-logged-out" v-if="$store.state.token === ''">
      <router-link to="/">About</router-link> | 
      <router-link to="/">Contact</router-link> | 
      <router-link :to="{ name: 'login' }">Log In</router-link> | 
      <router-link class="btn register" :to="{ name: 'register' }">Register</router-link>
    </div>
    <div class="nav-logged-in" v-if="$store.state.token !== ''">
      <router-link class="btn register" :to="{ name: 'logout'}">Logout</router-link> | 
      <router-link :to="{name:'plans'}"> {{currentUser}} </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "header-nav",
  data() {
    return {
      currentUser: JSON.parse(localStorage.getItem("user")).username,
    };
  },
  computed: {
    currentPage() {
      console.log(this.$route.fullPath);
      return this.$route.fullPath;
    },
  },
  methods:{
  }
};
</script>

<style scoped>

.banner {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 0;
  background-color: #2a9d8f;
  padding: 20px 15% 0;
  color: white;
  min-width: 600px;
  color: #264653;
}

.logo {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  height: 80px;
  cursor: pointer;
}

.logo > img {
  max-height: 60px;
  padding: 2px 7px;
  color: #264653;
}

.name,
.tag,
.logo > img {
  margin: 0;
}

.name{
  letter-spacing: 6px;
}

.nav-logged-out {
  width: 30%;
  display: flex;
  justify-content: space-evenly;
  min-width: 300px;
}

.nav-logged-in {
  width: 20%;
  display: flex;
  justify-content: space-evenly;
  min-width: 70px;
  max-width: 200px;
}

a {
  color: white;
}
</style>