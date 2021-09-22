import axios from 'axios';

export default{
    getPlans(){
        return axios.get(`/plans`)
    },
    create(planBase) {
        return axios.post('/newPlan', planBase);
      },
      setPropertyInfo(info) {
        return {
          method: 'GET',
          url: 'https://us-real-estate.p.rapidapi.com/v2/for-sale',
          params: info,
          headers: {
          'x-rapidapi-host': 'us-real-estate.p.rapidapi.com',
          'x-rapidapi-key': 'babb77fc36msh84d572d81feb391p146b30jsn26eca0abd8f0'
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
      }
}