   
import axios from "axios";

const API_URL = "http://localhost:8081/api/rackets"

class RacketService {

    getRacketByTraining() {
        return axios({
            method: 'GET',
            url: `${API_URL}`
        });
    }

}

export default new RacketService();