<template>
    <form>
        <label>Login</label>
        <input type="text" v-model="user.login">
        <label>Hasło</label>
        <input type="password" v-model="user.password">
        <button @click="meetingFormTurnOn()">{{ labelOfTheButton }}</button>
        <button @click="registerFormTurnOn()">{{ registerButton }}</button>
    </form>
</template>

<script>
    export default {
        props:
            ["buttonLabel"],
        data() {
            return {
                user: {},
                isRegister: false,
            };
        },
        methods: {
            meetingFormTurnOn() {
                debugger;
                console.log(this.user);
                console.log(this.isRegister);
                this.loginFormEvent(this.user, this.isRegister);
            },
            registerFormTurnOn() {
                debugger;
                this.isRegister = true;
                this.loginFormEvent(this.user, this.isRegister);
            },
            loginFormEvent(userToEvent, isRegisterToEvent) {
                console.log(userToEvent);
                console.log(isRegisterToEvent);
                this.$emit("login", userToEvent, isRegisterToEvent);
            },

        },
        computed: {
            labelOfTheButton() {
                return this.buttonLabel || 'Zaloguj się';
            },
            registerButton() {
                return this.buttonLabel || 'Rejestracja';
            },
        }
    };
</script>
