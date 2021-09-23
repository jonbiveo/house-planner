<template>
  <div class="card">
      <div class="card-image">
          image
      </div>
      <div class="card-details">
      <strong>Plan Name</strong>: {{planName}} <br> <br>
      <strong>House Type</strong>: {{houseType}} <br> <br>
      <strong>State</strong>: {{state}} <br> <br>
      <strong>City</strong>: {{city}} <br> <br>
      <strong>Sq Ft</strong>: {{size}} <br> <br>
      </div>
  </div>
</template>

<script>
import planService from "@/services/PlanService";
export default {
    data(){
return {
    planDetails:[],
    planName:'',
    houseType:'',
    state:'',
    city:'',
    size:'',
}
    },
  created() {
    planService.getPlan(this.$route.params.id).then((response) => {
      this.planName=response.data.planName
      this.houseType=response.data.houseType
      this.state=response.data.state
      this.city=response.data.city
      this.size=response.data.size
    });
  },

}
</script>

<style>
.card {
    display: grid;
    grid-template-columns: 1fr 1fr;
  background-color: lightskyblue;
  max-width: 700px;
  min-height: 400px;
}

.card-image{
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: darkgray;
    height: 200px;
    width: 200px;
    margin: 20px 0 0 20px;
}

.card-details{
    margin: 20px 0 0 0;
    grid-column-start: 2;
}
</style>