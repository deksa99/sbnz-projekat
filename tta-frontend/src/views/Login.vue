<template>
    <div>
        <Navbar></Navbar>
        <LoginForm></LoginForm>
    </div>
</template>


<script>
import Navbar from '@/components/Navbar.vue';
import LoginForm from '@/components/LoginForm.vue';

export default {
    name: "Login",
    components: {
        Navbar,
        LoginForm
    },
}
</script>

<style scoped>
.btn {
    margin: auto;
    display: block;
}
a {
    color: blue;
    text-decoration: underline;
}

