<template>
  <div class = 'plan-details'>
    <div>
      <form v-on:submit.prevent="saveBase" class='form-plan'>
        Plan Name:
        <input type="text" class='plan-name' v-model="planBase.name" />
        <label for="house-types" class='house-types'>Select House Type:</label>
        <select name="house-types" v-model="planBase.houseType">
          <option value="single">Single-Family</option>
          <option value="detached">Detached</option>
          <option value="townhouse">Townhouse</option>
        </select>
        <!-- <label for="region-types">Select Region:</label>
        <select name="region-types" v-model="planBase.region">
          <option value="Northeast">Northeast</option>
          <option value="South">South</option>
          <option value="Southwest">Southwest</option>
          <option value="Midwest">Midwest</option>
          <option value="West">West</option>
        </select> -->
        <label for="City" class='city'>Select City:</label>
        <select name="city" v-model="planBase.city">
          <option value="Cleveland">Cleveland</option>
          <option value="Cincinnati">Cincinnati</option>
          <option value="Columbus">Columbus</option>
          <option value="Toledo">Toledo</option>
        </select>
        <label for="State" class='state'>Select State:</label>
        <select name="state" v-model="planBase.state">
          <option value="Ohio">OH</option>
        </select>
        <label for="square-foot" class='size'>Select Square Footage:</label>
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
        city: "",
        state: "",
        size: ""
      },
    };
  },
  methods: {
    saveBase() {
      const newPlan = {
        name:this.planBase.name,
        houseType: this.planBase.houseType,
        city:this.planBase.city,
        state: this.planBase.state,
        size: this.planBase.size
      }
      console.log(newPlan)
      planService
      .create(newPlan)
      .then(
        this.planBase = {
        name: '',
        houseType: '',
        city: '',
        state:'',
        size: ''},
        this.$router.push("/plan-builder")
      )
    },
  },
};
</script>

<style scoped>
</style>