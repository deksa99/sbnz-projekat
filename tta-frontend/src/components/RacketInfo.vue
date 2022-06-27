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
            <li>Мекоћа: {{ racket.blade.stiffness }}</li>
            <li>Тврдоћа {{ racket.blade.hardness }}</li>
            <li>Конзистентност: {{ racket.blade.consistency }}</li>
            <li>Тежина: {{ racket.blade.weight }}</li>
            <li>Цена: {{ racket.blade.price }}</li>
            <li>Грип: {{ racket.blade.grip }}</li>
            <li>Тип грипа: {{ racket.blade.gripType }}</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Форхенд Гума</figcaption>
        <ul>
            <li>Назив: {{ racket.fhRubber.name }}</li>
            <li>Брзина: {{ racket.fhRubber.speed }}</li>
            <li>Контрола: {{ racket.fhRubber.control }}</li>
            <li>Тикнес: {{ racket.fhRubber.tackiness }}</li>
            <li>Тежина: {{ racket.fhRubber.weight }}</li>
            <li>Тврдоћа:  {{ racket.fhRubber.hardness }}</li>
            <li>Конзистентност: {{ racket.fhRubber.consistency }}</li>
            <li>Цена: {{ racket.fhRubber.price }}$</li>
        </ul>
    </figure>
    <figure>
        <figcaption>Бекенд Гума</figcaption>
        <ul>
            <li>Назив: {{ racket.bhRubber.name }}</li>
            <li>Брзина: {{ racket.bhRubber.speed }}</li>
            <li>Контрола: {{ racket.bhRubber.control }}</li>
            <li>Тацкинес: {{ racket.bhRubber.tackiness }}</li>
            <li>Тежина: {{ racket.bhRubber.weight }}</li>
            <li>Тврдоћа: {{ racket.bhRubber.hardness }}</li>
            <li>Конзистентност: {{ racket.bhRubber.consistency }}</li>
            <li>Цена: {{ racket.bhRubber.price }}$</li>
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