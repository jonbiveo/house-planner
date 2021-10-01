import axios from 'axios';

export default{
    getPlans(){
        return axios.get(`/plans`)
    },
    getPlan(planId){
        return axios.get(`/plans/${planId}`)
    },
    create(planBase) {
        return axios.post('/newPlan', planBase);
      },
    createRooms(room) {
      return axios.post("/newRoom", room);
    },
    createDesign(design) {
      return axios.post("/newDesign", design);
    },
    setPropertyInfo(info) {
      return {
        method: 'GET',
        url: 'https://us-real-estate.p.rapidapi.com/v2/for-sale',
        params: info,
        headers: {
        'x-rapidapi-host': 'us-real-estate.p.rapidapi.com',
        'x-rapidapi-key': 'd5236fb9cbmsh60dcb773a1e88a9p1584f2jsna89aa9fc2c95'
        }
      };
    },  
    getProperties(options) {
      return axios.request(options);
      // .then(function (response) {
      //   console.log(response.data);
      // }).catch(function (error) {
      //   console.error(error);
      // });
    },

    deletePlan(id) {
      return axios.delete(`/removePlan/${id}`);
    }
   
      
}