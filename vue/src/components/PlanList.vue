<template>
  <div>
    <div class="plans">
      <div
        class="plan-icon"
        v-for="plan in plans"
        v-bind:key="plan.planId"
        v-on:click="viewPlanDetails(plan.planId)"
      >
        <div class="plan-image">plan icon</div>
        <p class="list-plan-name">{{ plan.planName }}</p>
      </div>
      <router-link v-bind:to="{ name: 'details' }">
        <div class="new-plan">+<br />New Plan</div>
      </router-link>
    </div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";

export default {
  data() {
    return {
      userId: JSON.stringify(JSON.parse(localStorage.getItem("user")).id),
      planName: "",
      plans: [],
    };
  },
  created() {
    planService.getPlans(this.$route.params.id).then((response) => {
      this.planName = response.data.planName;
      this.plans = response.data;
      console.log(JSON.stringify(JSON.parse(localStorage.getItem("user"))))
    });
  },
  methods: {
    viewPlanDetails(plandId) {
      this.$router.push(`plans/${plandId}`);
    },
  },
};
</script>

<style>
.plans {
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  gap: 0 40px;
  max-width: 700px;
  min-height: 400px;
  background-color: lightgray;
}

.plan-icon {
  display: flex;
  width: auto;
  flex-direction: column;
  align-items: center;
  margin: 0 0 70px 0;
}

.list-plan-name {
  max-width: 80px;
  text-align: center;
  cursor: default;
  font-size: 14px;
  font-weight: bold;
}

.plan-image,
.new-plan {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 80px;
  height: 80px;
}

.plan-image {
  background-color: gray;
  border-radius: 3px;
}

.plan-image:hover {
  background-color: darkgrey;
  border: 1px solid black;
  width: 78px;
  height: 78px;
  box-shadow: 0 0 10px gray;
  cursor: default;
}

.new-plan {
  background-color: white;
  text-align: center;
  border-radius: 3px;
}

.new-plan:hover {
  border: 1px solid skyblue;
  width: 78px;
  height: 78px;
  box-shadow: 0 0 10px lightskyblue;
}

a {
  text-decoration: none;
}
.new-plan {
  color: rgb(13, 175, 216);
}
</style>