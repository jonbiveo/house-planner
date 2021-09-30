<template>
  <div class="landing">
    
    <hero id="about"/>
    <contact id="contact"/>
  </div>
</template>

<script>
import Contact from '../components/TheContact.vue';
import Hero from '../components/TheHero.vue';

export default {
  components: {Hero, Contact},
  name: "landing",
};
</script>
<style>

</style>