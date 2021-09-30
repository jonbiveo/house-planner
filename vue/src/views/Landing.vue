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
.frnt-img{
  display: flex;
  justify-content: center;
  margin: auto;
  padding: 20px;
}
.house{
  position: absolute;
  height: 82%;
  max-width: 82%;
}

</style>