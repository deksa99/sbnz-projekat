   
import axios from "axios";

const API_URL = "http://localhost:8081/api/authentication"

class AuthenticationService {

    getAuthorizedUser() {
        return axios({
            method: 'GET',
            url: `${API_URL}/authority`
        });
    }

    register(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}/register`,
            data: data,
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