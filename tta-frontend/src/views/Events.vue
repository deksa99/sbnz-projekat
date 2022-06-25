<template>
    <div>
        <Navbar />
        <div class="container">
            <EventsMsgs />
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import EventsMsgs from "@/components/EventsMsgs.vue";

export default {
    name: "Home",
    components: {
        Navbar,
        EventsMsgs
    },
};
</script>

<style scoped>

.container {
    margin-top: 1rem;
}

</style>