<template>
  <div class="landing">
    <h1>Welcome</h1>
      <div class = "plans">
        <plan-list/>
      </div>
  </div>
</template>

<script>
import PlanList from '../components/PlanList.vue';
export default {
  components: { PlanList },
  name: "landing",
};
</script>
