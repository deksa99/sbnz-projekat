   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/rackets/recommendation"

class RacketService {

    getRacketByTraining(userId) {
        return axios({
            method: 'GET',
            url: `${API_URL}/history/` + userId
        });
    }

    getRacketRecommendation(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}`,
            data: data
        });
    }

}

export default new RacketService();