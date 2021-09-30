<template>
  <div class="body-contact">
    <h2><span>Contact Us</span></h2>
    <div class="creators">
      <div class="creator" v-for="creator in creators" v-bind:key="creator.id">
        <span>{{ creator.name }}</span
        ><br />
        <div class="con-links">
          <a id="linkedin" :href="creator.linked" target="_blank"
            ><img class="con-img" src="../assets/linkedin-brands.svg"
          /></a>
          <a id="github" :href="creator.git" target="_blank"
            ><img class="con-img" src="../assets/github-brands.svg"
          /></a>
          <a id="email" :href="'mailto:' + creator.email" target="_blank"
            ><img class="con-img" src="../assets/envelope-solid.svg"
          /></a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      creators: [
        {
          name: "Logan Edmonds",
          linked: "https://www.linkedin.com/in/logantedmonds/",
          git: "https://github.com/jonbiveo",
          email: "LoganTEdmonds@gmail.com",
        },
        {
          name: "Molly Akers",
          linked: "www.linkedin.com/in/mollyakers",
          git: "https://github.com/akersm",
          email: "mollyakers@gmail.com",
        },
        {
          name: "Tyler Vicari",
          linked: "https://www.linkedin.com/in/tyler-vicari/",
          git: "https://github.com/tjordanv",
          email: "tylervicari@gmail.com",
        },
        {
          name: "Vellencia Knightly",
          linked: "https://www.linkedin.com/in/vknightly/",
          git: "https://github.com/VenBenvolio",
          email: "vellencia.knightly@gmail.com",
        },
      ],
    };
  },
  computed: {
  },
  methods: {
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
h2 {
  display: flex;
  justify-content: center;
  padding: 20px 0 10px 0;
  color: #264653;
  width: 98vw;
}

h2 > span {
  width: 25%;
  text-align: center;
  border-bottom: 3px solid #f4a261;
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
  border-left: 2px solid #f4a261;
}

.creator:nth-child(1) {
  border-left: 0px;
}

.con-img {
  height: 2.2em;
}

.con-links {
  display: flex;
  width: 200px;
  justify-content: space-evenly;
}
</style>