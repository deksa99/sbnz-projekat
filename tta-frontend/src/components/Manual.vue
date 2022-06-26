<template>
<div>
    <div class="row">
        <div class="col-sm">
            <div class="form-group">
                <label for="blades">Drška</label>
                <select class="form-control" id="blades">
                <option v-for="blade in blades" :key="blade.id">Naziv: {{ blade.name }} | Spin: {{ blade.spin }} | Brzina: {{ blade.speed }} | Kontrola: {{ blade.control }} | Cena: {{ blade.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="fhRubber">Forehand Guma</label>
                <select class="form-control" id="fhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id">Naziv: {{ blade.name }} | Spin: {{ blade.spin }} | Brzina: {{ blade.speed }} | Kontrola: {{ blade.control }} | Cena: {{ blade.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="bhRubber">Backend Guma</label>
                <select class="form-control" id="bhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id">Naziv: {{ rubber.name }} | Spin: {{ rubber.spin }} | Brzina: {{ rubber.speed }} | Kontrola: {{ rubber.control }} | Cena: {{ rubber.price }}$</option>
                </select>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import BladesService from "@/service/BladesService.js";
import RubbersService from "@/service/RubbersService.js";


export default {
    name: "Manual",

    data() {
        return {
            option: "TRAINING",
            blades: [],
            rubbers: []
        }
    },

    created() {
        this.getRubbers();
        this.getBlades();
    },

    methods: {
        getRubbers() {
            RubbersService.getRubbers()
            .then(response => {
                this.rubbers = response.data;
            });
        },

        getBlades() {
            BladesService.getBlades()
            .then(response => {
                this.blades = response.data;
            });
        },
    }
};
</script>


<style scoped>

</style>