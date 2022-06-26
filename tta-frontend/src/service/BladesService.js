   
import axios from "axios";

const API_URL = "http://localhost:8081/api/blades"

class BladesService {

    getBlades() {
        return axios({
            method: 'GET',
            url: `${API_URL}`
        });
    }

}

export default new BladesService();