<template>
  <div class="landing">
    <hero/>
    <slideshow/>
    <contact/>
  </div>
</template>

<script>
import Contact from '../components/TheContact.vue';
import Hero from '../components/TheHero.vue';
import Slideshow from '../components/TheSlideshow.vue';

export default {
  components: {Hero, Slideshow, Contact},
  name: "landing",
};
</script>
