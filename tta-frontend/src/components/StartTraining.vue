
<template>
<div class="modal-dialog">
    <div class="modal-content">
        <form id="training-form" @submit.prevent="confirm">
            <div class="modal-body text-start">
                <div class="card">
                <div class="card-body">
                            <h5> Изаберите начин тренинга: </h5>
                    <div class="form-group container-fluid">
                        <div class="row flex-row flex-nowrap overflow-auto">
                            <div class="col-sm-6">
                                <div class="card">
                                    <div class="card-body">

                                        <div class="form-group">
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.racketOrientation" value="FOREHAND" type="radio" :id="'forehand'" checked>
                                                <label class="form-check-label" :for="'forehand'">
                                                    Forehand
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.racketOrientation" value="BACKHAND" type="radio" :id="'backend'">
                                                <label class="form-check-label" :for="'backend'">
                                                    Backhand
                                                </label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="HIT" type="radio" :id="'hit'" checked>
                                                <label class="form-check-label" :for="'hit'">
                                                    Hit
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="FLICK" type="radio" :id="'flick'">
                                                <label class="form-check-label" :for="'flick'">
                                                    Flick
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="LOOP" type="radio" :id="'loop'">
                                                <label class="form-check-label" :for="'loop'">
                                                    Loop
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="PUSH" type="radio" :id="'push'">
                                                <label class="form-check-label" :for="'push'">
                                                    Push
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="BLOCK" type="radio" :id="'block'">
                                                <label class="form-check-label" :for="'block'">
                                                    Block
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.hitType" value="CHOP" type="radio" :id="'chop'">
                                                <label class="form-check-label" :for="'chop'">
                                                    Chop
                                                </label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.spin" value="TOP" type="radio" :id="'top'" checked>
                                                <label class="form-check-label" :for="'top'">
                                                    Top
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.spin" value="BACK" type="radio" :id="'back'">
                                                <label class="form-check-label" :for="'back'">
                                                    Back
                                                </label>
                                            </div>
                                             <div class="form-check">
                                                <input class="form-check-input" v-model="startTrainingForm.spin" value="SIDE" type="radio" :id="'side'">
                                                <label class="form-check-label" :for="'side'">
                                                    Side
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
            </div>
            <div class="card">
                <button class="btn btn-outline-primary" type="submit">Потврди</button>
            </div>
        </form>
    </div>
</div>
</template>

<script>
import TrainingService from "@/service/TrainingService.js";
import { mapState } from "vuex";

export default {
    name: "StartTraining",

    computed: {
        ...mapState([
            'user',
        ])
    },

    data() {
        return {
            startTrainingForm: {
                racketOrientation: "",
                hitType: "",
                spin: ""
            }
        }
    },

    methods: {
        confirm() {
            this.startTrainingForm.userId = this.user.id;
            console.log(this.startTrainingForm);
            TrainingService.getTraining(this.startTrainingForm)
            .then(response => {
                console.log(response.data);
                this.$emit('training-started', response.data)
            })
        }
    }

};
</script>

<style scoped>


</style>