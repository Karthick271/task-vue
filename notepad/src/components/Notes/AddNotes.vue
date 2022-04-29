<template>
  <div class="card" style="width: 30rem">
    <form class="container">
      <div class="mb-3">
        <h2 class="row">Add Notes</h2>
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input
          type="text"
          class="form-control"
          id="exampleInputEmail1"
          placeholder="Title ..."
          v-model="input.title"
        />
      </div>
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label"
          >Example textarea</label
        >
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
        ></textarea>
      </div>

      <div>
        <input type="file" @change="onFileSelected" />
      </div>
      <button type="button" class="btn btn-primary" v-on:click="upload()">
        Add Note
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "AddNotes",
  data() {
    return {
      title: "",
      note: "",
      selectedFile: null,
    };
  },
  methods: {
    onFileSelected(e) {
      console.log(e);
      this.selectedFile = e.target.files[0];
    },
    upload() {
      const fd = new FormData();
      fd.append("title", this.title);
      fd.append("note", this.note);
      fd.append("image", this.selectedFile);
      axios.post("url", fd).then((res) => {
        console.log("Rsponse" + res.data);
      });
    },
  },
};
</script>

<style scoped></style>
