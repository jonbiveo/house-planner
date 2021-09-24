<template>
  <div class="card">
    <div class="card-nav">
      <div class="nav">
        <router-link :to="{ name: 'plans' }">Plans</router-link> >
        {{ planName }}
      </div>
      <div class="buttons">
        <router-link class="btn edit" :to="{ name: 'plans' }">
            Edit Plan
        </router-link>
        <label v-on:click="copyPlan">Copy Plan</label>
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
    </div>
    <div class="card-breakdown">Breakdown:</div>
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
    };
  },
  created() {
    planService.getPlan(this.$route.params.id).then((response) => {
      this.planName = response.data.planName;
      this.houseType = response.data.houseType;
      this.state = response.data.state;
      this.city = response.data.city;
      this.size = response.data.size;
    });
  },
  methods: {
    copyPlan() {
      let newName=this.planName + " (Copy)";

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
            copies:0,
          }),
          this.$router.push("/plans");
      });
    },
  },
};
</script>

<style>
.card {
  display: grid;
  grid-template-areas:
    "card-nav card nav"
    "image details"
    "breakdown breakdown";
  grid-template-columns: 1fr 1fr;
  background-color: lightskyblue;
  max-width: 700px;
  min-height: 400px;
}

.card-nav {
  grid-area: card-nav;
  display: flex;
  grid-row-start: 1;
  grid-column-start: 1;
  margin: 5px 5px;
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
  margin: 0 0 0 20px;
}

.card-details {
  grid-area: details;
  grid-column-start: 2;
  margin: 20px 0 0 0;
}

.card-breakdown {
  margin: 0 0 0 20px;
  grid-area: breakdown;
  grid-column: 1/3;
  grid-row: 3;
}
</style>