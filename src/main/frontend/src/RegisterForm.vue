<template>
  <form @submit.prevent="enter()">
    <label>Twój login</label>
    <input type="text" v-model="user.login">
    <label>Unikatowe hasło</label>
    <input type="password" v-model="user.password">
    <label>Adres e-mail</label>
    <input type="e-mail" v-model="user.password">
    </br>
    </br>
    <button type="register">{{ registerButtonLabel }}</button>
    <button @click="backToAppForm(registerFormTurnOff)">{{ backToAppFormLabel }}</button>
  </form>
</template>

<script>
    export default {
        props: ["buttonLabel1", "buttonLabel2"],
        data() {
            return {
                user: {},
                registerFormTurnOff: false,
            };
        },
        methods: {
            backToAppForm(registerFormTurnOff) {
                registerFormTurnOff = false;
                this.$emit('backToAppForm', this.registerFormTurnOff);
                console.log("1");
            }
        },
        computed: {
            backToAppFormLabel() {
                return this.buttonLabel1 || 'Wróć';
            },
            registerButtonLabel() {
                return this.buttonLabel2 || 'Zarejestruj dane';
            }
        }
    };
</script>
