<template>
  <div class="landing">
    <h1>Welcome!</h1>
    <p>Please select from an option below</p>
    <div class="links">
      <router-link v-bind:to="{name: 'details'}">New Plan</router-link> <br>
      <router-link v-bind:to="{name: 'savedplans'}">Saved Plans</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "landing",
};
</script>
<style scoped>
.links{
  padding: 5px;
  margin: 5px;
}
</style>
