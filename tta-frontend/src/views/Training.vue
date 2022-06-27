<template>
    <div>
        <Navbar />

        <div v-if="this.training" class="container">
            <EventView :training="this.training"></EventView>
        </div>

        <div v-else class="container">
            <StartTraining @training-started="trainingStarted"></StartTraining>
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import StartTraining from "@/components/StartTraining.vue";
import EventView from "@/views/EventView.vue";

export default {
    name: "Home",
    components: {
        Navbar,
        StartTraining,
        EventView
    },

    data() {
        return {
            training: ""
        }
    },

    methods: {
        trainingStarted(training) {
            this.training = training
        }
    }
};
</script>

<style scoped>


</style>