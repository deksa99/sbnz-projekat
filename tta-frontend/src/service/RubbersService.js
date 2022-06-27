   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/rubbers"

class RubbersService {

    getRubbers() {
        return axios({
            method: 'GET',
            url: `${API_URL}`
        });
    }

}

export default new RubbersService();