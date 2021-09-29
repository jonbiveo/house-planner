<template>
<div class="main">
  <div class="design-builder">
      <form class="design-form">
      <h2>Room Design</h2>
      
      <h3> Layout </h3>
      <label for="f1layout" class="f1layout">Select Floor 1 Layout Design: </label>
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

      <!--staircasse type -->
      <h3> Staircase </h3>
      <label for="staircase" class="staircase">Select Staircase Design</label>
      <select name="staircase" v-model="design.staircase">
          <option value="straight"> Straight Staircase </option>
          <option value="floating"> Floating Straight Staircase </option>
          <option value="spiral"> Spiral Staircase </option>
          <option value="l-shaped"> L-Shaped Staircase</option>
          </select> 
      <!--floor 2 staircase diff than floor 1-->

      <h3> Kitchen Cabinets </h3>
      <label for ="kitchenCabinets" class="staircase"> Select Kitchen Cabinet Color </label>
      <select name="kitchenCabinets" v-model="design.kitchenCabinets">
        <option value="white"> White </option>
        <option value="gray"> Gray </option>
        <option value="black"> Black </option>
        <option value="wood">Solid Wood </option>
      </select>

      <h3> Kitchen Island </h3>
      <label for="island" class="island"> Would you like a kitchen island? </label>
      <select name="island" v-model="design.kitchenIsland">
        <option value="yes"> Yes </option>
        <option value="no"> No </option>
          </select>

      <!-- flooring material -->
      <h3> Flooring </h3>
    
      <!--kitchen-->
      <label for="kitchenFlooring" class="kitchenFlooring"> Select Kitchen Flooring </label>
        <select name="kitchenFlooring" v-model="design.kitchenFloor">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
    

        <!--living room-->
        <label for="lrFlooring" class:=lrFlooring> Select Living Room Flooring </label>
        <select name="lrFlooring" class="lrFlooring" v-model="design.livingRoomFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        
          <!--bedroom-->
        <label for="bedroomFlooring" class:=bedroomFlooring> Select Bedroom Flooring </label>
        <select name="bedroomFlooring" class="bedroomFlooring" v-model="design.bedroomFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

          <!--bathroom -->
        <label for="bathroomFlooring" class:=bathroomFlooring> Select Bathroom Flooring </label>
        <select name="bathroomFlooring" class="bathroomFlooring" v-model="design.bathroomFloor">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

          <!--entertainment room-->
        <label for="entertainmentFlooring" class:=entertainmentFlooring v-if="$store.state.floorPlan.entertainmentRoom !== ''"> Select Entertainment Room Flooring </label>
        <select name="entertainmentFlooring" class="entertainmentFlooring" v-model="design.entertainmentRoomFloor" v-if="$store.state.floorPlan.entertainmentRoom !== ''">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>

        <!--spare room--> 
        <label for="spareRoomFlooring" class:=spareRoomFlooring v-if="$store.state.floorPlan.spareRoom !== ''"> Select Spare Room Flooring </label> <!--pull type from store-->
        <select name="spareRoomFlooring" class="spareRoomFlooring" v-model="design.spareRoomFloor" v-if="$store.state.floorPlan.spareRoom !== ''">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        

         <!--staircase-->
        <label for="staircaseFlooring" class:=staircaseFlooring> Select Staircase Flooring </label>
        <select name="staircaseFlooring" class="staircaseFlooring" v-model="design.staircaseFloor">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
      
        

      <br/>
      <span class="btns">
      <button class="bck-btn" @click="goToPlanBuilder"> Previous
          </button>
      <button class="next-btn" @click.prevent="storeDesignData"> Next
          </button>
        </span>
        </form>
      </div>
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

<style>
.main{
  display: grid;
  height: 75vh;
  margin-top: 50px;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
}
.design-builder{
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
  width: 60vw;
  background-color: #E9C46A;
  border-radius: 10px;
  color: black;

} 

.design-form {
  margin-top: 15px;
  grid-area: form;
  display: grid;
  justify-content: center;
  width: 50%;
}
button {
  margin: 5px;
  padding: 0px;
  min-width: 150px;
  height: 25px;
  font-size: 16px;
  border-radius: 15px;
  border: none;
  background-color: #264653;
  color:#f0e3c2;
}

h3{
  margin: 5px;
}

</style>