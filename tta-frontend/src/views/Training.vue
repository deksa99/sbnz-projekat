<template>
    <div>
        <Navbar />
        <div class="container">
            <StartTraining />    
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import StartTraining from "@/components/StartTraining.vue";

export default {
    name: "Home",
    components: {
        Navbar,
        StartTraining,
    },
};
</script>

<style scoped>


</style>