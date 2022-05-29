<template>
    <div>
        <Navbar />
        <div class="container">
            <ChooseRacketForm />    
            <QuestionnaireForm />
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import ChooseRacketForm from "@/components/ChooseRacketForm.vue";
import QuestionnaireForm from "@/components/QuestionnaireForm.vue";

export default {
    name: "Home",
    components: {
        Navbar,
        ChooseRacketForm,
        QuestionnaireForm
    },
};
</script>

<style scoped>

.container {
    width: 860px;
}

</style>