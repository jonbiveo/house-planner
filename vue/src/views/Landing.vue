<template>
  <div class="landing">
    <hero/>
    <slideshow/>
    <about/>
    <contact/>
  </div>
</template>

<script>
import About from '../components/About.vue';
import Contact from '../components/Contact.vue';
import Hero from '../components/Hero.vue';
import Slideshow from '../components/Slideshow.vue';

export default {
  components: {Hero, Slideshow, About, Contact},
  name: "landing",
};
</script>
