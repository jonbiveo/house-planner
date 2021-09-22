<template>
  <div class="banner">
    <div class="logo">
      <h1>Home Planner</h1>
    </div>
    <div class="nav">
        <router-link id="plan-details" v-bind:to="{ name: 'plans' }" v-if="currentPage !== '/plans'">View Plans</router-link>
        <router-link id="landing" v-if="currentPage !== '/'" v-bind:to="{ name: 'landing' }">Landing</router-link>&nbsp;|&nbsp;
        <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
  </div>
</template>

<script>
export default {
    name: "header-nav",
    computed: {
      currentPage() {
        console.log(this.$route.fullPath)
        return this.$route.fullPath;
      }
    }
}
</script>

<style scoped>

  .banner {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin: 2% 6%;
  }


</style>