<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal header">Register</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="inputs">
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder=" Username"
          v-model="user.username"
          required
          autofocus
        />
        <input type="text"
        id="email"
        class="form-control"
        placeholder=" Email Address"
        v-model="user.email"
        required
        />
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder=" Password"
          v-model="user.password"
          required
        />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder=" Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Sign Up
        </button>
      </div>
      <span class="loginLink">Already have an account?
        <router-link :to="{ name: 'login' }">Click here to login</router-link>
      </span>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        email: "",
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      let passStr = this.user.password;

      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        //Validating that password contains at least 8 characters, 1 uppercase, and 1 number.
        if (passStr.match(/[A-Z]/g) && passStr.match(/[0-9]/g) && passStr.length >= 8) {
          authService
            .register(this.user)
            .then((response) => {
              if (response.status == 201) {
                this.$router.push({
                  path: '/login',
                  query: { registration: 'success' },
                });
              }
            })
            .catch((error) => {
              const response = error.response;
              this.registrationErrors = true;
              if (response.status === 400) {
                this.registrationErrorMsg = 'Error: User already exists.';
              } 
            });
        } else {
          this.registrationErrors = true;
          this.registrationErrorMsg = 'Password needs at least 8 characters, 1 uppercase letter, and 1 number.';
        }
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
  .text-center {
    display: grid;
    height: 90vh;
    grid-template-columns: 1fr;
    grid-template-areas: "form";
    justify-items: center;
    align-items: center;
  }

  .form-register {
    display: grid;
    grid-area: form;
    grid-template-columns: 1fr;
    grid-template-areas:
    "header"
    "inputs"
    "loginLink";
    width: 400px;
    height: 450px;
    background-color: greenyellow;
    border-radius: 10px;
  }

  .inputs {
    display: flex;
    grid-area: inputs;
    flex-direction: column;
    min-height: 350px;
    max-width: 400px;
    justify-content: space-around;
    align-items: center;
  }

  .form-register input {
    height: 30px;
    min-width: 350px;
    font-size: 18px;
  }

  .btn {
    height: 35px;
    width: 100px;
    font-weight: bold;
    font-size: 18px;
    border-radius: 15px;
    border: none;
  }

  .loginLink {
    grid-area: loginLink;
    justify-self: center;
  }

  .header {
    grid-area: header;
    justify-self: center;
  }

</style>
