   
import axios from "axios";

const API_URL = "http://localhost:8081/api/users"

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

}

export default new UserService();