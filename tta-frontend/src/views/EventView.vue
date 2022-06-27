<template>
    <div>
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            Trening informacije
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">fixTechniqueLimit: {{ training.level.fixTechniqueLimit }}</li>
                            <li class="list-group-item">angleDelta: {{ training.level.angleDelta }}</li>
                            <li class="list-group-item">speedDelta: {{ training.level.speedDelta }}</li>
                            <li class="list-group-item">consecuctiveMisses: {{ training.level.consecuctiveMisses }}</li>
                            <li class="list-group-item">name: {{ training.level.name }}</li>
                            <li class="list-group-item">level: {{ training.level.level }}</li>
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

export default {
    name: "EventView",
    props: {
        training: Object
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