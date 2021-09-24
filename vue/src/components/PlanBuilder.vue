<template>
  <div class="main">
    <div class="plan-builder">
      <form class="form-builder">
        <!--submit? method to save? -->

        <h2>Square Footage</h2>
        <label for="sq-footage" class="sq-footage">
          Select Square Footage:
        </label>
        <select name="sq-footage" v-model="floorPlan.squareFootage" required>
          <option value="1000">1000 sq. feet</option>
          <option value="1500">1500 sq. feet</option>
          <option value="2000">2000 sq. feet</option>
          <option value="2500">2500 sq. feet</option>
          <option value="3000">3000 sq. feet</option></select
        ><br />

        <h2>Floors</h2>
        <label for="floors" class="floors"> Select Number of Floors: </label>
        <select name="floors" v-model="floorPlan.floors" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option></select
        ><br />

        <h2>Room Types</h2>
        <label for="livingRoom" class="living-room">
          Select Living Room Size:
        </label>
        <select name="living-room" v-model="floorPlan.livingRoom" required>
          <option value="10x13">10x13</option>
          <option value="12x18">12x18</option>
          <option value="15x20">15x20</option>
        </select>
        <br>

        <label for="kitchen" class="kitchen"> Select Kitchen Size: </label>
        <select name="kitchen" v-model="floorPlan.kitchen" required>
          <option value="10x10">10x10</option>
          <option value="20x20">20x20</option>
        </select>
          <br>

        <label for="bedroom1" class="bedrooms">Select Floor 1 Bedrooms</label>
        <select name ="bedroom1" v-model="floorPlan.floorOne.bedrooms" required>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select><br>

        <label for="f1bedroom1-size" class="bedroom-size"> Select Master Bedroom Size:</label>
         <select name ="f1bedroom1-size" v-model="floorPlan.floorOne.b1" required>
             <option value = "14x16">14x16</option>
             <option value = "16x16">16x16</option>
         </select><br>

         <label for="f1bedroom2-size" class="bedroom-size" v-if="floorPlan.floorOne.bedrooms > 1">Select Bedroom Size:</label>
         <select name ="f1bedroom2-size" v-model="floorPlan.floorOne.b2" v-if="floorPlan.floorOne.bedrooms > 1">
             <option selected value> -- select an option -- </option>
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select><br>

         <label for="f1bedroom3-size" class="bedroom-size" v-if="floorPlan.floorOne.bedrooms > 2">Select Bedroom Size:</label>
         <select name ="f1bedroom3-size" v-model="floorPlan.floorOne.b3" v-if="floorPlan.floorOne.bedrooms > 2">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select><br>

         <label for="f1bedroom4-size" class="bedroom-size" v-if="floorPlan.floorOne.bedrooms > 3">Select Bedroom Size:</label>
         <select name ="f1bedroom4-size" v-model="floorPlan.floorOne.b4" v-if="floorPlan.floorOne.bedrooms > 3">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select><br>

         <label for="f1bedroom5-size" class="bedroom-size" v-if="floorPlan.floorOne.bedrooms > 4">Select Bedroom Size:</label>
         <select name ="f1bedroom5-size" v-model="floorPlan.floorOne.b5" v-if="floorPlan.floorOne.bedrooms > 4">
             <option value = "14x16">Large Bedroom: 14x16</option>
             <option value = "11x12">Standard Bedroom: 11x12</option>
         </select><br>

        <!-- <label for="bedroom1Size" class="bedroom"> Select Bedroom Size: </label>
        <select name ="bedroom1Size" v-model="floorPlan.bedrooms" required>
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
             <option value = "4">4</option>
         </select><br> -->

        <!-- <button id="add-room" v-on:click.prevent="addBedroom">
          Add Bedroom</button
        ><br> -->
        <!-- <label for="bathroom" class="bathroom"> Select Number of Bathrooms:</label> -->
        <!-- <select name ="bathroom" v-model="floorPlan.bathrooms" required>
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
         </select><br> -->

        <!-- <label for="bathroom-size" class="bathroom-size"> Select Bathroom Size: </label> -->
        <!-- <select name ="bathroom-size" v-model="floorPlan.bathrooms" required>
             <option value = "6x12">Master Bathroom: 6x12</option>
             <option value = "5x8">Standard Bathroom: 5x8</option>
             <option value = "4x6">Half Bath: 4x6</option>
         </select><br> -->

        <!-- <button id="add-bathroom" v-on:click.prevent="addBathroom">
          Add Bathroom</button
        ><br /> -->
        <button class="next-btn" v-on:click.prevent="saveRooms">Next</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      floorPlan: {
        userId: "",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        squareFootage: "",
        floors: "",
        livingRoom: "",
        kitchen: "",
        floorOne: {
            bedrooms: "",
            b1: "",
            b2: "",
            b3: "",
            b4: "",
            b5: "",
        },
        bedrooms: [],
        bathrooms: [],
      },
      bedroomCount: 0,
      bathroomCount: 0,
      bedrooms: [],
      bathrooms: [],
    };
  },
  methods: {
    saveRooms() {
      this.floorPlan.bedrooms = this.bedrooms;
      this.floorPlan.bathrooms = this.bathrooms;
    },
    addBedroom() {
      this.bedroomCount++;
      const label = document.createElement("label");
      const roomSelection = document.createElement("select");
      const lineBreak = document.createElement("br");
      roomSelection.className = "new-bedroom";
      label.innerText = "Bedroom " + this.bedroomCount + ": ";

      roomSelection.innerHTML =
        "<option value = ''/>" +
        "<option value = '14x16'> Master Bedroom: 14x16 </option>" +
        "<option value = '11x12'>Standard Bedroom: 11x12</option>" +
        "<option value='10x10'>Smalll Bedroom: 10x10</option>";

      const roomToAdd = document.getElementById("add-room");

      roomToAdd.parentNode.insertBefore(label, roomToAdd);
      roomToAdd.parentNode.insertBefore(roomSelection, roomToAdd);
      roomToAdd.parentNode.insertBefore(lineBreak, roomToAdd);
      console.log(this.floorPlan);
      roomSelection.addEventListener("change", (event) => {
        console.log(event.target.value);
        this.bedrooms.push(event.target.value);
      });
    },
    addBathroom() {
      this.bathroomCount++;
      const label = document.createElement("label");
      const roomSelection = document.createElement("select");
      const lineBreak = document.createElement("br");
      roomSelection.className = "new-bathroom";

      label.innerText = "Bathroom " + this.bathroomCount + ": ";

      roomSelection.innerHTML =
        "<option value = ''/>" +
        "<option value = 'masterBath'>Master Bathroom: 6x12</option>" +
        "<option value = 'standardBath'>Standard Bathroom: 5x8</option>" +
        "<option value = 'halfBath'>Half Bath: 4x6</option>";

      const roomToAdd = document.getElementById("add-bathroom");

      roomToAdd.parentNode.insertBefore(label, roomToAdd);
      roomToAdd.parentNode.insertBefore(roomSelection, roomToAdd);
      roomToAdd.parentNode.insertBefore(lineBreak, roomToAdd);
      console.log(this.floorPlan);
      roomSelection.addEventListener("change", (event) => {
        console.log(event.target.value);
        this.bathrooms.push(event.target.value);
      });
    },
  },
};
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
  color: white;
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
}
h1 {
  text-emphasis: bold;
}

.form-builder {
  margin-top: 15px;
  grid-area: form;
  display: grid;
  justify-content: center;
  width: 55%;
  padding: 10px;
}

.next-btn {
  margin: 15px auto;
  min-width: 150px;
  height: 35px;
  font-size: 16pt;
  border-radius: 15px;
  border: none;
  background-color: #e76f51;
}
</style>