<template>
  <div class = 'plan-details'>
    <div class="background">
      <form v-on:submit.prevent="saveBase" class='form-plan'>
        <h2>Enter your desired home information below.</h2><br>
        <label for="plan-name" class='plan-name'>Plan Name:</label>
        <input type="text" class='plan-name' v-model="planBase.planName" />
        <label for="State" class='state'>Select State:</label>
        <select name="state" v-model="planBase.state" required v-on:change="viewRange">
          <option value="Ohio">OH</option>
        </select>
        <label for="City" class='city'>Select City:</label>
        <select name="city" v-model="planBase.city" required v-on:change="viewRange">
          <option value="Cleveland">Cleveland</option>
          <option value="Cincinnati">Cincinnati</option>
          <option value="Columbus">Columbus</option>
          <option value="Toledo">Toledo</option>
        </select>
        <label for="house-types" class='house-types'>Select House Type:</label>
        <select name="house-types" v-model="planBase.houseType" v-on:change="viewRange">
          <option value="single_family">Single-Family</option>
          <option value="multi_family">Multi-Family</option>
          <!-- <option value="land">Empty Lot</option> -->
        </select>
        <label for="square-foot" class='size'>Select Square Footage:</label>
        <select v-if="planBase.houseType !== 'land'" name="square-foot" v-model="planBase.size" v-on:change="viewRange" required >
          <option value="1000">1000</option>
          <option value="1500">1500</option>
          <option value="2000">2000</option>
          <option value="2500">2500</option>
          <option value="3000">3000</option>
        </select>
        <!-- <select v-if="planBase.houseType === 'land'" name="square-foot" v-model="planBase.size" v-on:change="viewRange" required>
          <option value="2000">2000</option>
          <option value="4000">4000</option>
          <option value="5000">5000</option>
          <option value="7500">7500</option>
        </select> -->
        <button>Next</button>
      </form>
      <img
        class="loading"
        src="https://mir-s3-cdn-cf.behance.net/project_modules/disp/04de2e31234507.564a1d23645bf.gif"
        v-if="isLoading"
      />
      <div class="costDisplay" v-else v-show="optionsSelected">
        <span>Price Range For Current Listings:<h3 class="priceRange" v-if="priceCeiling !== -1">{{priceFloor}} - {{priceCeiling}}</h3></span>
        <span>Average Cost For Current Listings:<h3 v-if="priceFloor !== -1">{{averagePrice}}</h3></span>
      </div>
    </div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";
export default {
  data() {
    return {
      multiplier: 0,
      planBase: {
        userId:"",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        size: "",
        costHigh: "",
        costLow: ""
      },
      priceFloor: -1,
      priceCeiling: -1,
      averagePrice: -1,

      isLoading: false,
    };
  },
  computed: {
    optionsSelected() {
      return (this.planBase.houseType !== "" && this.planBase.city !== "" && this.planBase.state !== "" && this.planBase.size);
    }
  },
  methods: {
    viewRange(){
      let options = {};
      this.priceFloor = -1;
      this.priceCeiling = -1;
      let prices = [];
      
      if (this.optionsSelected) {
        this.isLoading = true;
        if (this.planBase.houseType !== "land") {
          options = planService.setPropertyInfo({offset: '0', limit: '150', sort: 'newest', state_code: this.planBase.state, 
          city: this.planBase.city, property_type: this.planBase.houseType, home_size_min: this.planBase.size});
        } else {
          options = planService.setPropertyInfo({offset: '0', limit: '150', sort: 'newest', state_code: this.planBase.state, 
          city: this.planBase.city, property_type: this.planBase.houseType, lot_size_min: this.planBase.size});
        }

        planService.getProperties(options).then(
          (response) => {
            this.isLoading = false;
            let results = response.data.data.home_search.results;
            results.forEach(
              (element) => {
                let currentPrice = element.list_price;
                prices.push(currentPrice);
                if (currentPrice > this.priceCeiling) {
                  this.priceCeiling = currentPrice;
                }
                if ((currentPrice < this.priceFloor || this.priceFloor === -1) && typeof currentPrice === "number" ) {
                  this.priceFloor = currentPrice;
                } 
            });
              this.averagePrice = prices.reduce(
                (sum, num) => {
                  return sum + num;
                }
              );
              let formatter = new Intl.NumberFormat("en-US", {
                style: "currency",
                  currency: "USD",
                  maximumFractionDigits: 0
              });
              this.priceCeiling = formatter.format(this.priceCeiling);
              this.priceFloor = formatter.format(this.priceFloor);
              this.averagePrice = formatter.format(this.averagePrice / prices.length);
          }
        );
      }
    },
    saveBase() {
      if (this.planBase.city === "Cleveland") {
          this.multiplier = this.$store.state.multiplier.cleveland;
      } else if (this.planBase.city === "Cincinnati") {
          this.multiplier = this.$store.state.multiplier.cincinnati;
      } else if (this.planBase.city === "Columbus") {
          this.multiplier = this.$store.state.multiplier.columbus;
      } else if (this.planBase.city === "Toledo") {
          this.multiplier = this.$store.state.multiplier.toledo;
      }

      const newPlan = {
        userId: JSON.stringify(JSON.parse(localStorage.getItem('user')).id),
        planName: this.planBase.planName,
        houseType: this.planBase.houseType,
        city: this.planBase.city,
        state: this.planBase.state,
        size: this.planBase.size,
        costHigh: (this.planBase.size * this.multiplier * this.$store.state.costHigh.total),
        costLow: (this.planBase.size * this.multiplier * this.$store.state.costLow.total)
      }

      this.$store.commit("PLAN_DETAILS", newPlan);
      this.$router.push("/plan-builder");
      // this.planBase = {
      //   planName: '',
      //   houseType: '',
      //   city:'',
      //   state: '',
      //   size:'',
      //   costHigh: "",
      //   costLow: ""
      //   }

      //this.$store.state.floorPlan.planName = this.planBase.planName;
      //console.log(newPlan)
      //planService
      //.create(newPlan)
      //.then((response)=>{
        //console.log(response.data),
        // this.planBase = {
        // planName: '',
        // houseType: '',
        // city:'',
        // state: '',
        // size:''},
        // this.$router.push("/plan-builder")
      // })
    },
  },
};
</script>

<style scoped>
.plan-details {
  display: grid;
  height: 50vh;
  margin-top: 30px;
  grid-template-columns: 1fr;
  justify-items: center;
}

.background {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: 
  "form"
  "costDisplay";
  justify-items: center;
  align-items: center;
  width: 60vw;
  min-height: 550px;
  background-color: #ffe9b3;
  border-radius: 10px;
  padding: 10px;
  box-shadow: 0px 0px 7px #E76F51;
}

.form-plan {
margin-top: 15px;
grid-area: form;  
display: grid;
justify-content: center;
width: 55%;
}

 .form-plan input {
  min-width: 450px;
  font-size: 14pt;
}

.form-plan select, .form-plan label, .form-plan h3 {
  min-width: 300px;
  font-size: 14pt;
  color: #264653;
}

.form-plan button {
  margin: 15px auto;
  min-width: 150px;
  height: 35px;
  font-size: 16pt;
  color: white;
  border-radius: 15px;
  border: none;
  background-color: #E76F51;
}

.costDisplay {
  margin-left: 135px;
  justify-self: start;
  grid-area: costDisplay;
}

.costDisplay span h3{
  display: inline;
  margin-top: 0;
  margin-left: 25px;
  font-size: 14pt;
}

.costDisplay span {
  display: block;
  color: #264653;
  font-size: 14pt;
  margin-bottom: 12px;
}

.priceRange {
  padding-left: 12px;
}

.loading {
  max-height: 80px;
}
h3{
  text-align: center;
}

</style>