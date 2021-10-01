<template>
  <div class="plans-main">
    <div class="list-header">
      <h1>Welcome!</h1>
    </div>
    <div class="plans-body">
      <div class="list-nav"><span>Dashboard</span></div>
      <div class="plans-box">
        <router-link v-bind:to="{ name: 'details' }">
          <div class="new-plan">+<br />New Plan</div>
        </router-link>
        <div
          class="plan-icon"
          v-for="plan in plans"
          v-bind:key="plan.planId"
          v-on:click="viewPlanDetails(plan.planId)"
        >
          <div class="plan-image">
            <img clas="icon-img"
              :src="require('../assets/list_' + plan.houseType + '.svg')"
            />
          </div>
          <p class="list-plan-name">{{ plan.planName }}</p>
        </div>
      </div>
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
    planService.getPlans().then((response) => {
      this.plans.planName = response.data.planName;
      this.plans.houseType = response.data.houseType;
      this.plans = response.data;
      console.log(JSON.stringify(JSON.parse(localStorage.getItem("user"))));

      console.log(this.plans.houseType);
    });
  },
  computed: {
    // getImage(type) {
    //   let img=''
    //   for (let i = 0; i < this.icons.length; i++) {
    //     if (this.icons.type == type) {
    //       console.log(this.icons.type);
    //       console.log(type);
    //       console.log(this.icons.iconImg);
    //       img= this.icons.iconImg;
    //     }
    //   }
    //   return img
    //},
  },
  methods: {
    viewPlanDetails(plandId) {
      this.$router.push(`plans/${plandId}`);
    },
  },
};
</script>

<style scoped>
.plans-main {
  display: grid;
  min-height: 100vh;
  grid-template-rows: 60px 1fr 100px;
  height: auto;
  background-color: #ffe9b3;
}

.plans-body {
  justify-self: center;
  display: flex;
  flex-direction: column;
  width: 60vw;
}
.list-header {
  display: flex;
  align-items: center;
  padding: 0 17.5%;
  background-color: #e76f51;
  height: 60px;
}
.list-nav {
  background-color: #e9c46a;
  padding: 20px 10px;
  height: 40px;
  min-width: 720px;
  font-weight: bold;
  box-shadow: 0 5px 5px #437081;
}

.plans-box {
  display: flex;
  flex-wrap: wrap;
  padding: 10px 10px 10px 30px;
  gap: 0 40px;
  min-height: 250px;
  min-width: 700px;
  background-color: #e9c46a;
  box-shadow: 0 5px 5px #437081;
}

.plan-icon {
  display: flex;
  width: auto;
  flex-direction: column;
  align-items: center;
}

.list-plan-name {
  max-width: 80px;
  text-align: center;
  cursor: default;
  font-size: 14px;
  font-weight: bolder;
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
  background-color: #e76f51;
  border-radius: 3px;
}

.plan-image:hover {
  background-color: #f4a261;
  border: 1px solid #2a9d8f;
  width: 78px;
  height: 78px;
  box-shadow: 0 0 10px #264653;
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

.list-nav > span {
  padding: 5px 10px;
  border-radius: 3px;
  background-color: #2a9d8f;
}


</style>
