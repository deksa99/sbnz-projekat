<template>
<div class="card">
    <div class="card-body">
        <h5 class="card-title">Основне информације о рекету:</h5>

    </div>
    <figure>
        <figcaption>Дршка</figcaption>
        <ul>
            <li>Назив: {{ racket.blade.name }}</li>
            <li>Брзина: {{ racket.blade.speed }}</li>
            <li>Контрола: {{ racket.blade.control }}</li>
            <li>{{ racket.blade.stiffness }}</li>
            <li>{{ racket.blade.hardness }}</li>
            <li>{{ racket.blade.consistency }}</li>
            <li>{{ racket.blade.weight }}</li>
            <li>{{ racket.blade.price }}</li>
            <li>{{ racket.blade.grip }}</li>
            <li>{{ racket.blade.gripType }}</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Форхенд Гума</figcaption>
        <ul>
            <li>Назив: {{ racket.fhRubber.name }}</li>
            <li>Брзина: {{ racket.fhRubber.speed }}</li>
            <li>Контрола: {{ racket.fhRubber.control }}</li>
            <li>{{ racket.fhRubber.tackiness }}</li>
            <li>{{ racket.fhRubber.weight }}</li>
            <li>{{ racket.fhRubber.hardness }}</li>
            <li>{{ racket.fhRubber.consistency }}</li>
            <li>{{ racket.fhRubber.price }}$</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Бекенд Гума</figcaption>
        <ul>
            <li>Назив: {{ racket.bhRubber.name }}</li>
            <li>Брзина: {{ racket.bhRubber.speed }}</li>
            <li>Контрола: {{ racket.bhRubber.control }}</li>
            <li>{{ racket.bhRubber.tackiness }}</li>
            <li>{{ racket.bhRubber.weight }}</li>
            <li>{{ racket.bhRubber.hardness }}</li>
            <li>{{ racket.bhRubber.consistency }}</li>
            <li>{{ racket.bhRubber.price }}$</li>
        </ul>
    </figure>
</div>

</template>

<script>
import { mapState } from "vuex";

export default {
    name: "ChooseRacketForm",

    computed: {
        ...mapState([
            'user',
        ])
    },

    props: {
        racket: Object
    },

};
</script>


<style scoped>
figure {
    margin-left: 1rem;
}
</style>