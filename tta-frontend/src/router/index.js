import Vue from "vue";
import VueRouter from "vue-router";

import Home from "@/views/Home.vue";
import Registration from "@/views/Registration.vue";
import Login from "@/views/Login.vue";
import Training from "@/views/Training.vue";
import Template from "@/views/Template.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: encodeURI('/'),
        name: 'Home',
        component: Home,
        meta: {
            authorize: ['PLAYER']
        }
    },
    {
        path: encodeURI('/registration'),
        name: 'Registration',
        component: Registration,
    },
    {
        path: encodeURI('/login'),
        name: 'Login',
        component: Login,
    }, 
    {        
        path: encodeURI('/training'),
        name: 'Training',
        component: Training,
        meta: {
            authorize: ['PLAYER']
        }
    },
    {
        path: encodeURI('/template'),
        name: 'Template',
        component: Template,
    }
]

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

router.beforeEach((to, from, next) => {
    const { authorize } = to.meta;
    const currentUser = JSON.parse(localStorage.getItem('user'));

    if (authorize) {

        if (!currentUser) {
            // not logged in so redirect to login page with the return url
            return next({ name: 'Login' });
        }

        // check if route is restricted by role
        if (authorize.length && !authorize.includes(currentUser.role)) {
            // role not authorised so redirect to home page
            return next({ path: '/' });
        }
    }

    next();

});

export default router;
