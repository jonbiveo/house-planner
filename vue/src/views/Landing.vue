<template>
  <div class="landing">
    <div class=frnt-img>
    <img class="house" src="https://images.pexels.com/photos/280222/pexels-photo-280222.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"/>
    </div>
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