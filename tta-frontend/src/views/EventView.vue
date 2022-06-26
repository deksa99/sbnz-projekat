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
                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            Ударци
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Датум: {{ date }}</li>
                            <li class="list-group-item">Тип тренинга: {{ type }}</li>
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