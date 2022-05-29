<template>
<form id="choose-racket-form" @submit.prevent="confirm">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Način biranja reketa</h5>

            <div class="form-group">

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Upitnik
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Trening
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3" checked>
                    <label class="form-check-label" for="flexRadioDefault3">
                        Ručno
                    </label>
                </div>
            </div>
        </div>
    </div>
</form>
</template>

<script>

export default {
    name: "ChooseRacketForm",

};
</script>


<style scoped>
.card {
    border-radius: 1rem;
    margin: 1rem;
}

</style>