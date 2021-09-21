<template>
  <div>
    <div>
      <form>
        Plan Name:
        <input type="text" v-model="planBase.name" />
        <label for="house-types">Select House Type:</label>
        <select name="house-types" v-model="planBase.houseType">
          <option value="single">Single-Family</option>
          <option value="detached">Detached</option>
          <option value="townhouse">Townhouse</option>
        </select>
        <label for="region-types">Select Region:</label>
        <select name="region-types" v-model="planBase.region">
          <option value="Northeast">Northeast</option>
          <option value="South">South</option>
          <option value="Southwest">Southwest</option>
          <option value="Midwest">Midwest</option>
          <option value="West">West</option>
        </select>
        <input type="button" value="Next" />
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      planBase: {
        name: "",
        houseType: "",
        region: "",
      },
    };
  },
  methods: {
    saveBase() {
      console.log("b");
    },
  },
};
</script>

<style>
</style>