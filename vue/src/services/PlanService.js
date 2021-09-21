import axios from 'axios';

export default{
    create(planBase) {
        return axios.post('/newPlan', planBase);
      },
    
}
