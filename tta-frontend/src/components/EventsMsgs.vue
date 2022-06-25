
<template>
    <div class="row">

        <div class="col-sm">
            <div class="alert alert-success" role="alert">
                NIVO: NAPREDAN
            </div>
            <div class="alert alert-success" role="alert">
                ZNANJE: NAPREDAN
            </div>
                        <div class="alert alert-success" role="alert">
                NIVO: NAPREDAN
            </div>
                        <div class="alert alert-success" role="alert">
                NIVO: NAPREDAN
            </div>
        </div>

        <div class="col-sm">
            <div class="alert alert-primary" role="alert">
                {{ msg }}
            </div>
            <div class="alert alert-primary" role="alert">
                {{ msg }}
            </div>
                <div class="alert alert-primary" role="alert">
                {{ msg }}
            </div>
        </div>


        <div class="col-sm">
            <div class="alert alert-primary" role="alert">
                {{ msg }}
            </div>
        </div>

    </div>

</template>

<script>

export default {
    name: "EventsMsgs",

    data() {
        return {
            msg: "KARINA BANANA"
        }
    },

};
</script>

<style scoped>


</style>