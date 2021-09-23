<template>
  <div class = 'plan-details'>
    <div class="background">
      <form v-on:submit.prevent="saveBase" class='form-plan'>
        <h3>Enter your desired home information below.</h3>
        <input type="text" class='plan-name' placeholder="Plan Name" v-model="planBase.planName" />
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
          <option value="land">Empty Lot</option>
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
        <button>Next</button>
      </form>
      <div class="costDisplay">
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
      planBase: {
        userId:"",
        planName: "",
        houseType: "",
        city: "",
        state: "",
        size: ""
      },
      priceFloor: -1,
      priceCeiling: -1,
      averagePrice: -1
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
        if (this.planBase.houseType !== "land") {
          options = planService.setPropertyInfo({offset: '0', limit: '150', sort: 'newest', state_code: this.planBase.state, 
          city: this.planBase.city, property_type: this.planBase.houseType, home_size_min: this.planBase.size});
        } else {
          options = planService.setPropertyInfo({offset: '0', limit: '150', sort: 'newest', state_code: this.planBase.state, 
          city: this.planBase.city, property_type: this.planBase.houseType, lot_size_min: this.planBase.size});
        }
        planService.getProperties(options).then(
          (response) => {
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

<style scoped>
.plan-details {
  display: grid;
  height: 75vh;
  margin-top: 50px;
  grid-template-columns: 1fr;
  grid-template-areas: 
  "form"
  "costDisplay";
  justify-items: center;
  align-items: center;
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
  background-color: #264653;
  border-radius: 10px;
  padding: 16px;
}

.form-plan {
margin-top: 20px;
grid-area: form;  
display: grid;
justify-content: center;
width: 55%;
padding: 15px;
}

 .form-plan input {
  min-width: 450px;
  font-size: 16pt;
}

.form-plan select, .form-plan label, .form-plan h3 {
  min-width: 300px;
  font-size: 16pt;
  color: #E76F51;
}

.form-plan button {
  margin: 15px auto;
  min-width: 150px;
  height: 35px;
  font-size: 16pt;
  border-radius: 15px;
  border: none;
  background-color: #E76F51;
}

.costDisplay {
  margin-left: 135px;
  justify-self: start;
  grid-area: costDisplay;
  height: 100px;
}

.costDisplay span h3{
  display: inline;
  margin-top: 0;
  margin-left: 25px;
  font-size: 16pt;
}

.costDisplay span {
  display: block;
  color: #E76F51;
  font-size: 16pt;
  margin-bottom: 15px;
}

.priceRange {
  padding-left: 12px;
}

</style>