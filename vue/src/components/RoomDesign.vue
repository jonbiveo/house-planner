<template>
<div class="main">
  <div class="design-builder">
      <div class="icons">
        <img  class="layout" src="../assets/floor-plan-icon.svg">
        <img class="doors-icon" src="../assets/doors-icon.svg">
        <img class="stairs" src="../assets/staircase.svg">
        <img class="bathrooms" src="../assets/bathrooms.svg">
        <img class="kitchen" src="../assets/kitchen-icon.svg">
        <img class="floors" src="../assets/floors-icon.svg">
        </div>

      <form class="design-form">
      <h2 class="header">Room Design</h2>
      
      <h3> Layout </h3>
      <label for="f1layout" class="f1layout">Select Layout Design: </label>
      <select name ="f1layout" v-model="design.floorOneLayout">
      <option value="open"> Open Floor Plan</option>
      <option value="traditional">Traditional Floor Plan</option>
      </select>

      <h3> Doors </h3>
      <label for="doorway" class="doors">Select Door Style: </label>
      <select name="doors" v-model="design.doors">
      <option value="wood"> Standard Wood Doors </option>
      <option value = "pocket"> Pocket Doors </option>
      <option value = "french"> French Doors </option>
      </select>

      <!--staircase type -->
      <h3> Staircase </h3>
      <label for="staircase" class="staircase">Select Staircase Design: </label>
      <select name="staircase" v-model="design.staircase">
          <option value="straight"> Straight Staircase </option>
          <option value="floating"> Floating Straight Staircase </option>
          <option value="spiral"> Spiral Staircase </option>
          <option value="l-shaped"> L-Shaped Staircase</option>
          </select> 
      <!--floor 2 staircase diff than floor 1-->

     <!--Bathtubs-->
      <h3> Bathroom </h3>
       <label for ="bathroomCabinets" class="bathroomCabinets"> Select Bathroom Cabinet Color: </label>
      <select name="kitchenCabinets" v-model="design.bathroomCabinets">
        <option value="white"> White </option>
        <option value="gray"> Gray </option>
        <option value="black"> Black </option>
        <option value="wood">Solid Wood </option>
      </select>

       <label for ="bathroomTub" class="bathroomTub"> Bath Options: </label>
      <select name="bathroomTub" v-model="design.bathroomTub">
        <option value="bathTub"> Bathtub </option>
        <option value="standingShower"> Standing Shower </option>
      </select>
      
      <!--Kitchen-->

      <h3> Kitchen </h3>
      <label for ="kitchenCabinets" class="kitchenCabinets"> Select Kitchen Cabinet Color: </label>
      <select name="kitchenCabinets" v-model="design.kitchenCabinets">
        <option value="white"> White </option>
        <option value="gray"> Gray </option>
        <option value="black"> Black </option>
        <option value="wood">Solid Wood </option>
      </select>

      <label for="island" class="island"> Kitchen Island: </label>
      <select name="island" v-model="design.kitchenIsland">
        <option value="yes"> Yes </option>
          <option value="no"> No </option>
          </select>

          <!-- kitchen counters if time -->

        <!-- flooring material -->
        <h3> Flooring </h3>
    
        <!--kitchen-->
        <label for="kitchenFlooring" class="kitchenFlooring"> Select Kitchen Flooring: </label>
        <select name="kitchenFlooring" v-model="design.kitchenFloor">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
    

        <!--living room-->
        <label for="lrFlooring" class:=lrFlooring> Select Living Room Flooring: </label>
        <select name="lrFlooring" class="lrFlooring" v-model="design.livingRoomFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        
          <!--bedroom-->
        <label for="bedroomFlooring" class:=bedroomFlooring> Select Bedroom Flooring: </label>
        <select name="bedroomFlooring" class="bedroomFlooring" v-model="design.bedroomFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

          <!--bathroom -->
        <label for="bathroomFlooring" class:=bathroomFlooring> Select Bathroom Flooring: </label>
        <select name="bathroomFlooring" class="bathroomFlooring" v-model="design.bathroomFloor">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

          <!--entertainment room-->
        <label for="entertainmentFlooring" class:=entertainmentFlooring v-if="$store.state.floorPlan.entertainmentRoom !== ''"> Select Entertainment Room Flooring: </label>
        <select name="entertainmentFlooring" class="entertainmentFlooring" v-model="design.entertainmentRoomFloor" v-if="$store.state.floorPlan.entertainmentRoom !== ''">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

        <!--spare room--> 
        <label for="spareRoomFlooring" class:=spareRoomFlooring v-if="$store.state.floorPlan.spareRoom !== ''"> Select Spare Room Flooring: </label> <!--pull type from store-->
        <select name="spareRoomFlooring" class="spareRoomFlooring" v-model="design.spareRoomFloor" v-if="$store.state.floorPlan.spareRoom !== ''">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        

         <!--staircase-->
        <label for="staircaseFlooring" class:=staircaseFlooring> Select Staircase Flooring: </label>
        <select name="staircaseFlooring" class="staircaseFlooring" v-model="design.staircaseFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
      
        

        <br>
        <span class="btns">
        <button class="bck-btn" @click="goToPlanBuilder"> Previous
          </button>
        <button class="next-btn" @click.prevent="storeDesignData"> Next
          </button>
        </span>
        </form>
      </div>
      <div>Icons made by <a href="https://smashicons.com/" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
    </div>
    
</template>

<script>
export default {
  name: "roomDesign",
  data() {
    return {
      design: {
        floorOneLayout: "",
        doors: "",
        staircase: "",
        bathroomCabinets:"",
        bathroomTub:"",
        kitchenCabinets: "",
        kitchenIsland: "",
        kitchenFloor: "",
        livingRoomFloor: "",
        bedroomFloor: "",
        bathroomFloor: "",
        entertainmentRoomFloor: "",
        spareRoomFloor: "",
        staircaseFloor: ""
      }
      // roomDesign: {
      //   layout: "",
      //   staircase: "",
      //   flooring: {
      //     bedrooms: "",
      //     bathrooms: "",
      //     livingRoom: "",
      //     kitchen: "",
      //     basement: "",
      //     entertainmentRoom: "",
      //     spareRoom: "",
      //   },
      //   kitchenCabinets: "",
      //   island: "",
      //   kitchenCounters: "",
      //   bathroomCounters: "",
      //   bathroomSink: "",
      //   bathroomTub: "",
      //   bathroomShower: "",
      //},
    };
  },
  methods: {
    storeDesignData(){
      this.$store.commit("STORE_DESIGNER", this.design);
      console.log(this.$store.state.floorPlan);
      this.$router.push("/cost-breakdown");
    },
    goToPlanBuilder() {
      this.$router.push("/plan-builder");
    },
  },
};
</script>

<style scoped>
.main{
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "design";
  justify-items: center;
  max-width: 100%;
  height: 100%;
  
}

.design-builder{
  display: grid;
  grid-area: "design";
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 1fr;
  grid-template-areas: "icons" "form";
  justify-items: center;
  /* align-content: center; */
  width: 70vw;
  max-width: 800px;
  background-color: #E9C46A;
  border-radius: 25px;
  color: #264653;
  margin-top: 25px;
} 
.icons{
  display: grid;
  grid-area: "icons";
  grid-template-columns: 1fr;
  grid-template-rows: 20px 20px 20px 20px 20px 40px;
  grid-template-areas: 
  "layout"
  "doors"
  "stairs"
  "bathroom"
  "kitchen"
  "flooring";
  justify-items: end;
  width: 40%;
}
.layout{
  display: grid;
  grid-area: "layout";
  height: 7vh;
  max-width: 7vw;
  margin-top: 100px;

}
.stairs{
  display: grid;
  grid-area: "stairs";
  height: 7vh;
  max-width: 7vw;
  margin-top: 120px;
  padding-top: 120px;
}
.kitchen {
  display: grid;
  grid-area: "kitchen";
  height: 7vh;
  max-width: 7vw;
  margin-top: 200px;
  padding-top: 235px;
  }

.doors-icon{
  display: grid;
  grid-area: "doors";
  height: 7vh;
  max-width: 7vw;
  margin-top: 95px;
  padding-top: 75px;
}

.floors{
  display: grid;
  grid-area: "floors";
  height: 7vh;
  max-width: 7vw;
  align-self: start;
  margin-top: 300px;
  padding-top: 300px;
}

.bathrooms{
  display: grid;
  grid-area: "bathrooms";
  height: 7vh;
  max-width: 7vw;
  margin-top: 160px;
  padding-top: 165px;

}

.design-form {
  margin-top: 15px;
  grid-area: "form";
  display: grid;
  justify-items: center;
  width: 100%;
}
button {
  margin: 10px;
  padding: 5px; 
  min-width: 150px;
  height: 35px;
  font-size: 18px;
  border-radius: 15px;
  border: none;
  background-color: #264653;
  color:#f0e3c2;
}

h3{
  margin: 5px;
}
.header{
  justify-self: start;
  margin-left: 50px;
  padding-left: 50px;
}

.btns{
  justify-self: start;
  margin-left: 25px;
  padding-left: 20px;

}



</style>