<template>
<div class="card">
    <div class="card-body">
        <h5 class="card-title">На основу историје тренинга изабран је следећи рекет:</h5>

    </div>
    <figure>
        <figcaption>Дршка</figcaption>
        <ul>
            <li>Назив: {{ blade.name }}</li>
            <li>Брзина: {{ blade.speed }}</li>
            <li>Контрола: {{ blade.control }}</li>
            <li>{{ blade.stiffness }}</li>
            <li>{{ blade.hardness }}</li>
            <li>{{ blade.consistency }}</li>
            <li>{{ blade.weight }}</li>
            <li>{{ blade.price }}</li>
            <li>{{ blade.grip }}</li>
            <li>{{ blade.gripType }}</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Форхенд Гума</figcaption>
        <ul>
            <li>Назив: {{ fhRubber.name }}</li>
            <li>Брзина: {{ fhRubber.speed }}</li>
            <li>Контрола: {{ fhRubber.control }}</li>
            <li>{{ fhRubber.tackiness }}</li>
            <li>{{ fhRubber.weight }}</li>
            <li>{{ fhRubber.hardness }}</li>
            <li>{{ fhRubber.consistency }}</li>
            <li>{{ fhRubber.price }}$</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Бекенд Гума</figcaption>
        <ul>
            <li>Назив: {{ bhRubber.name }}</li>
            <li>Брзина: {{ bhRubber.speed }}</li>
            <li>Контрола: {{ bhRubber.control }}</li>
            <li>{{ bhRubber.tackiness }}</li>
            <li>{{ bhRubber.weight }}</li>
            <li>{{ bhRubber.hardness }}</li>
            <li>{{ bhRubber.consistency }}</li>
            <li>{{ bhRubber.price }}$</li>
        </ul>
    </figure>
</div>

</template>

<script>
import { mapState } from "vuex";
import RacketService from "@/service/RacketService.js";

export default {
    name: "ChooseRacketForm",

    computed: {
        ...mapState([
            'user',
        ])
    },

    data() {
        return {
            blade: {},
            fhRubber: {},
            bhRubber: {}
        }
    },


    methods: {
        getRacket() {
            RacketService.getRacketByTraining(this.user.id)
            .then(response => {
                this.fhRubber = response.data.fhRubber;
                this.bhRubber = response.data.fhRubber;
                this.blade = response.data.blade;
            });
        },
    }


};
</script>


<style scoped>
figure {
    margin-left: 1rem;
}
</style>