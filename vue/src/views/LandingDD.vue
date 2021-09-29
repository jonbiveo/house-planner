<template>
  <div class="landing">
    <div ondrop="this.methods.drop(event)" ondragover="this.methods.allowDrop(event)">
      <span draggable="true" ondragstart="drag(event)">content</span>
    </div>
    <div draggable="true">content</div>
    <div draggable="true">content</div>
  </div>
</template>

<script>
export default {
  name: "landing",
  methods: {
    allowDrop(ev) {
      ev.preventDefault();
    },

    drag(ev) {
      ev.dataTransfer.setData("text", ev.target.id);
    },

    drop(ev) {
      ev.preventDefault();
      var data = ev.dataTransfer.getData("text");
      ev.target.appendChild(document.getElementById(data));
    },
  },
};
</script>

<style scoped>
.landing {
  display: grid;
  grid-template-columns: repeat(10, 1fr);
  grid-template-rows: repeat(10, 1fr);
  background-color: wheat;
  height: 400px;
  width: 400px;
  border: 2px solid black;
  gap: 10px;
}
</style>