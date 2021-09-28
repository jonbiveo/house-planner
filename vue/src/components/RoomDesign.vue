<template>
  <div>
      <!--form-->
      <h1>Room Design</h1>
      
      <h3> Layout </h3>
      <label for="f1layout" class="f1layout">Select Floor 1 Layout Design: </label>
      <select name ="f1layout" v-model="roomDesign.layout">
      <option value="open"> Open Floor Plan</option>
      <option value="traditional">Traditional Floor Plan</option>
      </select>
      <br>
      <!--doorway size -->
        <!--pocket door -->
        <!--opening-->

      <!--staircasse type -->
      <h3> Staircase </h3>
      <label for="staircase" class="staircase">Select Staircase Design</label>
      <select name="staircase" v-model="roomDesign.staircase">
          <option value="straight"> Straight Staircase </option>
          <option value="floating"> Floating Straight Staircase </option>
          <option value="spiral"> Spiral Staircase </option>
          <option value="l-shaped"> L-Shaped Staircase</option>
          </select> 
      <!--floor 2 staircase diff than floor 1-->

      <!-- flooring material -->
      <h3> Flooring </h3>

      <!--kitchen-->
      <label for="kitchenFlooring" class="kitchenFlooring"> Select Kitchen Flooring </label>
        <select name="kitchenFlooring" v-model="roomDesign.flooring.kitchen">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

        <!--living room-->
        <label for="lrFlooring" class:=lrFlooring> Select Living Room Flooring </label>
        <select name="lrFlooring" class="lrFlooring" v-model="roomDesign.flooring.livingRoom">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

          <!--bedfroom-->
        <label for="bedroomFlooring" class:=bedroomFlooring> Select Bedroom Flooring </label>
        <select name="bedroomFlooring" class="bedroomFlooring" v-model="roomDesign.flooring.bedrooms">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

          <!--bathroom -->
        <label for="bathroomFlooring" class:=bathroomFlooring> Select Bathroom Flooring </label>
        <select name="bathroomFlooring" class="bathroomFlooring" v-model="roomDesign.flooring.bathrooms">
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

          <!--entertainment room-->
        <label for="entertainmentFlooring" class:=entertainmentFlooring> Select Entertainment Room Flooring </label>
        <select name="entertainmentFlooring" class="entertainmentFlooring" v-model="roomDesign.flooring.entertainmentRoom">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

        <!--spare room--> 
        <label for="spareRoomFlooring" class:=spareRoomFlooring> Select Spare Room Flooring </label> <!--pull type from store-->
        <select name="spareRoomFlooring" class="spareRoomFlooring" v-model="roomDesign.flooring.spareRoom">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>

         <!--staircase-->
        <label for="staircaseFlooring" class:=staircaseFlooring> Select Staircase Flooring </label>
        <select name="staircaseFlooring" class="staircaseFlooring" v-model="roomDesign.flooring.staircase">
            <option value="carpet"> Carpet </option>
            <option value="ceramicTile"> Ceramic Tile </option>
            <option value="porcelainTile"> Porcelain Tile </option>
            <option value="hardwood"> Hardwood </option>
            <option value="laminate"> Laminate </option>
            <option value="concrete"> Stained Concrete </option>
        </select>
        <br>
        

      <!--kitchen cabinets-->
      <!--kitchen counter-->
          <!--island-->

      <br/>
      <button class="bck-btn" @click="goToPlanBuilder"> Previous
          </button>
      </div>
</template>

<script>
export default {
  name: "roomDesign",
  data() {
    return {
      roomDesign: {
        layout: "",
        staircase: "",
        flooring: {
          bedrooms: "",
          bathrooms: "",
          livingRoom: "",
          kitchen: "",
          basement: "",
          entertainmentRoom: "",
          spareRoom: "",
        },
        kitchenCabinets: "",
        island: "",
        kitchenCounters: "",
        bathroomCounters: "",
        bathroomSink: "",
        bathroomTub: "",
        bathroomShower: "",
      },
    };
  },
  methods: {
    goToPlanBuilder() {
      this.$router.push("/plan-builder");
    },
  },
  created() {
        console.log(this.$store.state.floorPlan.kitchen)
  },
};
</script>

<style>
div {
  color: black;
}
button {
  margin: 10px auto;
  padding: 1-px;
  min-width: 150px;
  height: 25px;
  font-size: 16pt;
  border-radius: 15px;
  border: none;
  background-color: #e76f51;
  color: black;
}
</style>