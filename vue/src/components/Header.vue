<template>
    <div>
        <router-link v-bind:to="{ name: 'details' }" v-if="pageURL === '/plan-builder'">Back</router-link>
        <router-link v-bind:to="{ name: 'landing' }" 
        v-if="pageURL === '/details' || pageURL === '/plan-builder'">Landing</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
</template>

<script>
export default {
    data() {
        return {
            currentPage: ""
        }
    },
    computed: {
        pageURL() {
            console.log(this.$route.fullPath);
            return this.$route.fullPath;
        }
    }
}
</script>

<style>

</style>