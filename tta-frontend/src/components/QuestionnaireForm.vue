<template>
<form id="questionnaire-form" @submit.prevent="confirm">


    <div v-if="this.selectedRacket"> 
        <h5 class="card-title">На основу попуњеног упитника изабран је следећи рекет:</h5>
        <RacketInfo :racket="this.selectedRacket"></RacketInfo>
    </div>

    <div v-else>
        <div class="card">
            <div class="card-body">

                <h5 class="card-title">Искуство</h5>

                <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="ABSOLUTE_BEGINNER" type="radio" name="ABSOLUTE_BEGINNER" id="ABSOLUTE_BEGINNER" checked>
                            <label class="form-check-label" for="ABSOLUTE_BEGINNER">
                                Апсолутни почетник
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="BEGINNER" type="radio" name="BEGINNER" id="BEGINNER">
                            <label class="form-check-label" for="BEGINNER">
                                Почетник
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="HOBBYIST" type="radio" name="HOBBYIST" id="HOBBYIST">
                            <label class="form-check-label" for="HOBBYIST">
                                Хобиста
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="INTERMEDIATE" type="radio" name="INTERMEDIATE" id="INTERMEDIATE">
                            <label class="form-check-label" for="INTERMEDIATE">
                                Средње
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="SEMI_PRO" type="radio" name="SEMI_PRO" id="SEMI_PRO">
                            <label class="form-check-label" for="SEMI_PRO">
                                Полу-професионалац
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.trainingExperience" value="PRO" type="radio" name="PRO" id="PRO">
                            <label class="form-check-label" for="PRO">
                                Професионалац
                            </label>
                        </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Буџет</h5>

                <div class="form-row budzet">
                    <div class="col-sm-3 my-1">
                        <input type="number" v-model="racketRecommendationForm.minBudget" class="form-control" id="minBudget" placeholder="Цена од">
                    </div>
                    <div class="col-sm-3 my-1">
                        <input type="number" v-model="racketRecommendationForm.maxBudget" class="form-control" id="maxBudget" placeholder="Цена до">
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Stil igre na osnovu slika</h5>
                <div class="form-group container-fluid">
                    <div class="row flex-row flex-nowrap overflow-auto">

                        <div v-for="situation in racketRecommendationForm.situations" :key="situation.id" class="col-sm-6">
                            <div class="card">
                                <img class="card-img-top" src="@/assets/logo.png" alt="Card image cap">
                                <div class="card-body">

                                    <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.racketOrientation" value="FOREHAND" type="radio" :id="'forehand' + situation.id" checked>
                                            <label class="form-check-label" :for="'forehand' + situation.id">
                                                Forehand
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.racketOrientation" value="BACKHAND" type="radio" :id="'backend' + situation.id">
                                            <label class="form-check-label" :for="'backend' + situation.id">
                                                Backhand
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="HIT" type="radio" :id="'hit' + situation.id" checked>
                                            <label class="form-check-label" :for="'hit' + situation.id">
                                                Hit
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="FLICK" type="radio" :id="'flick' + situation.id">
                                            <label class="form-check-label" :for="'flick' + situation.id">
                                                Flick
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="LOOP" type="radio" :id="'loop' + situation.id">
                                            <label class="form-check-label" :for="'loop' + situation.id">
                                                Loop
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="PUSH" type="radio" :id="'push' + situation.id">
                                            <label class="form-check-label" :for="'push' + situation.id">
                                                Push
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="BLOCK" type="radio" :id="'block' + situation.id">
                                            <label class="form-check-label" :for="'block' + situation.id">
                                                Block
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="situation.response" value="CHOP" type="radio" :id="'chop' + situation.id">
                                            <label class="form-check-label" :for="'chop' + situation.id">
                                                Chop
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Стил држања рекета</h5>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" v-model="racketRecommendationForm.grip" value="PENHOLD" type="radio" name="PENHOLD" id="PENHOLD">
                        <label class="form-check-label" for="PENHOLD">
                            Penhold
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="racketRecommendationForm.grip" value="SHAKEHAND" type="radio" name="SHAKEHAND" id="SHAKEHAND">
                        <label class="form-check-label" for="SHAKEHAND">
                            Shakehand
                        </label>
                    </div>
                </div>

                <div v-if="racketRecommendationForm.grip !== ''" class="form-group">
                    <h5 class="card-title">Тип стила држања рекета</h5>
                    <div v-if="racketRecommendationForm.grip === 'PENHOLD'" class="form-group">
                    </div>

                    <div v-if="racketRecommendationForm.grip === 'SHAKEHAND'" class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.gripType" value="FL" type="radio" name="FL" id="FL">
                            <label class="form-check-label" for="FL">
                                Flared
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.gripType" value="ST" type="radio" name="ST" id="ST">
                            <label class="form-check-label" for="ST">
                                Straight
                            </label>
                        </div>
                            <div class="form-check">
                            <input class="form-check-input" v-model="racketRecommendationForm.gripType" value="AN" type="radio" name="AN" id="AN">
                            <label class="form-check-label" for="AN">
                                Anatomic
                            </label>
                        </div>    
                    </div>
                </div>
            </div>
        </div>
        <div class="card">
            <button class="btn btn-outline-primary" type="submit">Потврди</button>
        </div>
    </div>
</form>
</template>

<script>
import RacketService from "@/service/RacketService.js";
import RacketInfo from "@/components/RacketInfo.vue";

export default {
    name: "ChooseRacketForm",

    components: {
        RacketInfo
    },

    data() {
        return {
            racketRecommendationForm: {
                trainingExperience: "ABSOLUTE_BEGINNER",
                minBudget: "",
                maxBudget: "",
                grip: "SHAKEHAND",
                gripType: "FL",
                
                situations: [
                    {
                        id: 1,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    },
                    {
                        id: 2,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    },
                    {
                        id: 3,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    },
                    {
                        id: 4,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    },
                    {
                        id: 5,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    },
                    {
                        id: 6,
                        racketOrientation: "",
                        response: "",
                        coef: 1
                    }
                ]
            },

            selectedRacket: ""
        }
    },

    methods: {
        confirm() {
            console.log(this.racketRecommendationForm);
            RacketService.getRacketRecommendation(this.racketRecommendationForm)
            .then(response => {
                this.selectedRacket = response.data;
            })
            .catch(error => {
                console.log(error);
            })
        }
    }

};
</script>


<style scoped>
.card {
    border-radius: 1rem;
    margin: 1rem;
}

</style>