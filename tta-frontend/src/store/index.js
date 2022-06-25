import Vue from "vue";
import Vuex from "vuex";

import AuthenticationService from '@/service/AuthenticationService.js';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        user: {
            firstName: undefined,
            lastName: undefined,
            email: undefined,
            role: undefined,
        }
    },
    mutations: {
        SET_AUTHORIZED_USER (state, user) {
            state.user.firstName = user.firstName;
            state.user.lastName = user.lastName;
            state.user.email = user.email;
            state.user.role = user.role;
        },
    },
    actions: {
        loadAuthorizedUser( {commit} ) {
            if (!localStorage.getItem('token'))
                return;

            let token = localStorage.getItem('token');

            AuthenticationService.getAuthorizedUser(token)
                .then(response => { 
                    let user = JSON.parse(response.data);
                    commit('SET_AUTHORIZED_USER', user); 
                })
                .catch(error => { console.log(error); });
        }
    },
    modules: {},
});
