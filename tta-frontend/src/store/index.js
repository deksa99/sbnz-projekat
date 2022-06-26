import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        user: {
            id: undefined,
            firstName: undefined,
            lastName: undefined,
            email: undefined,
            role: undefined,
        }
    },
    mutations: {
        SET_AUTHORIZED_USER (state, user) {
            state.user.id = user.id;
            state.user.firstName = user.firstName;
            state.user.lastName = user.lastName;
            state.user.email = user.email;
            state.user.role = user.role;
        },
    },
    actions: {},
    modules: {},
});