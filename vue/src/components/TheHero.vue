<template>
  <div class="body-hero">
    <div class="hero-container">
      <span class="home-title">A simple way to plan your house.</span>
      <span class="home-text">LMTV House Planner </span>
      <!-- <img
        class="hero-img"
        src="https://images.pexels.com/photos/280222/pexels-photo-280222.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
      /> -->
      <div class="hero-img">
        <img src="../assets/noun_home_layout_3292658.svg" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.body-hero {
  min-height: 80vh;
}

.hero-container {
  display: grid;
  grid-template-columns: 50% 50%;
  grid-template-rows: 50% 50%;
  padding: 0 10%;
}

.home-title {
  grid-column: 1;
  display: flex;
  align-items: flex-end;
  font-size: 2.5em;
  padding: 0 0 3% 6%;
  font-weight: bold;
}
.home-text{
  grid-column: 1;
  padding: 3% 0 0 6%;

}

.hero-img{
  grid-column: 2;
  grid-row: 1/2;
  padding: 20% 10% 0 5%;
}
</style>