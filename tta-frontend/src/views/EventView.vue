<template>
    <div>
        <Navbar />
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            Trening informacije
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Датум: {{ date }}</li>
                            <li class="list-group-item">Тип тренинга: {{ type }}</li>
                            <li class="list-group-item">Орентација рекета: {{ racketOrientation }}</li>
                            <li class="list-group-item">Спин: {{ spin }}</li>
                            <li class="list-group-item">Очекивани угао: {{ expectedAngle }}</li>
                            <li class="list-group-item">Очекивана брзина: {{ expectedSpeed }}</li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="card events" style="width: 18rem;">
                        <div class="card-header">
                            Догађаји
                        </div>
                        <div class="alert alert-success" role="alert">Погрешан угао</div>
                        <div class="alert alert-success" role="alert">Погрешан угао</div>
                    </div>                
                </div>
                <div class="col-sm">
                    <div v-for="hit in hits" :key="hit.id" class="card" style="width: 18rem;">
                        <div class="card-header">
                            Ударац
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Стартна позиција: {{ hit.startPosition }}</li>

                            <li class="list-group-item">Крајња позиција: {{ hit.endPosition }}</li>

                            <li class="list-group-item">Угао: {{ hit.angle }}</li>
                            <li class="list-group-item">Брзина: {{ hit.speed }}</li>
                            <li class="list-group-item">Резултат: {{ hit.result }}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";

export default {
    name: "Home",
    components: {
        Navbar,
    },

    data() {
        return {
            racketOrientation: "",
            type: "",
            date: "",
            spin: "",
            expectedAngle: "",
            expectedSpeed: "",
            hits: [
                {
                    angle: 20,
                    speed: 100,
                    startPosition: 20,
                    endPosition: 20,
                    result: "win"
                },
                {
                    angle: 20,
                    speed: 100,
                    startPosition: 20,
                    endPosition: 30,
                    result: "win"
                }
            ]
        }
    }
};
</script>

<style scoped>

.container {
    margin-top: 2rem;
    width: 1600px;
}

.card-header {
    font-weight: bold;
}

.alert {
    margin-bottom: 1px;
}
</style>