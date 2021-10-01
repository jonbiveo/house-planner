<template>
  <div id="app">
    <header-nav />
    <router-view />
  </div>
</template>

<script>
import HeaderNav from '@/components/HeaderNav.vue'
export default {
  components: { HeaderNav },
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Nunito&display=swap");
body, select, input, button{
  margin:0;
  font-family: "Nunito", sans-serif;
  color: #264653;
  
}

body{
  overflow-x:hidden;
}

a{
  text-decoration: none;
}

</style>
