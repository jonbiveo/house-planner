import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    floorPlan: {
      userId:"",
      planName: "",
      houseType: "",
      city: "",
      state: "",
      squareFootage: "",
      floors: "",
      livingRoom: "",
      kitchen: "",
      basement: "",
      diningRoom: "",
      entertainmentRoom: "",
      spareRoom: "",
      floor: {
        one: {
          bedrooms: [],
          bathrooms: []
        },
        two: {
          bedrooms: [],
          bathrooms: []
        },
        three: {
          bedrooms: [],
          bathrooms: []
        }
      },
      design: {
        floorOneLayout: "",
        doors: "",
        staircase: "",
        bathroomCabinets:"",
        bathroomTub:"",
        kitchenCabinets: "",
        kitchenIsland: "",
        kitchenFloor: "",
        livingRoomFloor: "",
        bedroomFloor: "",
        bathroomFloor: "",
        entertainmentRoomFloor: "",
        spareRoomFloor: "",
        staircaseFloor: ""
      },
      priceRangeUpper: "",
      priceRangeLower: ""
    },
    costLow: {
      lumber: 16.2,
      concrete: 1.98,
      drywall: 1.8,
      flooring: 2.7,
      siding: 7.65,
      constructionManager: 8.46,
      electrician: 2.7,
      roofer: 3.3,
      plumber: 2.03,
      concreteContractor: 3.05,
      framer: 13.5,
      other: 27,
      total: 89.78
    },
    costHigh: {
      lumber: 19.8,
      concrete: 2.42,
      drywall: 2.2,
      flooring: 3.3,
      siding: 9.35,
      constructionManager: 10.34,
      electrician: 3.3,
      roofer: 3.3,
      plumber: 2.48,
      concreteContractor: 3.75,
      framer: 16.5,
      other: 33,
      total: 109.74
    },
    specialFeaturesLow: {
      pool: 50000,
      heatedFloor: 12,
      basement: 18000,
      outdoorDeck: 6900
    },
    specialFeaturesHigh: {
      pool: 53000,
      heatedFloor: 14,
      basement: 22000,
      outdoorDeck: 8100
    },
    multiplier: {
      cleveland: 0.72,
      cincinnati: 1.66,
      columbus: 1.98,
      toledo: 0.84
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    PLAN_DETAILS(state, newPlan) {
      state.floorPlan.userId = newPlan.userId;
      state.floorPlan.planName = newPlan.planName;
      state.floorPlan.houseType = newPlan.houseType;
      state.floorPlan.city = newPlan.city;
      state.floorPlan.state = newPlan.state;
      state.floorPlan.squareFootage = newPlan.size;
      state.floorPlan.priceRangeUpper = newPlan.costHigh;
      state.floorPlan.priceRangeLower = newPlan.costLow;
      state.squareFootageRemaining = newPlan.size;
    },
    SAVE_BUILDER(state, builderPlan){
      state.floorPlan.floors = builderPlan.floors;
      state.floorPlan.kitchen = builderPlan.kitchen;
      state.floorPlan.livingRoom = builderPlan.livingRoom;
      state.floorPlan.basement = builderPlan.basement;
      state.floorPlan.diningRoom = builderPlan.diningRoom;
      state.floorPlan.spareRoom = builderPlan.spareRoom;
      state.floorPlan.entertainmentRoom = builderPlan.entertainmentRoom;

      for (let [key, value] of Object.entries(builderPlan.floorOne.bedrooms)) {
        if (value !== "" && key !== "") {
          state.floorPlan.floor.one.bedrooms.push({roomSize: value, floor: 1, roomType: "bedroom"});
        }
      }
      for (let [key, value] of Object.entries(builderPlan.floorOne.bathrooms)) {
        if (value  !== "" && key !== "") {
          state.floorPlan.floor.one.bathrooms.push({roomSize: value, floor: 1, roomType: "bathroom"});
        }
      }
      for (let [key, value] of Object.entries(builderPlan.floorTwo.bedrooms)) {
        if (value !== "" && key !== "") {
          state.floorPlan.floor.two.bedrooms.push({roomSize: value, floor: 2, roomType: "bedroom"});
        }
      }
      for (let [key, value] of Object.entries(builderPlan.floorTwo.bathrooms)) {
        if (value !== "" && key !== "") {
          state.floorPlan.floor.two.bathrooms.push({roomSize: value, floor: 2, roomType: "bathroom"});
        }
      }
      for (let [key, value] of Object.entries(builderPlan.floorThree.bedrooms)) {
        if (value !== "" && key !== "") {
          state.floorPlan.floor.three.bedrooms.push({roomSize: value, floor: 3, roomType: "bedroom"});
        }
      }
      for (let [key, value] of Object.entries(builderPlan.floorThree.bathrooms)) {
        if (value !== "" && key !== "") {
          state.floorPlan.floor.three.bathrooms.push({roomSize: value, floor: 3, roomType: "bathroom"});
        }
      }
    },
    STORE_DESIGNER(state, designer) {
      state.floorPlan.design.floorOneLayout = designer.floorOneLayout;
      state.floorPlan.design.doors = designer.doors;
      state.floorPlan.design.staircase = designer.staircase;
      state.floorPlan.design.bathroomCabinets = designer.bathroomCabinets;
      state.floorPlan.design.bathroomTub = designer.bathroomTub;
      state.floorPlan.design.kitchenCabinets = designer.kitchenCabinets;
      state.floorPlan.design.kitchenIsland = designer.kitchenIsland;
      state.floorPlan.design.kitchenFloor = designer.kitchenFloor;
      state.floorPlan.design.livingRoomFloor = designer.livingRoomFloor;
      state.floorPlan.design.bedroomFloor = designer.bedroomFloor;
      state.floorPlan.design.bathroomFloor = designer.bathroomFloor;
      state.floorPlan.design.entertainmentRoomFloor = designer.entertainmentRoomFloor;
      state.floorPlan.design.spareRoomFloor = designer.spareRoomFloor;
      state.floorPlan.design.staircaseFloor = designer.staircaseFloor;

    }
  }
})
