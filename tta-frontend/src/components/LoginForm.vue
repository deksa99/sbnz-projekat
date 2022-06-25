
<template>
<div class="modal-dialog">
    <div class="modal-content">
        <form id="login-form" @submit.prevent="login">
            <div class="modal-body text-start">
                    <div class="form-group">
                        <input type="text" class="form-control" v-model="user.email" v-bind:class="{'is-invalid': invalidEmail}" placeholder="Email" required>
                        <div class="invalid-feedback">Invalid email.</div>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" v-model="user.password" v-bind:class="{'is-invalid': invalidPassword}" placeholder="Password" required>
                        <div class="invalid-feedback">Invalid password.</div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Пријави се</button>
            </div>
        </form>
    </div>
</div>
</template>

<script>
import AuthenticationService from '@/service/AuthenticationService.js';

export default {

    name: "LoginForm",

    data() {
        return {
            user: {
                email: "",
                password: "",
            },

            invalidEmail: false,
            invalidPassword: false,
        }
    },

    methods: {
        login() {
            this.resetInvalidStates();

            if (this.validate()) {
                AuthenticationService.login(this.user)
                .then(res => console.log(res.data))
                .catch(err => console.log(err))
            }
            return;
        },

        validate() {

            let form = document.getElementById("login-form");
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
            this.invalidPassword = false;

            let elements = document.querySelectorAll(".form-group input");
            elements.forEach(el => el.classList.remove("is-invalid"));
            let form = document.getElementById("login-form");
            form.classList.remove("was_validated");
        }
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