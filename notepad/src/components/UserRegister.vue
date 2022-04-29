<template>
  <div>
    <form class="container">
      <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input
          type="email"
          class="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
          placeholder="Email ..."
          v-model="input.email"
        />
        <div id="emailHelp" class="form-text">
          We'll never share your email with anyone else.
        </div>
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input
          type="password"
          class="form-control"
          id="exampleInputPassword1"
          placeholder="Password ..."
          v-model="input.password"
        />
      </div>
       <div class="mb-3">
        <label for="exampleInputPassword2" class="form-label">Password</label>
        <input
          type="password"
          class="form-control"
          id="exampleInputPassword2"
          placeholder="Confirm Password ..."
          v-model="input.confirmPassword"
        />
      </div>
      <button type="button" class="btn btn-primary" v-on:click="onSubmit()">
        Submit
      </button>
    </form>
  </div>
</template>

<script>

import axios from 'axios'
export default {
  name: "UserRegister",
  data() {
    return {
      input: {
        email: "",
        password: "",
        confirmPassword: "",
      },
    };
  },

  methods: {
    onSubmit() {
      console.log("Email :" + this.input.email)
      const fd = new FormData()
      axios.post('url',fd).then( (res) => {
          console.log("response is:" + res)
      });
    },
  },
};
</script>

<style scoped></style>
