<template>
    <RacketInfo :racket="this.racket"></RacketInfo>
</template>

<script>
import { mapState } from "vuex";
import RacketService from "@/service/RacketService.js";
import RacketInfo from "@/components/RacketInfo.vue";
import UserService from "@/service/UserService.js";

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
                console.log(response.data);
                this.racket = response.data;
                let data = {
                    "userId": this.user.id,
                    "bladeId": this.racket.blade.id,
                    "fhRubberId": this.racket.fhRubber.id,
                    "bhRubberId": this.racket.bhRubber.id
                }
                console.log(data);
                UserService.updateRacket(data)
                .then(response => {
                    console.log(response.data);
                })
                .catch(error => {
                    console.log(error);
                })
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