import axios from 'axios';

export default{
    create(planBase) {
        return axios.post('/newPlan', planBase);
      },
    
}

const options = {
  method: 'GET',
  url: 'https://us-real-estate.p.rapidapi.com/for-sale',
  params: {
    offset: '0',
    limit: '10',
    state_code: 'OH',
    city: 'Cleveland',
    sort: 'newest',
    property_type: 'land'
  },
  headers: {
    'x-rapidapi-host': 'us-real-estate.p.rapidapi.com',
    'x-rapidapi-key': 'babb77fc36msh84d572d81feb391p146b30jsn26eca0abd8f0'
  }
};

axios.request(options).then(function (response) {
	console.log(response.data);
}).catch(function (error) {
	console.error(error);
});