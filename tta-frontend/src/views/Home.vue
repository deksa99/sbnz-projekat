<template>
    <div>
        <Navbar />
        <div class="container">
            <ChooseRacketForm />    
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import ChooseRacketForm from "@/components/ChooseRacketForm.vue";

export default {
    name: "Home",
    components: {
        Navbar,
        ChooseRacketForm,
    },
};
</script>

<style scoped>

.container {
    width: 860px;
}

</style>