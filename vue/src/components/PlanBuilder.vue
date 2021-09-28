<template>
  <div class="main">
    <div class="plan-builder">
      <form class="form-builder">
        <h2>Square Footage</h2>
        <label for="sq-footage" class="sq-footage"
          >Select Square Footage:
        </label>
        <select name="sq-footage" v-model="floorPlan.squareFootage" required>
          <option value="1000">1000 sq. feet</option>
          <option value="1500">1500 sq. feet</option>
          <option value="2000">2000 sq. feet</option>
          <option value="2500">2500 sq. feet</option>
          <option value="3000">3000 sq. feet</option>
        </select>

        <h2>Floors</h2>
        <label for="floors" class="floors"> Select Number of Floors: </label>
        <select name="floors" v-model="floorPlan.floors" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3" v-if="floorPlan.squareFootage >= 2500">3</option>
        </select>

        <h2>Room Types</h2>
        <label for="livingRoom" class="living-room"
          >Select Living Room Size:
        </label>
        <select name="living-room" v-model="floorPlan.livingRoom" required id="f1l"
          v-on:change="updateSqFtUsage('f1l')">
          <option value="10x13">10x13</option>
          <option value="12x18">12x18</option>
          <option value="15x20">15x20</option>
        </select>

        <label for="kitchen" class="kitchen"> Select Kitchen Size: </label>
        <select name="kitchen" v-model="floorPlan.kitchen" required id="f1k"
          v-on:change="updateSqFtUsage('f1k')">
          <option value="10x10">10x10</option>
          <option value="20x20">20x20</option>
        </select>

        <!--  -->
        <!-- First Floor -->
        <!--  -->

        <label for="f1bedroom" class="bedrooms">Select Floor 1 Bedrooms</label>
        <select name="f1bedroom" v-model="floorPlan.floorOne.bedrooms" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>

        <label for="f1bedroom1-size" class="bedroom-size">
          Select Master Bedroom Size:</label
        >
        <select name="f1bedroom1-size" id="f1r1" v-model="floorPlan.floorOne.b1" required v-on:change="updateSqFtUsage('f1r1')">
          <option value="20x24">20x24</option>
          <option value="16x18">16x18</option>
          <option value="14x16">14x16</option>
        </select>

        <label
          for="f1bedroom2-size"
          class="bedroom-size"
          v-if="floorPlan.floorOne.bedrooms > 1"
          >Select Bedroom Size:</label
        >
        <select
          name="f1bedroom2-size"
          v-model="floorPlan.floorOne.b2"
          v-if="floorPlan.floorOne.bedrooms > 1"
          id="f1r2"
          v-on:change="updateSqFtUsage('f1r2')"
        >
          <option selected value="">-- select an option --</option>
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <label
          for="f1bedroom3-size"
          class="bedroom-size"
          v-if="floorPlan.floorOne.bedrooms > 2"
          >Select Bedroom Size:</label
        >
        <select
          name="f1bedroom3-size"
          v-model="floorPlan.floorOne.b3"
          v-if="floorPlan.floorOne.bedrooms > 2"
          id="f1r3"
          v-on:change="updateSqFtUsage('f1r3')"
        >
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <label
          for="f1bedroom4-size"
          class="bedroom-size"
          v-if="floorPlan.floorOne.bedrooms > 3"
          >Select Bedroom Size:</label
        >
        <select
          name="f1bedroom4-size"
          v-model="floorPlan.floorOne.b4"
          v-if="floorPlan.floorOne.bedrooms > 3"
          id="f1r4"
          v-on:change="updateSqFtUsage('f1r4')"
        >
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <label
          for="f1bedroom5-size"
          class="bedroom-size"
          v-if="floorPlan.floorOne.bedrooms > 4"
          >Select Bedroom Size:</label
        >
        <select
          name="f1bedroom5-size"
          v-model="floorPlan.floorOne.b5"
          v-if="floorPlan.floorOne.bedrooms > 4"
          id="f1r5"
          v-on:change="updateSqFtUsage('f1r5')"
        >
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <!-- First Floor Bathrooms -->

        <label for="f1bathrooms" class="bathrooms">Select Floor 1 Bathrooms</label>
        <select name ="f1bathrooms" v-model="floorPlan.floorOne.bathrooms" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

        <label for="f1bathroom-size" class="bathroom-size">
          Select Master Bathroom Size:
        </label>
        <select
          name="f1bathroom1-size"
          v-model="floorPlan.floorOne.ba1"
          required
          id="f1b1"
          v-on:change="updateSqFtUsage('f1b1')">
          <option value="8x12">8x12</option>
          <option value="6x12">6x12</option>
          <option value="6x10">6x10</option></select
        >

        <label
          for="f1bathroom2-size"
          class="bathroom-size"
          v-if="floorPlan.floorOne.bathrooms > 1"
        >
          Select Bathroom Size:</label
        >
        <select
          name="bathroom-size"
          v-model="floorPlan.floorOne.ba2"
          v-if="floorPlan.floorOne.bathrooms > 1" required
          id="f1b2"
          v-on:change="updateSqFtUsage('f1b2')">
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label for="f1bathroom2-size" class="bathroom-size"  v-if="floorPlan.floorOne.bathrooms > 2">
          Select Bathroom Size:
        </label>
        <select name="bathroom-size" v-model="floorPlan.floorOne.ba3" v-if="floorPlan.floorOne.bathrooms > 2" required
          id="f1b3"
          v-on:change="updateSqFtUsage('f1b3')">
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option>
          </select>

        <label for="f1bathroom3-size" class="bathroom-size" v-if="floorPlan.floorOne.bathrooms > 3">
        Select Bathroom Size:
        </label>
        <select name="bathroom-size" v-model="floorPlan.floorOne.ba4" v-if="floorPlan.floorOne.bathrooms > 3" required
          id="f1b4"
          v-on:change="updateSqFtUsage('f1b4')">
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option>
          </select>

          <!--  -->
          <!-- Second Floor -->
          <!--  -->

        <label for="f2bedroom" class="bedrooms" v-if="floorPlan.floors > 1">Select Floor 2 Bedrooms</label>
        <select name ="f2bedroom" v-model="floorPlan.floorTwo.bedrooms" v-if="floorPlan.floors > 1"
          >
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>

        <label
          for="f2bedroom4-size"
          class="bedroom-size"
          v-if="floorPlan.floorTwo.bedrooms > 3"
          >Select Bedroom Size:</label
        >
        <select
          name="f2bedroom4-size"
          v-model="floorPlan.floorTwo.b4"
          v-if="floorPlan.floorTwo.bedrooms > 3"
          id="f2r1"
          v-on:change="updateSqFtUsage('f2r1')"
        >
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <label
          for="f2bedroom5-size"
          class="bedroom-size"
          v-if="floorPlan.floorTwo.bedrooms > 4"
          >Select Bedroom Size:</label
        >
        <select
          name="f2bedroom5-size"
          v-model="floorPlan.floorTwo.b5"
          v-if="floorPlan.floorTwo.bedrooms > 4"
           id="f2r2"
          v-on:change="updateSqFtUsage('f2r2')"
        >
          <option value="14x16">Large Bedroom: 14x16</option>
          <option value="11x12">Standard Bedroom: 11x12</option>
        </select>

        <!-- Second Floor Bathrooms -->
        <label for="f2bathrooms" class="bathrooms" v-if="floorPlan.floors > 1">Select Floor 2 Bathrooms</label>
        <select name ="f2bathrooms" v-model="floorPlan.floorTwo.bathrooms" v-if="floorPlan.floors > 1" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

        <label for="f2bathroom2-size" class="bathroom-size"
          v-if="floorPlan.floorTwo.bathrooms > 0"
        > Select Bathroom Size:</label>
        <select
          name="f2bathroom1-size"
          v-model="floorPlan.floorTwo.ba1"
          v-if="floorPlan.floorTwo.bathrooms > 0"
          required
          id="f2b1"
          v-on:change="updateSqFtUsage('f2b1')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f2bathroom2-size"
          class="bathroom-size"
          v-if="floorPlan.floorTwo.bathrooms > 1"
        >
          Select Bathroom Size:</label
        >
        <select
          name="f2bathroom2-size"
          v-model="floorPlan.floorTwo.ba2"
          v-if="floorPlan.floorTwo.bathrooms > 1"
          required
          id="f2b2"
          v-on:change="updateSqFtUsage('f2b2')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f2bathroom3-size"
          class="bathroom-size"
          v-if="floorPlan.floorTwo.bathrooms > 2"
        >
          Select Bathroom Size:
        </label>
        <select
          name="f2bathroom3-size"
          v-model="floorPlan.floorTwo.ba3"
          v-if="floorPlan.floorTwo.bathrooms > 2"
          required
          id="f2b3"
          v-on:change="updateSqFtUsage('f2b3')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f2bathroom4-size"
          class="bathroom-size"
          v-if="floorPlan.floorTwo.bathrooms > 3"
        >
          Select Bathroom Size:
        </label>
        <select
          name="f2bathroom4-size"
          v-model="floorPlan.floorTwo.ba4"
          v-if="floorPlan.floorTwo.bathrooms > 3"
          required
          id="f2b4"
          v-on:change="updateSqFtUsage('f2b4')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >
        <!--  -->
        <!-- Third Floor -->
        <!--  -->

        <label for="f3bedroom" class="bedrooms" v-if="floorPlan.floors > 2">Select Floor 3 Bedrooms</label>
        <select
          name="f3bedroom"
          v-model="floorPlan.floorThree.bedrooms"
          v-if="floorPlan.floors > 2">
        <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>

        <label for="f3bedroom1-size" class="bedroom-size" v-if="floorPlan.floorTwo.bedrooms > 0"> Select Bedroom Size:</label>
         <select name ="f3bedroom1-size" v-model="floorPlan.floorThree.b1" v-if="floorPlan.floorTwo.bedrooms > 0"
           id="f3r1"
          v-on:change="updateSqFtUsage('f3r1')">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select>

         <label for="f3bedroom2-size" class="bedroom-size" v-if="floorPlan.floorThree.bedrooms > 1">Select Bedroom Size:</label>
         <select name ="f3bedroom2-size" v-model="floorPlan.floorThree.b2" v-if="floorPlan.floorThree.bedrooms > 1"
            id="f3r2"
            v-on:change="updateSqFtUsage('f3r2')">
             <option selected value> -- select an option -- </option>
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select>

         <label for="f3bedroom3-size" class="bedroom-size" v-if="floorPlan.floorThree.bedrooms > 2">Select Bedroom Size:</label>
         <select name ="f3bedroom3-size" v-model="floorPlan.floorThree.b3" v-if="floorPlan.floorThree.bedrooms > 2"
            id="f3r3"
            v-on:change="updateSqFtUsage('f3r3')">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select>

         <label for="f3bedroom4-size" class="bedroom-size" v-if="floorPlan.floorThree.bedrooms > 3">Select Bedroom Size:</label>
         <select name ="f3bedroom4-size" v-model="floorPlan.floorThree.b4" v-if="floorPlan.floorThree.bedrooms > 3"
            id="f3r4"
            v-on:change="updateSqFtUsage('f3r4')">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select>

         <label for="f3bedroom5-size" class="bedroom-size" v-if="floorPlan.floorThree.bedrooms > 4">Select Bedroom Size:</label>
         <select name ="f3bedroom5-size" v-model="floorPlan.floorThree.b5" v-if="floorPlan.floorThree.bedrooms > 4"
            id="f3r5"
            v-on:change="updateSqFtUsage('f3r5')">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select>

        <!--Third Floor Bathrooms -->

        <label for="f3bathrooms" class="bathooms" v-if="floorPlan.floors > 2"
          >Select Floor 3 Bathrooms</label
        >
        <select
          name="f3bathrooms"
          v-model="floorPlan.floorThree.bathrooms"
          v-if="floorPlan.floors > 2"
          required
        >
          <option value="0">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

        <label
          for="f3bathroom-size"
          class="bathroom-size"
          v-if="floorPlan.floorThree.bathrooms > 0"
        >
          Select Bathroom Size:
        </label>
        <select
          name="f3bathroom1-size"
          v-model="floorPlan.floorThree.ba1"
          v-if="floorPlan.floorThree.bathrooms > 0"
          required
          id="f3b1"
          v-on:change="updateSqFtUsage('f3b1')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f3bathroom2-size"
          class="bathroom-size"
          v-if="floorPlan.floorThree.bathrooms > 1"
        >
          Select Bathroom Size:</label
        >
        <select
          name="f3bathroom2-size"
          v-model="floorPlan.floorThree.ba2"
          v-if="floorPlan.floorThree.bathrooms > 1"
          required
          id="f3b2"
          v-on:change="updateSqFtUsage('f3b2')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f3bathroom3-size"
          class="bathroom-size"
          v-if="floorPlan.floorThree.bathrooms > 2"
        >
          Select Bathroom Size:
        </label>
        <select
          name="f3bathroom3-size"
          v-model="floorPlan.floorThree.ba3"
          v-if="floorPlan.floorThree.bathrooms > 2"
          required
          id="f3b3"
          v-on:change="updateSqFtUsage('f3b3')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <label
          for="f3bathroom4-size"
          class="bathroom-size"
          v-if="floorPlan.floorThree.bathrooms > 3"
        >
          Select Bathroom Size:
        </label>
        <select
          name="f3bathroom4-size"
          v-model="floorPlan.floorThree.ba4"
          v-if="floorPlan.floorThree.bathrooms > 3"
          required
          id="f3b4"
          v-on:change="updateSqFtUsage('f3b4')"
        >
          <option value="6x10">Large Bathroom: 6x10</option>
          <option value="5x8">Standard Bathroom: 5x8</option>
          <option value="4x6">Half Bath: 4x6</option></select
        >

        <h2>Optional Rooms</h2>

        <label for="basement" class="basement"> Select Basement </label>
        <select v-model="floorPlan.basement" id="b"
          v-on:change="updateSqFtUsage('b')">
          <option value="0"> No basement </option>
          <option value="15x15"> Unfinished Basement </option>
          <!--idk value for finished vs unfinished? -->
          <option value="15*15"> Finished Basement </option>
          </select>

        <label for="dining-room" class="dining-room"> Select Dining Room</label>
        <select v-model="floorPlan.diningRoom"
          id="dr"
          v-on:change="updateSqFtUsage('dr')">
          <option value="16x18">Large Dining Room: 16x18</option>
          <option value="14x16">Standard Dining Room: 14x16</option>
          <option value="12x14">Small Dining Room: 12x14</option>
        </select>

        <label for="entertainment-room" class="entertainment-room"> Select Entertainment Space</label>
        <select v-model="floorPlan.livingRoom" id="er"
          v-on:change="updateSqFtUsage('er')">
          <option value="14x16">Formal Living Room: 14x16</option>
          <option value="14x16">Family Room: 14x16</option>
          <option value="10x12">Sitting Room: 9x12 </option>
        </select>

      <!--Add floor -->
        <label for="spare-room" class="spare-room"> Select ? Space</label>
        <select v-model="floorPlan.spareRoom" id="sr"
          v-on:change="updateSqFtUsage('sr')">
          <option value="16x18">Den</option>
          <option value="16x18">Study</option>
        </select>

       <span>
         <button class="bck-btn" @click.prevent="goToPlanDetails"> Previous
          </button>

        <button class="next-btn" @click.prevent="goToRoomDesign"> Next
        </button>
        <p class="sizeError" v-if="this.sqFtUsed >= this.floorPlan.squareFootage">You will not have enough space to fit all of these rooms.
        You are currently at {{this.sqFtUsed}} of a possible square feet.{{this.floorPlan.squareFootage}}</p>
        </span>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sqFtUsed: 0,
      floorPlan: {
        userId: "",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        squareFootage: "",
        floors: 1,
        livingRoom: "10x13",
        kitchen: "10x10",
        basement:"0",
        costHigh: 0,
        costLow: 0,
        floorOne: {
          bedrooms: "1",
          b1: "14x16",
          b2: "",
          b3: "",
          b4: "",
          b5: "",
          bathrooms: "1",
          ba1: "6x10",
          ba2: "",
          ba3: "",
          ba4: "",
        },
        floorTwo: {
          bedrooms: "",
          b1: "",
          b2: "",
          b3: "",
          b4: "",
          b5: "",
          bathrooms: "",
          ba1: "",
          ba2: "",
          ba3: "",
          ba4: "",
        },
        floorThree: {
          bedrooms: "",
          b1: "",
          b2: "",
          b3: "",
          b4: "",
          b5: "",
          bathrooms: "",
          ba1: "",
          ba2: "",
          ba3: "",
          ba4: "",
        },
        bedrooms: [],
        bathrooms: [],
      },
      floorPlanPresetOne: {
        userId: "",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        squareFootage: 1000,
        floors: 1,
        livingRoom: "",
        kitchen: "",
        basement:"",
        costHigh: 0,
        costLow: 0,
      },
      bedroomCount: 0,
      bathroomCount: 0,
      bedrooms: [],
      bathrooms: [],
    };
  },
  methods: {
    goToRoomDesign() {
      if (this.sqFtUsed <= this.floorPlan.squareFootage) {
        this.$router.push('/room-design'); 
      }
     },
     goToPlanDetails() {
      this.$router.push('/details')
     },
     updateSqFtUsage(id) {
      let room = document.getElementById(id);
      let dimensions = room.value.split("x");
      let roomSize = parseInt(dimensions[0]) * parseInt(dimensions[1]);
      this.sqFtUsed += roomSize; 
     }
  },
  created() {
      console.log(this.$store.state.floorPlan);
      this.floorPlan.userId = this.$store.state.floorPlan.userId;
      this.floorPlan.planName = this.$store.state.floorPlan.planName;
      this.floorPlan.houseType = this.$store.state.floorPlan.houseType;
      this.floorPlan.city = this.$store.state.floorPlan.city;
      this.floorPlan.state = this.$store.state.floorPlan.state;
      this.floorPlan.squareFootage = this.$store.state.floorPlan.squareFootage;
      this.floorPlan.costHigh = this.$store.state.floorPlan.costHigh;
      this.floorPlan.costLow = this.$store.state.floorPlan.costLow;

      this.sqFtUsed = this.floorPlan.squareFootage * 0.05;
    }
}
</script>

<style scoped>
.main {
  display: grid;
  height: 75vh;
  margin-top: 50px;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
}
.plan-builder {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
  width: 60vw;
  background-color: #264653;
  border-radius: 10px;
  padding: 10px;
  color: white;
}
h1 {
  text-emphasis: bold;
}

.form-builder {
  margin-top: 15px;
  grid-area: form;
  display: grid;
  justify-content: center;
  width: 50%;
}
/* .required-rooms{
   margin-top: 15px;
  display: grid;
  justify-content: center;
  width: 100%;
  padding: 10px;
} */

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

span{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "button button"
  "sizeError sizeError";
  justify-content: center;
  gap: 10px;
  }

.sizeError {
  align-self: center;
  grid-area: sizeError;
}  
</style>

// <!-- </div> -->
//         <!-- <label for="bedroom1Size" class="bedroom"> Select Bedroom Size: </label>
//         <select name ="bedroom1Size" v-model="floorPlan.bedrooms" required>
//              <option value = "1">1</option>
//              <option value = "2">2</option>
//              <option value = "3">3</option>
//              <option value = "4">4</option>
//          </select><br> -->

//         <!-- <button id="add-room" v-on:click.prevent="addBedroom">
//           Add Bedroom</button
//         ><br> -->
//         <!-- <label for="bathroom" class="bathroom"> Select Number of Bathrooms:</label> -->
//         <!-- <select name ="bathroom" v-model="floorPlan.bathrooms" required>
//              <option value = "1">1</option>
//              <option value = "2">2</option>
//              <option value = "3">3</option>
//          </select><br> -->

//         <!-- <label for="bathroom-size" class="bathroom-size"> Select Bathroom Size: </label> -->
//         <!-- <select name ="bathroom-size" v-model="floorPlan.bathrooms" required>
//              <option value = "6x12">Master Bathroom: 6x12</option>
//              <option value = "5x8">Standard Bathroom: 5x8</option>
//              <option value = "4x6">Half Bath: 4x6</option>
//          </select><br> -->

//         <!-- <button id="add-bathroom" v-on:click.prevent="addBathroom">
//           Add Bathroom</button
//         ><br /> -->
//         <!-- <div class="optional-rooms"> -->
//             ,



//     saveRooms() {
//       this.floorPlan.bedrooms = this.bedrooms;
//       this.floorPlan.bathrooms = this.bathrooms;
//     },
//     addBedroom() {
//       this.bedroomCount++;
//       const label = document.createElement("label");
//       const roomSelection = document.createElement("select");
//       const lineBreak = document.createElement("br");
//       roomSelection.className = "new-bedroom";
//       label.innerText = "Bedroom " + this.bedroomCount + ": ";

//       roomSelection.innerHTML =
//         "<option value = ''/>" +
//         "<option value = '14x16'> Master Bedroom: 14x16 </option>" +
//         "<option value = '11x12'>Standard Bedroom: 11x12</option>" +
//         "<option value='10x10'>Smalll Bedroom: 10x10</option>";

//       const roomToAdd = document.getElementById("add-room");

//       roomToAdd.parentNode.insertBefore(label, roomToAdd);
//       roomToAdd.parentNode.insertBefore(roomSelection, roomToAdd);
//       roomToAdd.parentNode.insertBefore(lineBreak, roomToAdd);
//       console.log(this.floorPlan);
//       roomSelection.addEventListener("change", (event) => {
//         console.log(event.target.value);
//         this.bedrooms.push(event.target.value);
//       });
//     },
//     addBathroom() {
//       this.bathroomCount++;
//       const label = document.createElement("label");
//       const roomSelection = document.createElement("select");
//       const lineBreak = document.createElement("br");
//       roomSelection.className = "new-bathroom";

//       label.innerText = "Bathroom " + this.bathroomCount + ": ";

//       roomSelection.innerHTML =
//         "<option value = ''/>" +
//         "<option value = 'masterBath'>Master Bathroom: 6x12</option>" +
//         "<option value = 'standardBath'>Standard Bathroom: 5x8</option>" +
//         "<option value = 'halfBath'>Half Bath: 4x6</option>";

//       const roomToAdd = document.getElementById("add-bathroom");

//       roomToAdd.parentNode.insertBefore(label, roomToAdd);
//       roomToAdd.parentNode.insertBefore(roomSelection, roomToAdd);
//       roomToAdd.parentNode.insertBefore(lineBreak, roomToAdd);
//       console.log(this.floorPlan);
//       roomSelection.addEventListener("change", (event) => {
//         console.log(event.target.value);
//         this.bathrooms.push(event.target.value);
//       });
//     },
//   },