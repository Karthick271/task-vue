<template>
  <div class="card" style="width: 30rem;">
    <form class="container">
      <div class="mb-3">
        <h2 class="row ">   Login</h2>
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input
          type="email"
          class="form-control"
          id="exampleInputEmail1"
          placeholder="Email ..."
          aria-describedby="emailHelp"
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
          placeholder="password ..."
          id="exampleInputPassword1"
          v-model="input.password"
        />
      </div>
       
      <button type="button" class="btn btn-primary" v-on:click="login()">
        Submit
      </button>
    </form>
  </div>
</template>

<script>
 
import axios from 'axios'
 
export default {
  name: "UserLogin",
  data() {
    return {
      input: {
        email: "",
        password: "",
      },
    };
  },

  methods: {
    login() {
    //   console.log("Form value" + this.input.email);
    axios.post('url',{
        email : this.input.email,
        password : this.input.password
    }).then((res) =>{
      console.log(res.data)  
      if(res.data==="login-scuessful"){
          localStorage.setItem("status","true")
      }
    });
    },
  },
};
</script>

<style scoped>
* {
  margin: 10px auto;
  /* padding: 0.5rem; */
}
</style>
