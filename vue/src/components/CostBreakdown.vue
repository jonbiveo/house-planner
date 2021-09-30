<template>
    <div class="pageAlignment">
        <div class="background">
            <div class="materialTable">
                <table>
                    <tr>
                        <th></th>
                        <th>SqFt</th>
                        <th>Total</th>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{costs.lumber[0]}} - {{costs.lumber[1]}}</td>
                        <td>{{costs.lumber[2]}} - {{costs.lumber[3]}}</td>
                    </tr>
                    <tr>
                        <td>Concrete</td>
                        <td>{{costs.concrete[0]}} - {{costs.concrete[1]}}</td>
                        <td>{{costs.concrete[2]}} - {{costs.concrete[3]}}</td>
                    </tr>
                    <tr>
                        <td>Drywall</td>
                        <td>{{costs.drywall[0]}} - {{costs.drywall[1]}}</td>
                        <td>{{costs.drywall[2]}} - {{costs.drywall[3]}}</td>
                    </tr>
                    <tr>
                        <td>Flooring</td>
                        <td>{{costs.flooring[0]}} - {{costs.flooring[1]}}</td>
                        <td>{{costs.flooring[2]}} - {{costs.flooring[3]}}</td>
                    </tr>
                    <tr>
                        <td>Siding</td>
                        <td>{{costs.siding[0]}} - {{costs.siding[1]}}</td>
                        <td>{{costs.siding[2]}} - {{costs.siding[3]}}</td>
                    </tr>
                    <tr>
                        <td>Construction Manager</td>
                        <td>{{costs.constructionManager[0]}} - {{costs.constructionManager[1]}}</td>
                        <td>{{costs.constructionManager[2]}} - {{costs.constructionManager[3]}}</td>
                    </tr>
                    <tr>
                        <td>Electrician</td>
                        <td>{{costs.electrician[0]}} - {{costs.electrician[1]}}</td>
                        <td>{{costs.electrician[2]}} - {{costs.electrician[3]}}</td>
                    </tr>
                    <tr>
                        <td>Roofer</td>
                        <td>{{costs.roofer[0]}} - {{costs.roofer[1]}}</td>
                        <td>{{costs.roofer[2]}} - {{costs.roofer[3]}}</td>
                    </tr>
                    <tr>
                        <td>Plumber</td>
                        <td>{{costs.plumber[0]}} - {{costs.plumber[1]}}</td>
                        <td>{{costs.plumber[2]}} - {{costs.plumber[3]}}</td>
                    </tr>
                    <tr>
                        <td>Concrete Contractor</td>
                        <td>{{costs.concreteContractor[0]}} - {{costs.concreteContractor[1]}}</td>
                        <td>{{costs.concreteContractor[2]}} - {{costs.concreteContractor[3]}}</td>
                    </tr>
                    <tr>
                        <td>Framer</td>
                        <td>{{costs.framer[0]}} - {{costs.framer[1]}}</td>
                        <td>{{costs.framer[2]}} - {{costs.framer[3]}}</td>
                    </tr>
                    <tr>
                        <td>Other</td>
                        <td>{{costs.other[0]}} - {{costs.other[1]}}</td>
                        <td>{{costs.other[2]}} - {{costs.other[3]}}</td>
                    </tr>
                    <!-- <tr>
                        <td>Total</td>
                        <td>{{costs.total[0]}} - {{costs.total[1]}}</td>
                        <td>{{costs.total[2]}} - {{costs.total[3]}}</td>
                    </tr> -->
                </table>
                <h3>Total Cost: {{costs.total[0]}} - {{costs.total[1]}}</h3>
                <button v-on:click="addPlan">press me</button>
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
                total: []
            }
        }
    },
    methods: {
        addPlan() {
            PlanService.create(this.$store.state.floorPlan).then(
                () => {
                    window.alert("plan Added");
            if (this.$store.state.floorPlan.floor.one.bedrooms.length > 0) {
                this.$store.state.floorPlan.floor.one.bedrooms.forEach(
                    (room) => { 
                        PlanService.createRooms(room).then(
                            () => {
                                window.alert("room created");
                            }
                        )
                    }
                )
            }
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

        let formatter = new Intl.NumberFormat("en-US", {
            style: "currency",
                currency: "USD",
                maximumFractionDigits: 2,
                minimumFractionDigits: 2
            });

        // I would just like to apologize to all for this terrible terrible block of code. MVP. sincerely, -Tyler    
        this.costs.lumber.push(formatter.format(this.multiplier * this.$store.state.costLow.lumber));
        this.costs.lumber.push(formatter.format(this.multiplier * this.$store.state.costHigh.lumber));
        this.costs.lumber.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.lumber));
        this.costs.lumber.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.lumber));
        this.costs.concrete.push(formatter.format(this.multiplier * this.$store.state.costLow.concrete));
        this.costs.concrete.push(formatter.format(this.multiplier * this.$store.state.costHigh.concrete)); 
        this.costs.concrete.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.concrete));
        this.costs.concrete.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.concrete));     
        this.costs.drywall.push(formatter.format(this.multiplier * this.$store.state.costHigh.drywall));       
        this.costs.drywall.push(formatter.format(this.multiplier * this.$store.state.costHigh.drywall));  
        this.costs.drywall.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.drywall));       
        this.costs.drywall.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.drywall));         
        this.costs.flooring.push(formatter.format(this.multiplier * this.$store.state.costLow.flooring));
        this.costs.flooring.push(formatter.format(this.multiplier * this.$store.state.costHigh.flooring));
        this.costs.flooring.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.flooring));
        this.costs.flooring.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.flooring));
        this.costs.siding.push(formatter.format(this.multiplier * this.$store.state.costLow.siding));
        this.costs.siding.push(formatter.format(this.multiplier * this.$store.state.costHigh.siding));
        this.costs.siding.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.siding));
        this.costs.siding.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.siding));
        this.costs.constructionManager.push(formatter.format(this.multiplier * this.$store.state.costLow.constructionManager));
        this.costs.constructionManager.push(formatter.format(this.multiplier * this.$store.state.costHigh.constructionManager)); 
        this.costs.constructionManager.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.constructionManager));
        this.costs.constructionManager.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.constructionManager));     
        this.costs.electrician.push(formatter.format(this.multiplier * this.$store.state.costHigh.electrician));       
        this.costs.electrician.push(formatter.format(this.multiplier * this.$store.state.costHigh.electrician));  
        this.costs.electrician.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.electrician));       
        this.costs.electrician.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.electrician));         
        this.costs.roofer.push(formatter.format(this.multiplier * this.$store.state.costLow.roofer));
        this.costs.roofer.push(formatter.format(this.multiplier * this.$store.state.costHigh.roofer));
        this.costs.roofer.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.roofer));
        this.costs.roofer.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.roofer));
        this.costs.plumber.push(formatter.format(this.multiplier * this.$store.state.costLow.plumber));
        this.costs.plumber.push(formatter.format(this.multiplier * this.$store.state.costHigh.plumber));
        this.costs.plumber.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.plumber));
        this.costs.plumber.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.plumber));
        this.costs.concreteContractor.push(formatter.format(this.multiplier * this.$store.state.costLow.concreteContractor));
        this.costs.concreteContractor.push(formatter.format(this.multiplier * this.$store.state.costHigh.concreteContractor)); 
        this.costs.concreteContractor.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.concreteContractor));
        this.costs.concreteContractor.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.concreteContractor));     
        this.costs.framer.push(formatter.format(this.multiplier * this.$store.state.costHigh.framer));       
        this.costs.framer.push(formatter.format(this.multiplier * this.$store.state.costHigh.framer));  
        this.costs.framer.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.framer));       
        this.costs.framer.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.framer));         
        this.costs.other.push(formatter.format(this.multiplier * this.$store.state.costLow.other));
        this.costs.other.push(formatter.format(this.multiplier * this.$store.state.costHigh.other));
        this.costs.other.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.other));
        this.costs.other.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.other));
        
        // this.costs.total.push(formatter.format(this.multiplier * this.$store.state.costLow.total));
        // this.costs.total.push(formatter.format(this.multiplier * this.$store.state.costHigh.total));
        this.costs.total.push(formatter.format(this.size * this.multiplier * this.$store.state.costLow.total));
        this.costs.total.push(formatter.format(this.size * this.multiplier * this.$store.state.costHigh.total));
        // Again, sorry for this mess. I will fix it eventually. Maybe.
    },


}
</script>

<style>
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
    grid-template-areas: 
    "";
    justify-items: center;
    align-items: center;
    width: 60vw;
    min-height: 500px;
    background-color: #ffe9b3;
    border-radius: 10px;
    padding: 10px;
    box-shadow: 5px 5px 5px #264653;
}

table {
    border-spacing: 10px;
    
}

table, th, td {
    border: 2px solid #264653;
    border-collapse: collapse;
    color: #264653;
    font-size: 14pt;
}

</style>