
<template>
<div class="modal-dialog">
    <div class="modal-content">

        <form id="registration-form" @submit.prevent="register">
            <div class="modal-body text-start">
                <div class="form-group">
                    <input type="text" class="form-control" v-model="user.firstName" placeholder="First name" required>
                    <div class="invalid-feedback">Невалидно име.</div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" v-model="user.lastName" placeholder="Last name" required>
                    <div class="invalid-feedback">Невалидно презиме.</div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" v-model="user.email" v-bind:class="{'is-invalid': invalidEmail}" placeholder="Email" required>
                    <div class="invalid-feedback">Невалидан имејл.</div>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" v-model="user.password" placeholder="Password" required>
                <div class="invalid-feedback">Невалидна лозинка.</div>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" v-model="confirmPassword" placeholder="Confirm password" required>
                    <div class="invalid-feedback">Лозинке се не поклапају.</div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary"> Региструј се</button>
            </div>
        </form>
    </div>
</div>
</template>

<script>
import UserService from "@/service/UserService.js";

export default {
    name: "RegistrationForm",

    data() {
        return {
            user: {
                firstName: "",
                lastName: "",
                email: "",
                password: ""
            },

            confirmPassword: "",
            invalidEmail: false
        }
    },

    methods: {
        register() {
            this.resetInvalidStates();

            if (this.validate()) {
                UserService.register(this.user)
                .then(response => console.log("Uspesno registrovan!", response.data))
                .catch(error => console.log("Greska pri registraciji!", error))
            }
        },

        validate() {

            let form = document.getElementById("registration-form");
            form.classList.add("was_validated");
            if (!form.checkValidity())
                return false;

            if (!this.user.email.match('^(.+)@(.+)$')) {
                this.invalidEmail = true;
                return false;
            }

            return true;
        },

        resetInvalidStates() {
            this.invalidEmail = false;

            let elements = document.querySelectorAll(".form-group input");
            elements.forEach(el => el.classList.remove("is-invalid"));
            let form = document.getElementById("registration-form");
            form.classList.remove("was_validated");
        },
    }

};
</script>

<style scoped>

input {
  outline: none;
  border-radius: 7px;
  border: none;
  background: #d3d3d3;
  font-family: Tahoma;
  margin-bottom: 15px;
}

label {
  font-family: Tahoma;
}

.btn {
  margin: auto;
  display: block;
}

a {
  color: blue;
  text-decoration: underline;
}
</style>