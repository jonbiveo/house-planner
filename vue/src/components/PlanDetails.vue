<template>
  <div class = 'plan-details'>
    <div>
      <form v-on:submit.prevent="saveBase" class='form-plan'>
        Plan Name:
        <input type="text" class='plan-name' v-model="planBase.planName" />
        <label for="house-types" class='house-types'>Select House Type:</label>
        <select name="house-types" v-model="planBase.houseType" v-on:change="viewRange">
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

        <!-- <label for="state">Select State:</label>
        <select name="state" v-model="planBase.state">
          <option value="Ohio">Ohio</option>
        </select>
      
        <label for="city">Select City:</label>
        <select name="city" v-model="planBase.city">
          <option value="Cincinati">Cincinati</option>
        </select> -->
<label for="City" class='city'>Select City:</label>
        <select name="city" v-model="planBase.city" required v-on:change="viewRange">
          <option value="Cleveland">Cleveland</option>
          <option value="Cincinnati">Cincinnati</option>
          <option value="Columbus">Columbus</option>
          <option value="Toledo">Toledo</option>
        </select>
        <label for="State" class='state'>Select State:</label>
        <select name="state" v-model="planBase.state" required v-on:change="viewRange">
          <option value="Ohio">OH</option>
        </select>
        <label for="square-foot" class='size'>Select Minimum Square Footage:</label>
        <select v-if="planBase.houseType !== 'land'" name="square-foot" v-model="planBase.size" v-on:change="viewRange" required >
          <option value="1000">1000</option>
          <option value="1500">1500</option>
          <option value="2000">2000</option>
          <option value="2500">2500</option>
        </select>
        <select v-if="planBase.houseType === 'land'" name="square-foot" v-model="planBase.size" v-on:change="viewRange" required>
          <option value="2000">2000</option>
          <option value="4000">4000</option>
          <option value="5000">5000</option>
          <option value="7500">7500</option>
        </select>
      <div v-if="priceCeiling !== -1">
        <h3>${{priceFloor}} - ${{priceCeiling}}</h3>
      </div>
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
        userId:"",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        size: ""
      },
      priceFloor: -1,
      priceCeiling: -1
    };
  },
  computed: {
    optionsSelected() {
      return (this.planBase.houseType !== "" && this.planBase.city !== "" && this.planBase.state !== "");
    }
  },
  methods: {
    viewRange(){
      let options = {};
      this.priceFloor = -1;
      this.priceCeiling = -1;
      if (this.optionsSelected) {
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
      }
    },
    saveBase() {
      const newPlan = {
        userId: JSON.stringify(JSON.parse(localStorage.getItem('user')).id),
        planName:this.planBase.planName,
        houseType: this.planBase.houseType,
        city:this.planBase.city,
        state:this.planBase.state,
        size:this.planBase.size
      }
      console.log(newPlan)
      planService
      .create(newPlan)
      .then((response)=>{
        console.log(response.data),
        this.planBase = {
        planName: '',
        houseType: '',
        city:'',
        state: '',
        size:''},
        this.$router.push("/plan-builder")
      })
    },
  },
};
</script>

<style>
</style>