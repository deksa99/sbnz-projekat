   
import axios from "axios";

const API_URL = "http://localhost:8081/api/rackets"

class RacketService {

    getRacketByTraining(userId) {
        return axios({
            method: 'GET',
            url: `${API_URL}/history/` + userId
        });
    }

}

export default new RacketService();