<template>
  <div class="card-body">
    <div class="card-header">
      
    </div>
    <div class="card-detail-view">
      <div class="card-nav">
        <div class="nav">
          <router-link :to="{ name: 'plans' }">Dashboard</router-link> >
          {{ planName }}
        </div>
        <div class="buttons">
          <router-link class="btn edit" :to="{ name: 'plans' }">
            Edit Plan
          </router-link>
          <span v-on:click="copyPlan">Copy Plan</span>
          <span v-on:click="copyPlan">Share Plan</span>
        </div>
      </div>
      <div class="card-image">image</div>
      <div class="card-details">
        <strong>Plan Name</strong>: {{ planName }} <br />
        <br />
        <strong>House Type</strong>: {{ houseType }} <br />
        <br />
        <strong>State</strong>: {{ state }} <br />
        <br />
        <strong>City</strong>: {{ city }} <br />
        <br />
        <strong>Sq Ft</strong>: {{ size }} <br />
        <br />
        <strong>Total Cost: {{costs.total[0]}} - {{costs.total[1]}}</strong>
        <br>
        <br>
      </div>
    </div>
      <div>
      </div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";
export default {
  data() {
    return {
      planDetails: [],
      planName: "",
      houseType: "",
      state: "",
      city: "",
      size: "",
      multiplier: 0,
      costs: {
        lumber: [],
        concrete: [],
        drywall: [],
        flooring: [],
        siding: [],
        constructionManager: [],
        electrician: [],
        roofer: [],
        plumber: [],
        concreteContractor: [],
        framer: [],
        other: [],
        total: []
      }
    };
  },
  created() {
    planService.getPlan(this.$route.params.id).then((response) => {
      this.planName = response.data.planName;
      this.houseType = response.data.houseType;
      this.state = response.data.state;
      this.city = response.data.city;
      this.size = response.data.size;
      console.log(this.city)
      if (this.city === "Cleveland") {
            this.multiplier = this.$store.state.multiplier.cleveland;
        } else if (this.city === "Cincinnati") {
            this.multiplier = this.$store.state.multiplier.cincinnati;
        } else if (this.city === "Columbus") {
            this.multiplier = this.$store.state.multiplier.columbus;
        } else if (this.city === "Toledo") {
            this.multiplier = this.$store.state.multiplier.toledo;
        }

        let formatter = new Intl.NumberFormat("en-US", {
            style: "currency",
                currency: "USD",
                maximumFractionDigits: 2,
                minimumFractionDigits: 2
            });
        this.costs.total.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.total));
        this.costs.total.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.total));
    });
  },
  methods: {
    copyPlan() {
      let newName = this.planName + " (Copy)";

      const newPlan = {
        userId: JSON.stringify(JSON.parse(localStorage.getItem("user")).id),
        planName: newName,
        houseType: this.houseType,
        city: this.city,
        state: this.state,
        size: this.size,
      };
      console.log(newPlan);
      planService.create(newPlan).then((response) => {
        console.log(response.data),
          (this.planBase = {
            planName: "",
            houseType: "",
            city: "",
            state: "",
            size: "",
            copies: 0,
          }),
          this.$router.push("/plans");
      });
    },
  },
};
</script>

<style>

.card-body{
  display: grid;
  min-height: 100vh;
  height: auto;
  align-items: flex-start;
  justify-content: center;
  background-color: #ffe9b3;
}

.card-header{
  display: flex;
  align-items: center;
  padding: 0 17.5%;
  background-color: #e76f51;
  height: 60px;
  width: 100vw;
}
.card-detail-view {
  display: grid;
  grid-template-areas:
    "card-nav card nav"
    "image details"
    "breakdown breakdown";
  grid-template-columns: 1fr 1fr;
  background-color: lightskyblue;
  justify-self: center;
  gap: 40px ;
  min-width: 600px;
  width: 60vw;
}

.card-nav {
  grid-area: card-nav;
  display: flex;
  grid-row-start: 1;
  grid-column-start: 1;
  margin: 5px 5px;
  padding: 15px 20px;
  justify-content: space-between;
}

.buttons {
  width: 25%;
  display: flex;
  justify-content: space-between;
}

.card-image {
  grid-area: image;
  grid-column: 1/2;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: darkgray;
  height: 200px;
  width: 200px;
  margin: 5% 10% 0 25%;
}

.card-details {
  grid-area: details;
  grid-column-start: 2;
  margin: 20px 0 0 0;
  font-size: 20px;
}

.card-breakdown {
  margin: 0 0 0 35px;
  grid-area: breakdown;
  grid-column: 1/3;
  grid-row: 3;
  min-height: 100px;
  font-size: 20px;
  padding-left: 10%;
}
</style>
