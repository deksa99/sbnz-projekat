<template>
<form id="choose-racket-form">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Изаберите један од понуђених начина за избор рекета</h5>

            <div class="form-group">

                <div class="form-check">
                    <input v-model="option" value="QUESTIONNARE" class="form-check-input" type="radio" name="flexRadioDefault1" id="flexRadioDefault1" checked>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Упитник
                    </label>
                </div>
                <div class="form-check">
                    <input v-model="option" value="TRAINING" class="form-check-input" type="radio" name="flexRadioDefault2" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Историја тренинга
                    </label>
                </div>
                <div class="form-check">
                    <input v-model="option" value="MANUAL" class="form-check-input" type="radio" name="flexRadioDefault3" id="flexRadioDefault3">
                    <label class="form-check-label" for="flexRadioDefault3">
                        Ручно бирање рекета
                    </label>
                </div>
            </div>
        </div>
    </div>

    <QuestionnaireForm v-if="option === 'QUESTIONNARE'"></QuestionnaireForm>
    <Manual v-if="option === 'MANUAL'"></Manual>
    <RacketByTraining v-if="option === 'TRAINING'"> </RacketByTraining>

</form>
</template>

<script>
import QuestionnaireForm from "@/components/QuestionnaireForm.vue";
import Manual from "@/components/Manual.vue";
import RacketByTraining from "@/components/RacketByTraining"

export default {
    name: "ChooseRacketForm",
    components: {
        QuestionnaireForm,
        Manual,
        RacketByTraining
    },

    data() {
        return {
            option: ""
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