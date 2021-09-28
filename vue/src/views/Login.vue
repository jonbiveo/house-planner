<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login" >
      <h1 class="header">Login</h1>
      <div class="inputs">
        <div class="user-info">
          <div id="username">
            <label>username</label>
            <input
              type="text"
              class="form-control"
              v-model="user.username"
              required
              autofocus
            />
          </div>
          <div id="password">
            <label>password</label>
            <input
              type="password"
              class="form-control"
              v-model="user.password"
              required
            />
          </div>
        </div>
        <div class="alert-response">
          <div
            class="alert alert-danger"
            role="alert"
            v-if="invalidCredentials"
          >
            Invalid username or password
          </div>
          <div
            class="alert alert-success"
            role="alert"
            v-if="this.$route.query.registration"
          >
            Thank you for registering<br />
            Please sign in
          </div>
          <br /><button class="btn" type="submit">Log In</button>
        </div>
      </div>
      <span class="registerLink"
        >Don't have an account?
        <router-link :to="{ name: 'register' }"
          >Click here to register</router-link
        >
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
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/plans");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.text-center {
  display: grid;
  height: 89vh;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
  background-color: #ffe9b3;
}

.form-signin {
  display: grid;
  grid-area: form;
  grid-template-columns: 1fr;
  grid-template-areas:
    "header"
    "inputs"
    "loginLink";
  width: 320px;
  height: auto;
  background-color: #e76f51;
  border-radius: 10px;
  padding: 10px;
  color: white;
  box-shadow: 5px 5px 5px #cc9b62;
}

.inputs {
  grid-area: inputs;
  display: flex;
  flex-wrap: wrap;
  min-height: 250px;
  max-width: 350px;
  justify-content: center;
}

.user-info {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  min-height: 100px;
  margin: 0 0 0 30px;
}

.form-signin input {
  height: 25px;
  min-width: 250px;
  font-size: 14px;
  border-radius: 4px;
  border: none;
}

.form-signin input:focus {
  height: 21px;
  border: 2px solid #315c6d;
  box-shadow: 0 0 10px #315c6d;
  outline: none;
}

.btn {
  height: 35px;
  width: 100px;
  font-size: 16px;
  border-radius: 15px;
  border: none;
  color: #264653;
  background-color: #e9c46a;
  font-weight: bold;
}

.registerLink {
  grid-area: loginLink;
  justify-self: center;
  font-size: 14px;
}

.alert-response {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 320px;
  height: 80px;
}

.header {
  grid-area: header;
  justify-self: center;
}

.alert {
  font-size: 14px;
  text-align: center;
}

a:link {
  color: #264653;
}
a:visited {
  color: #2a9d8f;
}
a:hover {
  color: #e9c46a;
}

.alert{
  color: rgb(206, 0, 0);
  border: 1px solid red  ;
  box-shadow: 0 0 10px red;
  padding:0 10px;
}

label{
  color: white;
}
</style>