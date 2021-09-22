<template>
  <div class = 'plan-details'>
    <div>
      <form v-on:submit.prevent="saveBase" class='form-plan'>
        Plan Name:
        <input type="text" class='plan-name' v-model="planBase.name" />
        <label for="house-types" class='house-types'>Select House Type:</label>
        <select name="house-types" v-model="planBase.houseType" required>
          <option value="single">Single-Family</option>
          <option value="detached">Detached</option>
          <option value="townhouse">Townhouse</option>
          <option value="land">Empty Lot</option>
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
        <select name="city" v-model="planBase.city" required>
          <option value="Cleveland">Cleveland</option>
          <option value="Cincinnati">Cincinnati</option>
          <option value="Columbus">Columbus</option>
          <option value="Toledo">Toledo</option>
        </select>
        <label for="State" class='state'>Select State:</label>
        <select name="state" v-model="planBase.state" required>
          <option value="Ohio">OH</option>
        </select>
        <label for="square-foot" class='size'>Select Minimum Square Footage:</label>
        <select v-if="planBase.houseType !== 'land'" name="square-foot" v-model="planBase.size" required>
          <option value="1000">1000</option>
          <option value="1500">1500</option>
          <option value="2000">2000</option>
          <option value="2500">2500</option>
        </select>
        <select v-if="planBase.houseType === 'land'" name="square-foot" v-model="planBase.size" required>
          <option value="2000">2000</option>
          <option value="4000">4000</option>
          <option value="5000">5000</option>
          <option value="7500">7500</option>
        </select>
        <button>Next</button>
      </form>
      <div v-if="priceCeiling !== -1">
        <h3>${{priceFloor}} - ${{priceCeiling}}</h3>
      </div>
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
      priceFloor: -1,
      priceCeiling: -1
    };
  },
  methods: {
    saveBase() {
      let options = {};
      this.priceFloor = -1;
      this.priceCeiling = -1;
      if (this.planBase.houseType !== "land") {
        options = planService.setPropertyInfo({offset: '0', limit: '10', sort: 'newest', state_code: this.planBase.state, 
        city: this.planBase.city, property_type: this.planBase.houseType, home_size_min: this.planBase.size});
      } else {
        options = planService.setPropertyInfo({offset: '0', limit: '10', sort: 'newest', state_code: this.planBase.state, 
        city: this.planBase.city, property_type: this.planBase.houseType, lot_size_min: this.planBase.size});
      }
      planService.getProperties(options).then(
        (response) => {
          let results = response.data.data.home_search.results;
          results.forEach(
            (element) => {
              if (element.list_price > this.priceCeiling) {
                this.priceCeiling = element.list_price;
              }
              if (element.list_price < this.priceFloor || this.priceFloor === -1) {
                this.priceFloor = element.list_price;
              } 
              console.log(element.list_price);
          });
        }
      );
    },
  },
};
</script>

<style scoped>
</style>