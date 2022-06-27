<template>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">
            <img alt="Logo" src="@/assets/logo.png"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <router-link :to="{ name: 'Home'}" class="nav-link">Почетна</router-link>
                </li>
                <li class="nav-item">
                    <router-link :to="{ name: 'Training'}" class="nav-link">Тренинг</router-link>
                </li>
                <li class="nav-item">
                    <router-link :to="{ name: 'Template'}" class="nav-link">Темплејти</router-link>
                </li>
            </ul>
            <form class="d-flex justify-content-end">
                <router-link v-if="$store.state.user.role === undefined" :to="{ name: 'Login'}" class="nav-link">Пријава</router-link>
                <router-link v-if="$store.state.user.role === undefined" :to="{ name: 'Registration'}" class="btn btn-outline-primary">Регистрација</router-link>
                <button v-if="$store.state.user.role !== undefined" :to="{ name: 'Registration'}" @click="logout" class="btn btn-outline-primary">Одјава</button>
            </form>
        </div>
    </div>
</nav>
</template>

<script>
export default {
    name: "Navbar",
    methods: {
        logout() {
            localStorage.removeItem("token");
            localStorage.removeItem("user");
            this.$router.push({ name: 'Home'});
            this.$router.go();
        },
    },
};
</script>

<style scoped>
nav {
    z-index: 1;
    padding: 10px;
    background-color: white;
}
.profile {
    color: rgba(0, 0, 0, 0.55);
}
nav a {
    font-size: 120%;
}
.nav-item {
    font-weight: bold;
}
.navbar-brand img {
    height: 60px;
    float: left;
    margin-right: 30px;
    margin-left: 30px;
}
</style>