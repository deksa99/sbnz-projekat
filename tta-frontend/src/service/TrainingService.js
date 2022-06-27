   
import axios from "axios";

const API_URL = "http://192.168.0.102:8081/api/trainings"

class TrainingService {

    getTraining(data) {
        return axios({
            method: 'POST',
            url: `${API_URL}/request`,
            data: data 
        });
    }

    doTraining(id) {
        return axios({
            method: 'POST',
            url: `${API_URL}/do-training/` + id,
        });
    }

}

export default new TrainingService();