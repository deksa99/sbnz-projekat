<template>
<form id="questionnaire-form" @submit.prevent="confirm">

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Искуство</h5>

            <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="ABSOLUTE_BEGINNER" type="radio" name="ABSOLUTE_BEGINNER" id="ABSOLUTE_BEGINNER" checked>
                        <label class="form-check-label" for="ABSOLUTE_BEGINNER">
                            Апсолутни почетник
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="BEGINNER" type="radio" name="BEGINNER" id="BEGINNER">
                        <label class="form-check-label" for="BEGINNER">
                            Почетник
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="HOBBYIST" type="radio" name="HOBBYIST" id="HOBBYIST">
                        <label class="form-check-label" for="HOBBYIST">
                            Хобиста
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="INTERMEDIATE" type="radio" name="INTERMEDIATE" id="INTERMEDIATE">
                        <label class="form-check-label" for="INTERMEDIATE">
                            Средње
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="SEMI_PRO" type="radio" name="SEMI_PRO" id="SEMI_PRO">
                        <label class="form-check-label" for="SEMI_PRO">
                            Полу-професионалац
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="trainingExperience" value="PRO" type="radio" name="PRO" id="PRO">
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
                    <input type="number" v-model="priceFrom" class="form-control" id="priceFrom" placeholder="Цена од">
                </div>
                <div class="col-sm-3 my-1">
                    <input type="number" v-model="priceTo" class="form-control" id="priceTo" placeholder="Цена до">
                </div>
            </div>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Stil igre na osnovu slika</h5>
            <div class="form-group container-fluid">
                <div class="row flex-row flex-nowrap overflow-auto">
                    <div class="col-sm-6">
                        <div class="card">
                            <img class="card-img-top" src="@/assets/logo.png" alt="Card image cap">
                            <div class="card-body">

                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgRacketOrientation" value="FOREHAND" type="radio" name="FOREHAND" id="FOREHAND1">
                                        <label class="form-check-label" for="FOREHAND1">
                                            Forehand
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgRacketOrientation" value="BACKHAND" type="radio" name="BACKHAND" id="BACKHAND1">
                                        <label class="form-check-label" for="BACKHAND1">
                                            Backhand
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="HIT" type="radio" name="HIT" id="HIT1">
                                        <label class="form-check-label" for="HIT1">
                                            Hit
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="FLICK" type="radio" name="FLICK" id="FLICK1">
                                        <label class="form-check-label" for="FLICK1">
                                            Flick
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="LOOP" type="radio" name="LOOP" id="LOOP1">
                                        <label class="form-check-label" for="LOOP1">
                                            Loop
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="PUSH" type="radio" name="PUSH" id="PUSH1">
                                        <label class="form-check-label" for="PUSH1">
                                            Push
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="BLOCK" type="radio" name="BLOCK" id="BLOCK1">
                                        <label class="form-check-label" for="BLOCK1">
                                            Block
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" v-model="firstImgHit" value="CHOP" type="radio" name="CHOP" id="CHOP1">
                                        <label class="form-check-label" for="CHOP1">
                                            Chop
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <img class="card-img-top" src="@/assets/logo.png" alt="Card image cap">

                            <div class="card-body">
                                <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgRacketOrientation" value="FOREHAND" type="radio" name="FOREHAND" id="FOREHAND2">
                                            <label class="form-check-label" for="FOREHAND2">
                                                Forehand
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgRacketOrientation" value="BACKHAND" type="radio" name="BACKHAND" id="BACKHAND2">
                                            <label class="form-check-label" for="BACKHAND2">
                                                Backhand
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="HIT" type="radio" name="HIT" id="HIT2">
                                            <label class="form-check-label" for="HIT2">
                                                Hit
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="FLICK" type="radio" name="FLICK" id="FLICK2">
                                            <label class="form-check-label" for="FLICK2">
                                                Flick
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="LOOP" type="radio" name="LOOP" id="LOOP2">
                                            <label class="form-check-label" for="LOOP2">
                                                Loop
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="PUSH" type="radio" name="PUSH" id="PUSH2">
                                            <label class="form-check-label" for="PUSH2">
                                                Push
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="BLOCK" type="radio" name="BLOCK" id="BLOCK2">
                                            <label class="form-check-label" for="BLOCK2">
                                                Block
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="secondImgHit" value="CHOP" type="radio" name="CHOP" id="CHOP2">
                                            <label class="form-check-label" for="CHOP2">
                                                Chop
                                            </label>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <img class="card-img-top" src="@/assets/logo.png" alt="Card image cap">

                            <div class="card-body">
                                <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgRacketOrientation" value="FOREHAND" type="radio" name="FOREHAND" id="FOREHAND3">
                                            <label class="form-check-label" for="FOREHAND3">
                                                Forehand
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgRacketOrientation" value="BACKHAND" type="radio" name="BACKHAND" id="BACKHAND3">
                                            <label class="form-check-label" for="BACKHAN3">
                                                Backhand
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="HIT" type="radio" name="HIT" id="HIT3">
                                            <label class="form-check-label" for="HIT3">
                                                Hit
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="FLICK" type="radio" name="FLICK" id="FLICK3">
                                            <label class="form-check-label" for="FLICK3">
                                                Flick
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="LOOP" type="radio" name="LOOP" id="LOOP3">
                                            <label class="form-check-label" for="LOOP3">
                                                Loop
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="PUSH" type="radio" name="PUSH" id="PUSH3">
                                            <label class="form-check-label" for="PUSH3">
                                                Push
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="BLOCK" type="radio" name="BLOCK" id="BLOCK3">
                                            <label class="form-check-label" for="BLOCK3">
                                                Block
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" v-model="thirdImgHit" value="CHOP" type="radio" name="CHOP" id="CHOP3">
                                            <label class="form-check-label" for="CHOP3">
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
                    <input class="form-check-input" v-model="grip" value="PENHOLD" type="radio" name="PENHOLD" id="PENHOLD">
                    <label class="form-check-label" for="PENHOLD">
                        Penhold
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" v-model="grip" value="SHAKEHAND" type="radio" name="SHAKEHAND" id="SHAKEHAND">
                    <label class="form-check-label" for="SHAKEHAND">
                        Shakehand
                    </label>
                </div>
            </div>

            <div v-if="grip !== ''" class="form-group">
                <h5 class="card-title">Тип стила држања рекета</h5>
                <div v-if="grip === 'PENHOLD'" class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" v-model="gripType" value="FL" type="radio" name="FL" id="FL">
                        <label class="form-check-label" for="FL">
                            Flared
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="gripType" value="ST" type="radio" name="ST" id="ST">
                        <label class="form-check-label" for="ST">
                            Straight
                        </label>
                    </div>
                        <div class="form-check">
                        <input class="form-check-input" v-model="gripType" value="AN" type="radio" name="AN" id="AN">
                        <label class="form-check-label" for="AN">
                            Anatomic
                        </label>
                    </div>
                </div>

                <div v-if="grip === 'SHAKEHAND'" class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" v-model="gripType" value="CHINESE" type="radio" name="CHINESE" id="CHINESE">
                        <label class="form-check-label" for="CHINESE">
                            CH
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" v-model="gripType" value="JAPANESE" type="radio" name="JAPANESE" id="JAPANESE">
                        <label class="form-check-label" for="JAPANESE">
                            JP
                        </label>
                    </div>        
                </div>
            </div>
        </div>
    </div>
    <div class="card">
    <button class="btn btn-outline-primary" type="submit">Потврди</button>
    </div>
</form>
</template>

<script>

export default {
    name: "ChooseRacketForm",

    data() {
        return {
            trainingExperience: "ABSOLUTE_BEGINNER",
            priceFrom: "",
            priceTo: "",
            grip: "",
            gripType: "",
            
            firstImgRacketOrientation: "",
            firstImgHit: "",

            secondImgRacketOrientation: "",
            secondImgHit: "",

            thirdImgRacketOrientation: "",
            thirdImgHit: ""
        }
    },

    methods: {
        confirm() {
            console.log("posalji ga");
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