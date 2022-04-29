<template>
  <div
    class="card1 border shadow p-3 mb-5 bg-body rounded"
    style="
      background: linear-gradient(to right, #00001a, #00004d);
      height: 350px;
      margin: 10px 20px auto;
      padding: 10px 20px;
    "
  >
    <div class="row py-5">
      <div class="col-lg-12 text-white text-cent er">
        <h1>Note Pad Application</h1>
        <p class="lead mb-0">enter the notes</p>
        <!-- <a class="btn btn-primary" style="border-radius: 50px">Add Notes</a>
        <a class="btn btn-primary" style="border-radius: 50px"> View Notes</a> -->
        <router-link >Add notes</router-link>
         <router-link >View Notes</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
};
</script>

<style scoped></style>
