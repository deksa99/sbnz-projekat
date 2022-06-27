   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/users"

class UserService {

    getRubbers() {
        return axios({
            method: 'GET',
            url: `${API_URL}`
        });
    }

    register(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}/register`,
            data: data,
        });
    }

    updateRacket(data) {
        return axios({
            method: 'PUT',
            url: `${API_URL}/update-racket`,
            data: data,
        });
    }

}

export default new UserService();