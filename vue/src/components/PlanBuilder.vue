<template>
  <div class='main'>
  <div class='plan-builder'>
      <form> 
          <h1>Room Types</h1>
         <label for="livingRoom" class="living-room"> Select Living Room Size: </label>
         <select name ="living-room" v-model="floorPlan.livingRoom" required>
             <option value = "10x13">10x13</option>
             <option value = "12x18">12x18</option>
             <option value = "15x20">15x20</option>
         </select> <br>
         <label for="kitchen" class="kitchen"> Select Kitchen Size: </label>
         <select name ="kitchen" v-model="floorPlan.kitchen" required>
             <option value = "10x10">10x10</option>
             <option value = "20x20">20x20</option>
         </select><br>
         <!-- <label for="bedroom" class="bedroom"> Select Number of Bedrooms: </label>
         <select name ="bedroom" v-model="floorPlan.bedrooms" required>
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
             <option value = "4">4</option>
         </select><br> -->
         <button id="add-room" v-on:click.prevent="addRoom">Add Bedroom</button><br>
          <!-- <label for="bedroom-size" class="bedroom-size"> Select Bedroom Size:</label>
         <select name ="bedroom-size">
             <option value = "masterBed">Master Bedroom: 14x16</option>
             <option value = "standardBed">Standard Bedroom: 11x12</option>
         </select><br> -->
         <label for="bathroom" class="bathroom"> Select Number of Bathrooms:</label>
         <select name ="bathroom" v-model="floorPlan.bathrooms" required>
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
         </select><br>
          <label for="bathroom-size" class="bathroom-size"> Select Bathroom Size: </label>
         <select name ="bathroom-size">
             <option value = "masterBath">Master Bathroom: 6x12</option>
             <option value = "standardBath">Standard Bedroom: 5x8</option>
             <option value = "halfBath">Half Bath: 4x6</option>
         </select><br>
         <button>Next</button>
         </form>
  </div> 
  </div>
</template>

<script>
export default {
    data(){
        return {
            floorPlan: {
                livingRoom: "",
                kitchen: "",
                bedrooms:[],
                bathrooms:[]
            },
            bedroomCount:0,
            bathroomCount:0,
            }   
    },
    methods: {
      addBedroom(){
        this.bedroomCount++
        const label = document.createElement("label")
        const roomSelection = document.createElement("select")
        const lineBreak = document.createElement("br")
        roomSelection.className="new-bedroom"

        label.innerText="Bedroom "+this.bedroomCount+": "

        roomSelection.innerHTML="<option value='5x5'>5x5</option>"+
                                "<option value='7x7'>7x7</option>"+
                                "<option value='10x10'>10x10</option>"
        
        const roomToAdd = document.getElementById("add-room")
        
        roomToAdd.parentNode.insertBefore(label, roomToAdd)
        roomToAdd.parentNode.insertBefore(roomSelection, roomToAdd)
        roomToAdd.parentNode.insertBefore(lineBreak, roomToAdd)
        console.log(this.floorPlan)
      }
    }

}
</script>

<style scoped>
.main{
 text-align: center;
 background: #264653;
 color: white;
}
h1{
    text-emphasis: bold;
}
select{
    margin: 0.75em;
}
</style>