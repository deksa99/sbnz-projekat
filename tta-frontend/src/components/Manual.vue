<template>
<div>
    <div class="row">
        <div class="col-sm">
            <div class="form-group">
                <label for="blades">Drška</label>
                <select class="form-control" id="blades" @change="onChange($event)" v-model="selectedBlade">
                <option v-for="blade in blades" :key="blade.id" :value="blade.id">{{ blade.name }} | Spin: {{ blade.spin }} | Brzina: {{ blade.speed }} | Kontrola: {{ blade.control }} | Cena: {{ blade.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="fhRubber">Forehand Guma</label>
                <select class="form-control" id="fhRubber" @change="onChange($event)" v-model="selectedFhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id" :value="rubber.id">{{ rubber.name }} | Spin: {{ rubber.spin }} | Brzina: {{ rubber.speed }} | Kontrola: {{ rubber.control }} | Cena: {{ rubber.price }}$</option>
                </select>
            </div>
        </div>

        <div class="col-sm">
            <div class="form-group">
                <label for="bhRubber">Backend Guma</label>
                <select class="form-control" id="bhRubber" @change="onChange($event)" v-model="selectedBhRubber">
                <option v-for="rubber in rubbers" :key="rubber.id" :value="rubber.id">{{ rubber.name }} | Spin: {{ rubber.spin }} | Brzina: {{ rubber.speed }} | Kontrola: {{ rubber.control }} | Cena: {{ rubber.price }}$</option>
                </select>
            </div>
        </div>
    </div>

    <div v-if="this.selectedRacket">
        <RacketInfo :racket="this.selectedRacket"></RacketInfo>
    </div>
</div>
</template>

<script>
import { mapState } from "vuex";
import BladesService from "@/service/BladesService.js";
import RubbersService from "@/service/RubbersService.js";
import UserService from "@/service/UserService.js";
import RacketInfo from "@/components/RacketInfo.vue";

export default {
    name: "Manual",

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
            option: "TRAINING",
            blades: [],
            rubbers: [],

            selectedBlade: null,
            selectedFhRubber: null,
            selectedBhRubber: null,

            selectedRacket: ""
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

            if (this.selectedBlade && this.selectedFhRubber && this.selectedBhRubber) {
                let data = {
                    "userId": this.user.id,
                    "bladeId": this.selectedBlade,
                    "fhRubberId": this.selectedFhRubber,
                    "bhRubberId": this.selectedBhRubber
                }
                console.log(data);
                UserService.updateRacket(data)
                .then(response => {
                    this.selectedRacket = response.data.racket
                    console.log(this.selectedRacket);
                })
                .catch(error => {
                    console.log(error);
                })
            }
        }
    }
};
</script>


<style scoped>

</style>