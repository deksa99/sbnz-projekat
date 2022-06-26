<template>
<div class="card">
    <img class="card-img-top" src="@/assets/logo.png" alt="Card image cap">
    <div class="card-body">
        <h5 class="card-title">Informacije o reketu</h5>

    </div>
    <figure>
        <figcaption>Drška</figcaption>
        <ul>
            <li>Naziv: {{ blade.name }}</li>
            <li>Brzina: {{ blade.speed }}</li>
            <li>Kontrola: {{ blade.control }}</li>
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
        <figcaption>Forehand Guma</figcaption>
        <ul>
            <li>Naziv: {{ fhRubber.name }}</li>
            <li>Brzina: {{ fhRubber.speed }}</li>
            <li>Kontrola: {{ fhRubber.control }}</li>
            <li>{{ fhRubber.tackiness }}</li>
            <li>{{ fhRubber.weight }}</li>
            <li>{{ fhRubber.hardness }}</li>
            <li>{{ fhRubber.consistency }}</li>
            <li>{{ fhRubber.price }}$</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Backend Guma</figcaption>
        <ul>
            <li>Naziv: {{ bhRubber.name }}</li>
            <li>Brzina: {{ bhRubber.speed }}</li>
            <li>Kontrola: {{ bhRubber.control }}</li>
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
import RacketService from "@/service/RacketService.js";

export default {
    name: "ChooseRacketForm",

    data() {
        return {
            blade: {},
            fhRubber: {},
            bhRubber: {}
        }
    },
    


    methods: {
        getRacket() {
            RacketService.getRacketByTraining()
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