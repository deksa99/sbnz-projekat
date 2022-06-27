
<template>
<div class="modal-dialog">
    <div class="modal-content">
        <form id="login-form" @submit.prevent="login">
            <div class="modal-body text-start">
                    <div class="form-group">
                        <input type="text" class="form-control" v-model="user.username" v-bind:class="{'is-invalid': invalidEmail}" placeholder="Email" required>
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
import { mapState } from "vuex";
import AuthenticationService from "@/service/AuthenticationService.js";

export default {
    name: "LoginForm",

    computed: {
        ...mapState([
            'store',
        ])
    },

    data() {
        return {
            user: {
                username: "",
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
                .then(response => {
                    console.log(response.data);
                    localStorage.setItem('token', JSON.stringify(response.data.jwt));
                    this.$store.commit('SET_AUTHORIZED_USER', response.data.user); 
                })
            }
            return;
        },

        validate() {

            let form = document.getElementById("login-form");
            form.classList.add("was_validated");
            if (!form.checkValidity())
                return false;

            if (!this.user.username.match('^(.+)@(.+)$')) {
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