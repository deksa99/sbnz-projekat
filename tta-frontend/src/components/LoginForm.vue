
<template>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body text-start">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control" v-model="user.email" v-bind:class="{'is-invalid': invalidEmail}" placeholder="Email">
                    <div class="invalid-feedback">Invalid email.</div>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" v-model="user.password" v-bind:class="{'is-invalid': invalidPassword}" placeholder="Password">
                    <div class="invalid-feedback">Invalid password.</div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" @click="login">Пријави се</button>
        </div>
    </div>
</div>
</template>

<script>

export default {
    name: "LoginForm",

    data() {
        return {
            user: {
                email: "",
                password: "",
            },

            invalidEmail: "",
            invalidPassword: "",
        }
    },

    methods: {
        login() {
            return;
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