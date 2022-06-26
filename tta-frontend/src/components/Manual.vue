<template>
<div>
    <div class="row">
        <div class="col-sm">
            <div class="form-group">
                <label for="blades">Drška</label>
                <select class="form-control" id="blades" @change="onChange($event)" v-model="selectedBlade">
                <option v-for="blade in blades" :key="blade.id" :value="blade.id">Naziv: {{ blade.name }} | Spin: {{ blade.spin }} | Brzina: {{ blade.speed }} | Kontrola: {{ blade.control }} | Cena: {{ blade.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="fhRubber">Forehand Guma</label>
                <select class="form-control" id="fhRubber" @change="onChange($event)" v-model="selectedFhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id" :value="rubber.id">Naziv: {{ rubber.name }} | Spin: {{ rubber.spin }} | Brzina: {{ rubber.speed }} | Kontrola: {{ rubber.control }} | Cena: {{ rubber.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="bhRubber">Backend Guma</label>
                <select class="form-control" id="bhRubber" @change="onChange($event)" v-model="selectedBhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id" :value="rubber.id">Naziv: {{ rubber.name }} | Spin: {{ rubber.spin }} | Brzina: {{ rubber.speed }} | Kontrola: {{ rubber.control }} | Cena: {{ rubber.price }}$</option>
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
            rubbers: [],

            selectedBlade: null,
            selectedFhRubber: null,
            selectedBhRubber: null
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

        onChange(event) {
            console.log(event.target.value);

            if (this.selectedBlade && this.selectedFhRubber && this.selectedBhRubber)
                console.log("Moze bato sad ga lomi");
        }
    }
};
</script>


<style scoped>

</style>