<template>
  <div class="pageAlignment">
    <div class="background">
      <h1>Cost Breakdown</h1>  
      <div class="materialTable">
        <table>
          <tr>
            <th id="blank"></th>
            <th class="label">SqFt</th>
            <th class="label">Total</th>
          </tr>
          <tr class="row">
            <td class="label">Lumber</td>
            <td>{{ costs.lumber[0] }} - {{ costs.lumber[1] }}</td>
            <td>{{ costs.lumber[2] }} - {{ costs.lumber[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Concrete</td>
            <td>{{ costs.concrete[0] }} - {{ costs.concrete[1] }}</td>
            <td>{{ costs.concrete[2] }} - {{ costs.concrete[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Drywall</td>
            <td>{{ costs.drywall[0] }} - {{ costs.drywall[1] }}</td>
            <td>{{ costs.drywall[2] }} - {{ costs.drywall[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Flooring</td>
            <td>{{ costs.flooring[0] }} - {{ costs.flooring[1] }}</td>
            <td>{{ costs.flooring[2] }} - {{ costs.flooring[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Siding</td>
            <td>{{ costs.siding[0] }} - {{ costs.siding[1] }}</td>
            <td>{{ costs.siding[2] }} - {{ costs.siding[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Construction Manager</td>
            <td>
              {{ costs.constructionManager[0] }} -
              {{ costs.constructionManager[1] }}
            </td>
            <td>
              {{ costs.constructionManager[2] }} -
              {{ costs.constructionManager[3] }}
            </td>
          </tr>
          <tr class="row">
            <td class="label">Electrician</td>
            <td>{{ costs.electrician[0] }} - {{ costs.electrician[1] }}</td>
            <td>{{ costs.electrician[2] }} - {{ costs.electrician[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Roofer</td>
            <td>{{ costs.roofer[0] }} - {{ costs.roofer[1] }}</td>
            <td>{{ costs.roofer[2] }} - {{ costs.roofer[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Plumber</td>
            <td>{{ costs.plumber[0] }} - {{ costs.plumber[1] }}</td>
            <td>{{ costs.plumber[2] }} - {{ costs.plumber[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Concrete Contractor</td>
            <td>
              {{ costs.concreteContractor[0] }} -
              {{ costs.concreteContractor[1] }}
            </td>
            <td>
              {{ costs.concreteContractor[2] }} -
              {{ costs.concreteContractor[3] }}
            </td>
          </tr>
          <tr class="row">
            <td class="label">Framer</td>
            <td>{{ costs.framer[0] }} - {{ costs.framer[1] }}</td>
            <td>{{ costs.framer[2] }} - {{ costs.framer[3] }}</td>
          </tr>
          <tr class="row">
            <td class="label">Other</td>
            <td>{{ costs.other[0] }} - {{ costs.other[1] }}</td>
            <td>{{ costs.other[2] }} - {{ costs.other[3] }}</td>
          </tr>
          <!-- <tr>
                        <td>Total</td>
                        <td>{{costs.total[0]}} - {{costs.total[1]}}</td>
                        <td>{{costs.total[2]}} - {{costs.total[3]}}</td>
                    </tr> -->
                </table>
                <h3>Total Cost: {{costs.total[0]}} - {{costs.total[1]}}</h3>
            </div>
            <div class="buttons">
                <button v-on:click="goToRoomDesign">Previous</button>
                <button v-on:click="addPlan">Save</button>
            </div>
        </div>
    </div>
</template>

<script>
import PlanService from "../services/PlanService.js";

export default {
  data() {
    return {
      // import the cost data from the store and use inside table
      city: "",
      size: 0,
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
        total: [],
      },
    };
    },
    methods: {
        goToRoomDesign() {
          this.$router.push("/room-design");
        },
        addPlan() {
            PlanService.create(this.$store.state.floorPlan).then(
                () => {
                    if (this.$store.state.floorPlan.floor.one.bedrooms.length > 0) {
                        this.$store.state.floorPlan.floor.one.bedrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    if (this.$store.state.floorPlan.floor.one.bathrooms.length > 0) {
                        this.$store.state.floorPlan.floor.one.bathrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    if (this.$store.state.floorPlan.floor.two.bedrooms.length > 0) {
                        this.$store.state.floorPlan.floor.two.bedrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    if (this.$store.state.floorPlan.floor.two.bathrooms.length > 0) {
                        this.$store.state.floorPlan.floor.two.bathrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    if (this.$store.state.floorPlan.floor.three.bedrooms.length > 0) {
                        this.$store.state.floorPlan.floor.three.bedrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    if (this.$store.state.floorPlan.floor.three.bathrooms.length > 0) {
                        this.$store.state.floorPlan.floor.three.bathrooms.forEach(
                            (room) => { 
                                PlanService.createRooms(room)
                            }
                        )
                    }
                    PlanService.createDesign(this.$store.state.floorPlan.design);
                }
            )
                    this.$router.push({name: "plans"});
        },
        addRooms() {
        }
    },
    created() {
      this.city = this.$store.state.floorPlan.city;
      this.size = this.$store.state.floorPlan.squareFootage;

      if (this.city === "Cleveland") {
        this.multiplier = this.$store.state.multiplier.cleveland;
      } else if (this.city === "Cincinnati") {
        this.multiplier = this.$store.state.multiplier.cincinnati;
      } else if (this.city === "Columbus") {
        this.multiplier = this.$store.state.multiplier.columbus;
      } else if (this.city === "Toledo") {
        this.multiplier = this.$store.state.multiplier.toledo;
      }

      this.city = this.$store.state.floorPlan.city;
      this.size = this.$store.state.floorPlan.squareFootage;

      if (this.city === "cleveland") {
        this.multiplier = this.$store.state.multiplier.cleveland;
      } else if (this.city === "cincinnati") {
        this.multiplier = this.$store.state.multiplier.cincinnati;
      } else if (this.city === "columbus") {
        this.multiplier = this.$store.state.multiplier.columbus;
      } else if (this.city === "toledo") {
        this.multiplier = this.$store.state.multiplier.toledo;
      }

      let formatter = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
        maximumFractionDigits: 2,
        minimumFractionDigits: 2,
      });

      // I would just like to apologize to all for this terrible terrible block of code. MVP. sincerely, -Tyler
      this.costs.lumber.push(
        formatter.format(this.multiplier * this.$store.state.costLow.lumber)
      );
      this.costs.lumber.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.lumber)
      );
      this.costs.lumber.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.lumber
        )
      );
      this.costs.lumber.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.lumber
        )
      );
      this.costs.concrete.push(
        formatter.format(this.multiplier * this.$store.state.costLow.concrete)
      );
      this.costs.concrete.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.concrete)
      );
      this.costs.concrete.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.concrete
        )
      );
      this.costs.concrete.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.concrete
        )
      );
      this.costs.drywall.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.drywall)
      );
      this.costs.drywall.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.drywall)
      );
      this.costs.drywall.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.drywall
        )
      );
      this.costs.drywall.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.drywall
        )
      );
      this.costs.flooring.push(
        formatter.format(this.multiplier * this.$store.state.costLow.flooring)
      );
      this.costs.flooring.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.flooring)
      );
      this.costs.flooring.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.flooring
        )
      );
      this.costs.flooring.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.flooring
        )
      );
      this.costs.siding.push(
        formatter.format(this.multiplier * this.$store.state.costLow.siding)
      );
      this.costs.siding.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.siding)
      );
      this.costs.siding.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.siding
        )
      );
      this.costs.siding.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.siding
        )
      );
      this.costs.constructionManager.push(
        formatter.format(
          this.multiplier * this.$store.state.costLow.constructionManager
        )
      );
      this.costs.constructionManager.push(
        formatter.format(
          this.multiplier * this.$store.state.costHigh.constructionManager
        )
      );
      this.costs.constructionManager.push(
        formatter.format(
          this.size *
            this.multiplier *
            this.$store.state.costLow.constructionManager
        )
      );
      this.costs.constructionManager.push(
        formatter.format(
          this.size *
            this.multiplier *
            this.$store.state.costHigh.constructionManager
        )
      );
      this.costs.electrician.push(
        formatter.format(
          this.multiplier * this.$store.state.costHigh.electrician
        )
      );
      this.costs.electrician.push(
        formatter.format(
          this.multiplier * this.$store.state.costHigh.electrician
        )
      );
      this.costs.electrician.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.electrician
        )
      );
      this.costs.electrician.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.electrician
        )
      );
      this.costs.roofer.push(
        formatter.format(this.multiplier * this.$store.state.costLow.roofer)
      );
      this.costs.roofer.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.roofer)
      );
      this.costs.roofer.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.roofer
        )
      );
      this.costs.roofer.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.roofer
        )
      );
      this.costs.plumber.push(
        formatter.format(this.multiplier * this.$store.state.costLow.plumber)
      );
      this.costs.plumber.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.plumber)
      );
      this.costs.plumber.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.plumber
        )
      );
      this.costs.plumber.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.plumber
        )
      );
      this.costs.concreteContractor.push(
        formatter.format(
          this.multiplier * this.$store.state.costLow.concreteContractor
        )
      );
      this.costs.concreteContractor.push(
        formatter.format(
          this.multiplier * this.$store.state.costHigh.concreteContractor
        )
      );
      this.costs.concreteContractor.push(
        formatter.format(
          this.size *
            this.multiplier *
            this.$store.state.costLow.concreteContractor
        )
      );
      this.costs.concreteContractor.push(
        formatter.format(
          this.size *
            this.multiplier *
            this.$store.state.costHigh.concreteContractor
        )
      );
      this.costs.framer.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.framer)
      );
      this.costs.framer.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.framer)
      );
      this.costs.framer.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.framer
        )
      );
      this.costs.framer.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.framer
        )
      );
      this.costs.other.push(
        formatter.format(this.multiplier * this.$store.state.costLow.other)
      );
      this.costs.other.push(
        formatter.format(this.multiplier * this.$store.state.costHigh.other)
      );
      this.costs.other.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.other
        )
      );
      this.costs.other.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.other
        )
      );

      // this.costs.total.push(formatter.format(this.multiplier * this.$store.state.costLow.total));
      // this.costs.total.push(formatter.format(this.multiplier * this.$store.state.costHigh.total));
      this.costs.total.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costLow.total
        )
      );
      this.costs.total.push(
        formatter.format(
          this.size * this.multiplier * this.$store.state.costHigh.total
        )
      );
      // Again, sorry for this mess. I will fix it eventually. Maybe.
    },
  };
</script>

<style scoped>
.pageAlignment {
  display: grid;
  height: 50vh;
  margin-top: 30px;
  grid-template-columns: 1fr;
  justify-items: center;
}

.background {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "";
  justify-items: center;
  align-items: center;
  width: 60vw;
  background-color: #ffe9b3;
  border-radius: 10px;
  padding: 10px;
  box-shadow: 5px 5px 5px #264653;
}

h1 {
    align-self: center;
    color: #e76f51;
}

table {
  border-spacing: 10px;
}

.row:hover {
  background-color: #e76f51;
}

.row:hover>td{
  color:#ffe9b3;
}

table,
th,
td {
  border: 2px solid #264653;
  border-collapse: collapse;
  color: #264653;
  font-size: 12pt;
}

.label {
    font-size: 14pt;
}

td:nth-child(2),
th:nth-child(2) {
    min-width:130px;
}

td:nth-child(3),
th:nth-child(3) {
    min-width:230px;
}

#blank{
  border-top: hidden;
  border-left: hidden;
}

.buttons {
    align-self: center;
    display: flex; 
    justify-content: space-between;
    min-width: 240px;
}

button {
    background-color: #e76f51;
    color: white;
    border-radius: 15px;
    font-size: 16pt;
    border: none;
    min-width: 100px;
    height: 35px;
}
</style>