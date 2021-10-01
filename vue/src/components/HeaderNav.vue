<template>
  <div class="banner">
    <router-link :to="{ name: 'landing' }" v-if="$store.state.token === ''">
      <div class="logo">
        <h1 class="logo-name">LMTV</h1>
        <span class="tag">House Planner</span>
        <i class="fas fa-home"></i>
        <img src="../assets/home-solid.svg" />
      </div>
    </router-link>
    <router-link :to="{ name: 'plans' }" v-if="$store.state.token !== ''">
      <div class="logo">
        <h1 class="logo-name">LMTV</h1>
        <span class="tag">House Planner</span>
        <i class="fas fa-home"></i>
        <img src="../assets/home-solid.svg" />
      </div>
    </router-link>
    <div class="nav-logged-out" v-if="$store.state.token === ''">
      <router-link :to="{name:'about'}"
        >About</router-link
      >
      |
      <router-link to="#" v-scroll-to="'#contact'" class="contact"
        >Contact</router-link
      >
      | <router-link :to="{ name: 'login' }">Log In</router-link> |
      <router-link class="btn register" :to="{ name: 'register' }"
        >Register</router-link
      >
    </div>
    <div class="nav-logged-in" v-if="$store.state.token !== ''"><router-link :to="{name:'about'}">About</router-link
      >
      |
      <router-link :to="{name:'contact'}">Contact</router-link
      >
      | 
      <router-link class="btn register" :to="{ name: 'logout' }"
        >Log Out</router-link
      >
      |
      <router-link :to="{ name: 'plans' }"
        ><img src="../assets/user-solid.svg" class="user-icon" />
        {{ $store.state.user.username }}
      </router-link>
    </div>
  </div>
</template>
 
 <script>
export default {
  name: "header-nav",
  computed: {
    currentPage() {
      console.log(this.$route.fullPath);
      return this.$route.fullPath;
    },
    toHome() {
      if (this.$route.fullPath !== "/") {
        this.pushToHome();
      }
      return 1;
    },
  },
  methods: {
    pushToHome() {
      this.$router.push("/");
    },
  },
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
  min-width: 750px;
  box-shadow: 0 3px 5px darkgrey;
}

.logo {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  height: 80px;
  cursor: pointer;
  color: white;
}

.logo > img {
  max-height: 60px;
  padding: 2px 7px;
}

.logo-name,
.tag,
.logo > img {
  margin: 0;
}

.logo-name {
  letter-spacing: 6px;
}

.nav-logged-out {
  width: 30%;
  display: flex;
  justify-content: space-evenly;
  min-width: 300px;
}

.nav-logged-in {
  width: 30%;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  min-width: 350px;
  max-width: 375px;
}

.user-icon {
  height: 20px;
  padding-right: 5px;
}

a {
  color: white;
}

</style>