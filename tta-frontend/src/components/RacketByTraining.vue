<template>
    <RacketInfo :racket="this.racket"></RacketInfo>
</template>

<script>
import { mapState } from "vuex";
import RacketService from "@/service/RacketService.js";
import RacketInfo from "@/components/RacketInfo.vue";

export default {
    name: "RacketByTraining",
    
    components: {
        RacketInfo
    },

    computed: {
        ...mapState([
            'user',
        ])
    },

    data() {
        return {
            racket: {}
        }
    },

    created() {
        this.getRacket();
    },

    methods: {
        getRacket() {
            RacketService.getRacketByTraining(this.user.id)
            .then(response => {
                this.racket = response.data;
            });
        },
    },


};
</script>


<style scoped>
figure {
    margin-left: 1rem;
}
</style>