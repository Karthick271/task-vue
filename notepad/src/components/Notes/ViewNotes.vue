<template>
    <div class="flex">
        <div v-for="item in items" > 
            <h2> {{item.title}} </h2>
            <p>{{item.notes}}</p>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name : 'ViewNotes',
        data(){
             return {
                 items : "" 
             }
        },
        mounted(){
          axios.get().then((res) => {
              this.items = res
          })  ;
        }
    }
</script>

<style scoped>

</style>