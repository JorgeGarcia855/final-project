<template>
  <v-container data-app>
    <form>
      <div class="form-group">
        <label >Usuario</label>
        <input
            type="text"
            v-model="username"
            class="form-control"
            placeholder="Nombre de usuario"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input
            type="password"
            v-model="password"
            class="form-control"
            placeholder="Contraseña"
        />
      </div>

      <button v-on:click="getuserAxios()" class="btn btn-primary">Login</button>
      <router-link to="/owner">Owner</router-link>
      <router-link to="/vet">Vet</router-link>
      <router-link to="/official">Official</router-link>
      <router-link to="/petCase">Pet Case</router-link>
    </form>
  </v-container>

</template>

<script>
export default {
  data() {
    return {
      username:"",
      password:"",
    };
  },
  methods:{

  },
  computed:{

  },


};
</script>
