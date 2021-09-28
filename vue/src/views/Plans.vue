<template>
  <div>
      <div class = "plans">
        <plan-list/>
      </div>
  </div>
</template>

<script>
import PlanList from '../components/PlanList.vue';
export default {
  components: { PlanList },
  name: "plans",
};
</script>