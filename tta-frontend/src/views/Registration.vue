<template>
    <div>
        <Navbar></Navbar>
        <RegistrationForm></RegistrationForm>
    </div>
</template>


<script>
import Navbar from '@/components/Navbar.vue';
import RegistrationForm from '@/components/RegistrationForm.vue';

export default {
    name: "Registration",
    components: {
        Navbar,
        RegistrationForm
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

