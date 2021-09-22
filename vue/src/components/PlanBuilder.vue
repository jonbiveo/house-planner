<template>
  <div class='main'>
  <div class='plan-builder'>
      <form>
          <h1>Room Types</h1>
         <label for="livingRoom" class="living-room"> Select Living Room Size: </label>
         <select name ="living-room">
             <option value = "10x13">10x13</option>
             <option value = "12x18">12x18</option>
             <option value = "15x20">15x20</option>
         </select> <br>
         <label for="kitchen" class="kitchen"> Select Living Room Size: </label>
         <select name ="kitchen">
             <option value = "10x10">10x10</option>
             <option value = "20x20">20x20</option>
         </select><br>
         <label for="bedroom" class="bedroom"> Select Number of Bedrooms: </label>
         <select name ="bedroom">
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
             <option value = "4">4</option>
         </select><br>
         <!-- need drop downs for each bedroom selected -->
          <label for="bedroom-size" class="bedroom-size"> Select Bedroom Size:</label>
         <select name ="bedroom-size">
             <option value = "masterBed">Master Bedroom: 14x16</option>
             <option value = "standardBed">Standard Bedroom: 11x12</option>
         </select><br>
         <label for="bathroom" class="bathroom"> Select Number of Bathrooms:</label>
         <select name ="bathroom">
             <option value = "1">1</option>
             <option value = "2">2</option>
             <option value = "3">3</option>
         </select><br>
         <!-- need drop downs for each bathroom selected -->
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
            }

            }   
    }

}
</script>

<style scoped>
.main{
 text-align: center;
}
h1{
    text-emphasis: bold;
}
select{
    margin: 0.75em;
}
</style>