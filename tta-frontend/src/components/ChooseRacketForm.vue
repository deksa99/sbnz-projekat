<template>
<form id="choose-racket-form">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Način biranja reketa</h5>

            <div class="form-group">

                <div class="form-check">
                    <input v-model="option" value="QUESTIONNARE" class="form-check-input" type="radio" name="flexRadioDefault1" id="flexRadioDefault1" checked>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Upitnik
                    </label>
                </div>
                <div class="form-check">
                    <input v-model="option" value="TRAINING" class="form-check-input" type="radio" name="flexRadioDefault2" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Trening
                    </label>
                </div>
                <div class="form-check">
                    <input v-model="option" value="MANUAL" class="form-check-input" type="radio" name="flexRadioDefault3" id="flexRadioDefault3">
                    <label class="form-check-label" for="flexRadioDefault3">
                        Ručno
                    </label>
                </div>
            </div>
        </div>
    </div>

    <QuestionnaireForm v-if="option === 'QUESTIONNARE'"></QuestionnaireForm>
    <Manual v-if="option === 'MANUAL'"></Manual>
    <RacketInfo v-if="option === 'TRAINING'"> </RacketInfo>

</form>
</template>

<script>
import QuestionnaireForm from "@/components/QuestionnaireForm.vue";
import Manual from "@/components/Manual.vue";
import RacketInfo from "@/components/RacketInfo"

export default {
    name: "ChooseRacketForm",
    components: {
        QuestionnaireForm,
        Manual,
        RacketInfo
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