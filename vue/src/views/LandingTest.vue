<template>
  <div class="landing">
    <!-- <hero/>
    <slideshow/>
    <about/>
    <contact/> -->
    <canvas id="canvas" width="600" height="400" @click="createLines"></canvas>
    <button @click="newRoom">New Room</button>
    <p id="coords"></p>
  </div>
</template>

<script>
// import About from '../components/About.vue';
// import Contact from '../components/Contact.vue';
// import Hero from '../components/Hero.vue';
// import Slideshow from '../components/Slideshow.vue';

export default {
  // components: {Hero, Slideshow, About, Contact},
  name: "landing",
  data() {
    return {};
  },
  methods: {
    newRoom() {},
    createLines() {
      let coords = [];
      let canvas = document.getElementById("canvas");
      let ctx = canvas.getContext("2d");
      canvas.addEventListener("click", function (event) {
        let coord = { x: event.x, y: event.y - 100 };
        coords.push(coord);
        let max = coords.length - 1;
          ctx.beginPath();
        if (typeof coords[max - 1] !== "undefined") {
          let newC = coords[max],
            oldC = coords[max - 1];
          if (Math.abs(newC.x - oldC.x) > Math.abs(newC.y - oldC.y)) {
            console.log(coords);
            coords[max].y = oldC.y;
          } else {
            console.log(coords);
            coords[max].x = oldC.x;
          }
          ctx.moveTo(oldC.x, oldC.y);
          ctx.lineTo(newC.x, newC.y);
          // if (Math.abs(coords[max].x-coords[0].x) <=20 && Math.abs(coords[max].y-coords[0].y) <=20){
          //   console.log("true")
          //     context.closePath();
          //     context.stroke();
          //  }
           
          ctx.stroke();
        }
      });
    },
  },
};
</script>

<style scoped>
canvas {
  display: grid;
  border: 1px solid black;
  border-radius: 0px;
}
body {
  margin: 0;
  padding: 0;
}
</style>
