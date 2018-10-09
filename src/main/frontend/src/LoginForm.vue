<template>
    <form>
        <label>Login</label>
        <input type="text" v-model="user.login">
        <label>Hasło</label>
        <input type="password" v-model="user.password">
        <button @click="meetingFormTurnOn()">{{ labelOfTheButton }}</button>
        <button @click="registerFormTurnOn()">{{ registerButton }}</button>
        <button @click="callRestService()">RestApiTest</button>
        <h3>{{ response }}</h3>
    </form>
</template>

<script>
    import axios from 'axios';

    export default {
        props:
            ["buttonLabel"],
        data() {
            return {
                user: {},
                isRegister: false,
                response: [],
                errors: []
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
            callRestService () {
                debugger;
                axios.get(`/api/hello`).then(response => {
                    debugger;
                    console.log(response.data);
                    // JSON responses are automatically parsed.
                    this.response = response.data
                })
                .catch(e => {
                    debugger;
                    console.log(e);
                    this.errors.push(e)
                })
            }
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
