<template>
    <router-view/>
</template>

<script>
import axios from "axios"

export default {
    beforeCreate() {
        if (!localStorage.getItem('token'))
            return;
        
        let token = localStorage.getItem('token');
        axios.defaults.headers.common['Authorization'] = "Bearer " + token;
        console.log("Token: " +  axios.defaults.headers.common['Authorization']);
        axios.interceptors.response.use(function (response) {
            return response;
        }, function (error) {
            if (error.response.status === 401) {
                console.log("ZABARANJEN PRISTUP");
                this.$router.push({name: "Login"});
            }
            return Promise.reject(error);
        });
    }
}
</script>