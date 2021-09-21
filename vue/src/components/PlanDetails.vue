<template>
  <div>
    <div>
      <form v-on:submit.prevent="saveBase">
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
        <label for="square-foot">Select Square Footage:</label>
        <select name="square-foot" v-model="planBase.size">
          <option value="1000">1000</option>
          <option value="1500">1500</option>
          <option value="2000">2000</option>
          <option value="2500">2500</option>
        </select>
        <button>Next</button>
      </form>
    </div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";
export default {
  data() {
    return {
      planBase: {
        name: "",
        houseType: "",
        region: "",
        size: ""
      },
    };
  },
  methods: {
    saveBase() {
      const newPlan = {
        name:this.planBase.name,
        houseType: this.planBase.houseType,
        region:this.planBase.region,
        size: this.newPlan.size,
      }
      console.log(newPlan)
      planService
      .create(newPlan)
      .then(
        this.planBase = {
        name: '',
        houseType: '',
        region: ''},
        this.$router.push("/plan-builder")
      )
    },
  },
};
</script>

<style>
</style>