   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/training-level"

class TrainingLevelService {

    getTrainingLevels() {
        return axios({
            method: 'GET',
            url: `${API_URL}` 
        });
    }

    createTrainingLevel(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}`,
            data: data
        });
    }

}

export default new TrainingLevelService();