<template>
  <div class="landing">
    <h1>Landing</h1>
    <p>You must be authenticated to see this</p>
    <div>
      <router-link v-bind:to="{name: 'details'}">New Plan</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "landing",
};
</script>
