<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="header h3 mb-3 font-weight-normal">Login</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder=" Password"
          v-model="user.password"
          required
        />
        <button class="btn" type="submit">Sign in</button>
      </div>
      <span class="registerLink">Don't have an account? 
      <router-link :to="{ name: 'register' }">Click here to register</router-link>
      </span>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
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

    .form-signin {
    display: grid;
    grid-area: form;
    grid-template-columns: 1fr;
    grid-template-areas:
    "header"
    "inputs"
    "loginLink";
    width: 400px;
    height: 340px;
    background-color: #F07167;
    border-radius: 10px;
    padding: 10px;
  }

    .inputs {
    display: flex;
    grid-area: inputs;
    flex-direction: column;
    min-height: 220px;
    max-width: 400px;
    justify-content: space-around;
    align-items: center;
  }

    .form-signin input {
    height: 30px;
    min-width: 350px;
    font-size: 18px;
    border-radius: 4px;
    border: 3px solid #0081A7;
  }

    .btn {
    height: 35px;
    width: 100px;
    font-weight: bold;
    font-size: 18px;
    border-radius: 15px;
    border: none;
  }

   .registerLink {
    grid-area: loginLink;
    justify-self: center;
  }

    .header {
    grid-area: header;
    justify-self: center;
  }
</style>