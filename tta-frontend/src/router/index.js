import Vue from "vue";
import VueRouter from "vue-router";

import Home from "@/views/Home.vue";
import Registration from "@/views/Registration.vue";
import Login from "@/views/Login.vue";
import EventView from "@/views/EventView.vue";


Vue.use(VueRouter);

const routes = [
    {
        path: encodeURI('/'),
        name: 'Home',
        component: Home
    },
    {
        path: encodeURI('/registration'),
        name: 'Registration',
        component: Registration
    },
    {
        path: encodeURI('/login'),
        name: 'Login',
        component: Login
    }, 
    {        
        path: encodeURI('/training'),
        name: 'Training',
        component: EventView
    }
]

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
