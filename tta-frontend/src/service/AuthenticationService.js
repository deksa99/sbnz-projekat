   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/auth"

class AuthenticationService {

    getAuthorizedUser() {
        return axios({
            method: 'GET',
            url: `${API_URL}/authority`
        });
    }

    login(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}/login`,
            data: data
        });
    }

}

export default new AuthenticationService();