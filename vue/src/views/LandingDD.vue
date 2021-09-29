<template>
  <div class="landing">
   <div draggable="true">content</div>
   <div draggable="true">content</div>
   <div draggable="true">content</div>
  </div>
</template>

<script>

export default {
  name: "landing",
};
</script>

<style scoped>
.landing{
  display: grid;
  grid-template-columns: repeat(10,1fr);
  grid-template-rows: repeat(10,1fr);
  background-color: wheat;
  height: 400px;
  width: 400px;
  border: 2px solid black;
  gap: 10px;
}
</style>