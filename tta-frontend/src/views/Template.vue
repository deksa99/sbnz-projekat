<template>
    <div>
        <Navbar />
        <div class="container">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Додај нови ниво тренинга
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Додавање новог нивоа тренинга</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-body text-start">
                        <div class="form-group">
                            <input type="number" class="form-control" v-model="template.fixTechniqueLimit" placeholder="Лимит ѕа поправљање технике" required min="0" max="1">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" v-model="template.angleDelta" placeholder="Максимална раѕлика угла" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" v-model="template.speedDelta"  placeholder="Максимална разлика брзине" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" v-model="template.consecuctiveMisses" placeholder="Број узастопних промашаја" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" v-model="template.name" placeholder="Назив" required>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" v-model="template.level" placeholder="Ниво" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Затвори</button>
                    <button type="button" class="btn btn-primary">Потврди</button>
                </div>
                </div>
            </div>
            </div>


            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Fix Technique Limit</th>
                        <th scope="col">Angle Delta</th>
                        <th scope="col">Speed Delta</th>
                        <th scope="col">Consecuctive Misses</th>
                        <th scope="col">Name</th>
                        <th scope="col">Level</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="type in trainingLevels" :key="type.id">
                        <th scope="row">{{ type.id }}</th>
                        <td>{{ type.fixTechniqueLimit }}</td>
                        <td>{{ type.angleDelta }}</td>
                        <td>{{ type.speedDelta }}</td>
                        <td>{{ type.consecuctiveMisses }}</td>
                        <td>{{ type.name }}</td>
                        <td>{{ type.level }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";

export default {
    name: "Template",
    components: {
        Navbar,
    },

    data() {
        return {
            trainingLevels: [
                {
                    id: 1,
                    fixTechniqueLimit: "20",
                    angleDelta: 20,
                    speedDelta:  20,
                    consecuctiveMisses: 1,
                    name: "marko",
                    level: "nzm"
                },
                {
                    id: 2,
                    fixTechniqueLimit: "20",
                    angleDelta: 20,
                    speedDelta:  20,
                    consecuctiveMisses: 1,
                    name: "marko",
                    level: "nzm"
                },
            ],
            template: {}
        }
    },

    methods: {

    }
};
</script>

<style scoped>
button {
    margin-bottom: 1rem;
}

.container {
    margin-top: 1rem;
}
</style>

