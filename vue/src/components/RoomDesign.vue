<template>
  <div>
      <h1>Room Design</h1>
      
      <label for="f1layout" class="f1layout">I would like Floor One to have a: </label>
      <select name ="f1layout" v-model="roomDesign.layout">
      <option value="open"> Open Floor Plan</option>
      <option value="traditional">Traditional Floor Plan</option>
      </select>
      </div>
</template>

<script>
export default {
    data(){
        return{
            roomDesign: {
                layout: "",
                
            }
        }
    }

}
</script>

<style>
div{
    color: black;
}
</style>