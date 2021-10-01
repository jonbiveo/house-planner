<template>
  <div class="card-body">
    <div class="card-header"></div>
    <div class="card-detail-view">
      <div class="card-nav">
        <div class="nav">
          <router-link :to="{ name: 'plans' }">Dashboard</router-link> >
          <strong>{{ planName }}</strong>
        </div>
        <div class="buttons">
          <router-link :to="{ name: 'plans' }" class="card-btn"
            ><img src="../assets/button-edit.svg" class="btn-img" />
            Edit
          </router-link>
          <span v-on:click="copyPlan" class="card-btn"
            ><img src="../assets/button-copy.svg" class="btn-img" /> Copy</span
          >
          <span v-on:click="copyPlan" class="card-btn"
            ><img src="../assets/button-share.svg" class="btn-img" />
            Share</span
          >
          <span v-on:click="deletePlan" class="card-btn delete"
            ><img src="../assets/button-delete.svg" class="btn-img delete" />
            Delete</span
          >
        </div>
      </div>
      <div class="card-image">
        <img src="@/assets/Floorplan.jpg" alt="Floor Plan" class="card-image" />
      </div>
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
        <strong>Total Cost: </strong> {{ priceRangeLower }} -
        {{ priceRangeUpper }}
      </div>
    </div>
    <div></div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";
export default {
  data() {
    return {
      planDetails: [],
      planId: "",
      planName: "",
      houseType: "",
      state: "",
      city: "",
      size: "",
      multiplier: 0,
      priceRangeUpper: 0,
      priceRangeLower: 0,
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
        total: [],
      },
    };
  },
  created() {
    planService.getPlan(this.$route.params.id).then((response) => {
      let formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
        maximumFractionDigits: 2,
        minimumFractionDigits: 2,
      });

      console.log(response.data);
      this.planId = response.data.planId;
      this.planName = response.data.planName;
      this.houseType = response.data.houseType;
      this.state = response.data.state;
      this.city = response.data.city;
      this.size = response.data.squareFootage;
      this.priceRangeUpper = formatter.format(response.data.priceRangeUpper);
      this.priceRangeLower = formatter.format(response.data.priceRangeLower);
      // if (this.city === "Cleveland") {
      //   this.multiplier = this.$store.state.multiplier.cleveland;
      // } else if (this.city === "Cincinnati") {
      //   this.multiplier = this.$store.state.multiplier.cincinnati;
      // } else if (this.city === "Columbus") {
      //   this.multiplier = this.$store.state.multiplier.columbus;
      // } else if (this.city === "Toledo") {
      //   this.multiplier = this.$store.state.multiplier.toledo;
      // }

      // this.costs.total.push(
      //   formatter.format(
      //     this.size * this.multiplier * this.$store.state.costLow.total
      //   )
      // );
      // this.costs.total.push(
      //   formatter.format(
      //     this.size * this.multiplier * this.$store.state.costHigh.total
      //   )
      // );
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
    deletePlan() {
      planService.deletePlan(this.planId).then((response) => {
        if (response.status === 200) {
          this.$router.push("/plans");
        }
      }).catch((error)=>{
        if(error.response){
          alert("Error deleting plan.")
        }
      });
    },
  },
};
</script>

<style scoped>
.card-body {
  display: grid;
  min-height: 100vh;
  grid-template-rows: 60px 1fr;
  height: auto;
  background-color: #ffe9b3;
}

.card-header {
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
  grid-template-rows: 40px 500px 200px;
  background-color: #e9c46a;
  justify-self: center;
  gap: 40px;
  width: 60vw;
  min-width: 900px;
}

.card-nav {
  grid-area: card-nav;
  display: flex;
  grid-row-start: 1;
  grid-column-start: 1;
  margin: 5px 5px;
  padding: 15px 20px;
  max-height: 30px;
  justify-content: space-between;
}

.buttons {
  width: 30%;
  min-width: 300px;
  display: flex;
  justify-content: space-between;
  max-height: 30px;
}

.card-image {
  grid-area: image;
  grid-column: 1/2;
  grid-row: 2;
  display: flex;
  justify-content: center;
  max-height: 80%;
  margin: 5% 10% 15% 15%;
}

.card-details {
  grid-area: details;
  grid-column: 2;
  grid-row: 2;
  margin: 20px 0 0 0;
  font-size: 20px;
  max-height: 300px;
  padding: 10%;
  background: #ffe9b3;
  border-radius: 3px;
  box-shadow: 5px 5px 0 #e76f51, -5px -5px 0 #f4a261;
  min-width: 300px;
}

.card-breakdown {
  grid-area: breakdown;
  grid-column: 1/3;
  grid-row: 3;
  max-height: 100px;
  height: auto;
  font-size: 20px;
  padding: 20px 30px;
  background: #ffe9b3;
  border-radius: 3px;
  box-shadow: 5px 5px 0 #e76f51, -5px -5px 0 #f4a261;
  margin: 0 0 0 10%;
}

div.nav {
  height: 20px;
  padding: 5px 10px;
  border-radius: 3px;
  background-color: #2a9d8f;
}

.buttons a.router-link-active:visited {
  color: #264653;
}

.card-nav a:link {
  color: #264653;
}
.card-nav a:visited {
  color: #e9c46a;
}
.card-nav a:hover {
  color: #e76f51;
}

.btn-img {
  height: 20px;
  padding-right: 5px;
}

.buttons > span {
  cursor: pointer;
}

.nav > strong {
  cursor: default;
}

.btn-img.delete {
  height: 1.5em;
}

.card-btn {
  display: flex;
  align-items: center;
}

.card-btn.delete {
  color: #d3502f;
}
</style>
