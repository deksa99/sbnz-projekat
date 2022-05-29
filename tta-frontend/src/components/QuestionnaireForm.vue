<template>
<form id="questionnaire-form" @submit.prevent="confirm">

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Iskustvo</h5>

            <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Apsolutni početnik
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Početnik
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3">
                        <label class="form-check-label" for="flexRadioDefault3">
                            Hobista
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault4">
                        <label class="form-check-label" for="flexRadioDefault4">
                            Napredan
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault5">
                        <label class="form-check-label" for="flexRadioDefault5">
                            Polu-profesionalac
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            Profesionalac
                        </label>
                    </div>
            </div>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Budžet</h5>

            <div class="form-row budzet">
                <div class="col-sm-3 my-1">
                    <label class="sr-only" for="inlineFormInputName">Cena od</label>
                    <input type="number" class="form-control" id="inlineFormInputName" placeholder="Cena od">
                </div>
                <div class="col-sm-3 my-1">
                    <label class="sr-only" for="inlineFormInputGroupUsername">Cena do</label>
                    <input type="number" class="form-control" id="inlineFormInputGroupUsername" placeholder="Cena do">
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
                        <div class="card-body">

                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault4">
                                <label class="form-check-label" for="flexRadioDefault4">
                                    Napredan
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault5">
                                <label class="form-check-label" for="flexRadioDefault5">
                                    Polu-profesionalac
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                                <label class="form-check-label" for="flexRadioDefault6">
                                    Profesionalac
                                </label>
                            </div>
                            
                        </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Special title treatment</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Special title treatment</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Stil držanja reketa</h5>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                    <label class="form-check-label" for="flexRadioDefault6">
                        Penhold
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                    <label class="form-check-label" for="flexRadioDefault6">
                        Shakehand
                    </label>
                </div>

                <div v-if="true" class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            Flared
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            Straight
                        </label>
                    </div>
                        <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            Anatomic
                        </label>
                    </div>
                </div>

                <div v-if="true" class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            CH
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault6">
                        <label class="form-check-label" for="flexRadioDefault6">
                            JP
                        </label>
                    </div>        
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