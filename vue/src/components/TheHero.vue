 <template>
  <div class="body-hero">
    <div class="hero-container">
      <span class="home-title"><p>A simple way to plan your house.</p></span>
      <span class="home-text"><p>LMTV House Planner</p> </span>
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
  max-height: 80vh;
  min-height: 500px;
  min-width: 750px;
}

.hero-container {
  display: grid;
   grid-template-columns: 50% 50%;
  grid-template-rows: 50% 50%; 
  grid-template-areas:
  "title img"
  "text img";
  padding: 0 10%;
  height: 80vh;
}

.home-title {
  grid-area: title;
  grid-column: 1;
  display: flex;
  align-items: flex-end;
  font-size: 2.5em;
  padding: 0 0 0 6%;
  font-weight: bold;
}
.home-text {
  grid-area: text;
  grid-column: 1;
  padding: 0 0 0 6%;
}

.home-title > p,
.home-text > p {
  max-width: 700px;
}


.hero-img > img{
  grid-area: img;
  grid-column: 2;
  grid-row: 1/3;
  padding: 10%;
}
</style>