<template>
  <div class="landing">
    <h1>Welcome!</h1>
    <p>Please select from an option below</p>
    <div>
      <router-link v-bind:to="{name: 'details'}">New Plan</router-link> 
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
router-link{
  padding: 5px;
  margin: 10px;
}
</style>
