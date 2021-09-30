<template>
  <div class="body-contact">
    <h2><span>Contact Us</span></h2>
    <div class="creators">
      <div class="creator" v-for="creator in creators" v-bind:key="creator.id">
        <span>{{ creator.name }}</span
        ><br />
         <img class="con-img" src="../assets/linkedin-brands.svg" />
      </div>
      <!-- <div class="creator">
        <span>Logan Edmonds</span><br><img class="con-img" src="../assets/linkedin-brands.svg" />
      </div>
      <div class="creator">
        <span>Molly Akers</span><br><img class="con-img" src="../assets/linkedin-brands.svg" />
      </div>
      <div class="creator">
        <span>Tyler Vicari</span><br><img class="con-img" src="../assets/linkedin-brands.svg" />
      </div>
      <div class="creator">
        <span>Vellencia Knightly</span
        ><br><img class="con-img" src="../assets/linkedin-brands.svg" />
      </div> -->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      creators: [
        { name: "Logan Edmonds", linked: "" },
        { name: "Molly Akers", linked: "" },
        { name: "Tyler Vicari", linked: "" },
        { name: "Vellencia Knightly", linked: "" },
      ],
    };
  },
};
</script>

<style scoped>
.body-contact {
  background-color: #e76f51;
  min-height: 170px;
  min-width: 750px;
  box-shadow: 0 -3px 5px darkgrey;
}
h2{display: flex;
  justify-content: center;
  padding: 20px 0 10px 0;
  color:  #264653;
  width: 98vw
}

h2>span{
  width: 25%;
  text-align: center;
  border-bottom: 3px solid #F4A261;
}

.creators {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  padding: 1% 7% 2%;
}

.creator {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 1.1em;
  min-width: 150px;
  border-left: 2px solid #F4A261;
}

.creator:nth-child(1){
  border-left: 0px;
}

.con-img {
  height: 2.2em;
}
</style>