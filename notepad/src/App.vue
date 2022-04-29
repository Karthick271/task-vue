<template>
  <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  
  <Navbar/>
  <!-- <Home/>  -->
  <User/>

 <main class="container">
      
        <router-view></router-view>
  </main>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import Navbar from './components/NavbarHeader.vue';
// import Home from './components/HomePage.vue';
import User from './components/UserLogin.vue';
export default {
  name: 'App',
  components: {
     Navbar,
    // Home,
    User
  }
}
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
:root {
  --font: "Inter", sans-serif;
  --body-color: #637381;
  --heading-color: #212b36;
  --primary-color: #3056d3;
  --white: #ffffff;
}

/* body {
  font-family: var(--font);
  font-weight: normal;
  font-style: normal;
  color: var(--body-color);
  overflow-x: hidden;
  background-color: #3056d3;
} */

* {
  margin: 0;
  padding: 0;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

img {
  max-width: 100%;
}

a,
button,
input,
textarea {
  -webkit-transition: all 0.3s ease-out 0s;
  transition: all 0.3s ease-out 0s;
}

a,
a:focus,
input:focus,
textarea:focus,
button:focus,
.navbar-toggler:focus {
  text-decoration: none;
  outline: none;
  -webkit-box-shadow: none;
          box-shadow: none;
}

a:focus,
a:hover {
  text-decoration: none;
}

i,
span,
a {
  display: inline-block;
}

audio,
canvas,
iframe,
img,
svg,
video {
  vertical-align: middle;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  font-weight: 700;
  color: var(--heading-color);
  margin: 0px;
 
}

h1 {
  font-size: 48px;
}

h2 {
  font-size: 36px;
}

h3 {
  font-size: 28px;
}

h4 {
  font-size: 22px;
}

h5 {
  font-size: 18px;
}

h6 {
  font-size: 16px;
}

ul,
ol {
  margin: 0px;
  padding: 0px;
  list-style-type: none;
}

p {
  font-size: 16px;
  font-weight: 400;
  line-height: 26px;
  color: var(--body-color);
  margin: 0px;
}

.bg_cover {
  background-position: center center;
  background-size: cover;
  background-repeat: no-repeat;
  width: 100%;
  height: 100%;
}

/*===== All Button Style =====*/
.s-btn {
  display: inline-block;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  font-weight: 500;
  font-size: 16px;
  border-radius: 5px;
  padding: 15px 25px;
  border: 1px solid transparent;
  color: var(--white);
  cursor: pointer;
  z-index: 5;
  -webkit-transition: all 0.4s ease-out 0s;
  transition: all 0.4s ease-out 0s;
  background: var(--primary-color);
}

.s-btn:hover {
  color: var(--white);
  background: var(--heading-color);
}

</style>
