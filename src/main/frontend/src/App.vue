<template>
  <div id="app">
    <h1>
      <img src="./assets/logo.svg" alt="Enroller" class="logo">
      System do zapisów na zajęcia
    </h1>
    <div v-if="authenticatedUsername">
      <h2>Witaj {{ authenticatedUsername }}!
        <a @click="logout()" class="float-right  button-outline button">Wyloguj</a>
      </h2>
      <meetings-page :username="authenticatedUsername"></meetings-page>
    </div>
    <div v-else>
        <div v-if="isRegisterForm">
            <login-form @login="login"></login-form>
        </div>
        <div v-else>
            <register-form @backToAppForm="registerFormTurnOff()"></register-form>
        </div>
    </div>
  </div>
</template>

<script>
    import "milligram";
    import LoginForm from "./LoginForm";
    import RegisterForm from "./RegisterForm";
    import MeetingsPage from "./meetings/MeetingsPage";

    export default {
        components: {LoginForm, RegisterForm, MeetingsPage},
        data() {
            return {
                authenticatedUsername: "",
                isRegisterForm: true,
            };
        },
        methods: {
            login: function(userFromEvent, isRegisterFromEvent) {
                debugger;
                console.log(userFromEvent);
                console.log(isRegisterFromEvent);
                this.isRegisterForm = isRegisterFromEvent;
                this.authenticatedUsername = userFromEvent.login;
            },
            logout() {
                this.authenticatedUsername = '';
            },
        },
    };
</script>

<style>
  #app {
    max-width: 1000px;
    margin: 0 auto;
  }

  .logo {
    vertical-align: middle;
  }
</style>

