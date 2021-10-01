<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="header">Register</h1>
      <div class="inputs">
        <div class="user-info">
          <div>
            <label>username</label>
            <input
              type="text"
              id="username"
              class="form-control"
              autocomplete="off"
              v-model="user.username"
              required
              autofocus
            />
            <div id="user-err" v-show="usernameCheckPass !== true">
              {{ usernameMsg }}
            </div>
          </div>
          <div>
            <label>email</label>
            <input
              type="text"
              id="email"
              autocomplete="off"
              class="form-control"
              v-model="user.email"
              required
            />
            <div class="alert email" v-show="emailCheckPass !== true">
              {{ emailMsg }}
            </div>
          </div>
          <div>
            <label>password</label>
            <input
              type="password"
              id="password"
              class="form-control"
              v-model="user.password"
              required
            />
            <div id="pass-err" v-show="passwordCheckPass !== true"></div>
          </div>
          <div>
            <label>confirm password</label>
            <input
              type="password"
              id="confirmPassword"
              class="form-control"
              v-model="user.confirmPassword"
              required
            />
            <div id="conf-err" v-show="confirmCheckPass !== true">
              {{ confirmMsg }}
            </div>
          </div>
        </div>
        <div class="alert-response">
          <div class="alert alert-danger" role="alert">
            <!-- {{ registrationErrorMsg }} -->
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Sign Up
          </button>
        </div>
      </div>
      <span class="loginLink"
        >Already have an account?
        <router-link :to="{ name: 'login' }">Click here to log in</router-link>
      </span>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      userList: [],
      usernameMatch: true,
      emailMatch: true,
      matchCounter: 0,
      user: {
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "",
      usernameCheckPass: false,
      usernameMsg: "",
      emailCheckPass: true,
      emailMsg: "",
      passwordCheckPass: false,
      passwordMsg: "",
      confirmCheckPass: false,
      confirmMsg: "",
    };
  },
  methods: {
    // checkUsername(username) {
    //   for (let i = 0; i < this.userList.length; i++) {
    //     if (this.userList[i].username == username) {
    //       this.usernameMatch = true;
    //       this.usernameCheckPass = false;
    //       this.usernameMsg = "Username already exists";
    //       document.getElementById("user-err").classList.add("alert");
    //       break;
    //     }
    //     this.matchCounter++;
    //     console.log(this.matchCounter);
    //   }

    //   if (this.matchCounter >= this.userList.length) {
    //     this.matchCounter = 0;
    //     this.usernameMatch = false;
    //     this.usernameCheckPass = true;
    //     document.getElementById("user-err").classList.remove("alert");
    //   }
    // },
    register() {
      let passStr = this.user.password;
      if (
        passStr.match(/[A-Z]/g) &&
        passStr.match(/[0-9]/g) &&
        passStr.length >= 8
      ) {
        this.passwordCheckPass = true;
        document.getElementById("pass-err").classList.remove("alert");
      } else {
        this.passwordCheckPass = false;
        document.getElementById("pass-err").innerHTML =
          "Password needs at least:<ul><li>eight characters</li><li>one uppercase letter (A-Z)</li><li>one number (0-9)</li></ul>";
        document.getElementById("pass-err").classList.add("alert");
      }

      if (this.user.password !== this.user.confirmPassword) {
        this.confirmCheckPass = false;
        this.confirmMsg = "Password and Confirm Password do not match.";
        document.getElementById("conf-err").classList.add("alert");
      } else {
        this.confirmCheckPass = true;
        document.getElementById("conf-err").classList.remove("alert");
      }



      // Username Check



      // authService.getUserList(this.$route.params.id).then((response) => {
      //   this.userList = response.data;
      //   console.log(this.userList);

      //   for (let i = 0; i < this.userList.length; i++) {
      //     if (this.userList[i].username != this.user.username) {
      //       this.usernameMatch = false;
      //       this.matchCounter = 0;
      //       this.usernameCheckPass = true;
      //       console.log(this.userList[i].username + this.user.username);
      //       document.getElementById("user-err").classList.remove("alert");
      //     } else {
      //       this.matchCounter++;
      //       this.usernameMatch = true;
      //       this.usernameCheckPass = false;
      //       this.usernameMsg = "Username already exists";
      //       console.log(this.userList[i].username);
      //       document.getElementById("user-err").classList.add("alert");
      //     }
      //   }

        // if (this.matchCounter >= this.userList.length) {
        //   this.matchCounter = 0;
        //   this.usernameMatch = false;
        //   this.usernameCheckPass = true;
        //   document.getElementById("user-err").classList.remove("alert");
        // }
      // });

      // while ((this.usernameMatch === true)) {
      //   console.log(this.user.username)
      //   this.checkUsername(this.user.username);
      // }
      // while (this.usernameMatch === false) {
      //   for (let i = 0; i < this.userList.length; i++) {
      //     if (this.userList[i].username==this.user.username) {
      //       this.usernameMatch = true;
      //       this.usernameCheckPass = false;
      //       this.usernameMsg = "Username already exists";
      //       document.getElementById("user-err").classList.add("alert");
      //       break;
      //     }
      //     this.matchCounter++;
      //     console.log(this.matchCounter)
      //   }
      // }

      // if (this.matchCounter >= this.userList.length) {
      //   this.matchCounter=0;
      //   this.usernameMatch = false;
      //   this.usernameCheckPass = true;
      //   document.getElementById("user-err").classList.remove("alert");
      // }
      // .then((response) => {
      //   console.log(response)
      //   if (response.status == 200) {
      //       this.usernameMsg = "User already exists";
      //     document.getElementById("user-err").classList.add("alert");
      //   }
      // })
      // .catch((error) => {
      //     console.log(error.response)
      //   this.usernameCheckPass = true;
      //   document.getElementById("user-err").classList.remove("alert");
      // });

      if (
        // this.usernameCheckPass &&
        // this.emailCheckPass &&
        this.passwordCheckPass &&
        this.confirmCheckPass
      ) {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.usernameCheckPass = true;
            if (response.status === 400) {
              console.log("peace");
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "";
    },
  },
};
</script>

<style scoped>
.text-center {
  display: grid;
  height: 100vh;
  grid-template-columns: 1fr;
  grid-template-areas: "form";
  justify-items: center;
  align-items: center;
  background-color: #ffe9b3;
}

.form-register {
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
  height: 400px;
  max-width: 350px;
  justify-content: center;
}

.user-info {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  min-height: 250px;
}

.form-register input {
  height: 25px;
  min-width: 250px;
  font-size: 14px;
  border-radius: 4px;
  border: none;
}

.form-register input:focus {
  height: 23px;
  border: 1px solid #315c6d;
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

.loginLink {
  grid-area: loginLink;
  justify-self: center;
  font-size: 14px;
  height: 20px;
  padding: 10px;
}

.alert-response {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  width: 320px;
  height: 80px;
}

.header {
  grid-area: header;
  justify-self: center;
}

.alert {
  font-size: 12px;
  max-width: 250px;
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

label {
  display: flex;
  align-self: flex-start;
  color: white;
}

#pass-err {
  text-align: left;
  padding-left: 20px;
}

.alert {
  color: rgb(206, 0, 0);
  border: 1px solid red;
  box-shadow: 0 0 10px red;
  margin: 5px 0 0;
}
</style>
