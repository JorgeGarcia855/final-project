<template>
  <v-container data-app>
    <form>
      <div class="form-group">
        <v-combobox
            v-model="rolSelect"
            :items="rolItems"
            label="Rol"
        ></v-combobox>
      </div>
      <div class="form-group">
        <label >Nombre</label>
        <input
            type="text"
            v-model="name"
            class="form-control"
            placeholder="Nombre"
        />
      </div>
      <div class="form-group">
        <label >Usuario</label>
        <input
            type="text"
            v-model="username"
            class="form-control"
            placeholder="Nombre de usuario"
        />
      </div>
      <div v-show="enableAddress" class="form-group">
        <label >Dirección</label>
        <input
            type="text"
            v-model="address"
            class="form-control"
            placeholder="Dirección"
        />
      </div>
      <div v-show="enableAddress" class="form-group">
        <label >Localidad</label>
        <input
            type="text"
            v-model="neighborhood"
            class="form-control"
            placeholder="Localidad"
        />
      </div>
      <div class="form-group">
        <label >Email address</label>
        <input
            type="email"
            v-model="email"
            class="form-control"
            placeholder="Correo electronico"
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

      <button v-on:click="getuserAxios()" class="btn btn-primary">Submit</button>
    </form>
  </v-container>

</template>

<script>
export default {
  data() {
    return {
      rolSelect: { text: "Propietario", value: "Propietario" },
      rolItems: [
        { text: "Propietario", value: "Propietario" },
        { text: "Veterinario", value: "Veterinario" },
        { text: "Funcionario", value: "Funcionario" },
      ],
      username:"",
      email:"",
      password:"",
      name:"",
      address:"",
      locations: [
        "USAQUEN",
        "CHAPINERO",
        "SANTA FE",
        "SAN CRISTOBAL",
        "TUNJUELITO",
        "USME",
        "BOSA",
        "KENNEDY",
        "FONTIBON",
        "ENGATIVA",
        "SUBA",
        "B. LOS MARTIRES",
        "A. NARINO",
        "P. ARANDA",
        "R. URIBE",
        "C. BOLIVAR",
        "MUNICIPIOS ALEDATORIOS BOGOTA D.C.",
      ],
      neighborhood:"",
      users:[]
    };
  },
  methods:{
    getuserAxios(){
      let userapp={

      }
      fetch('http://localhost:8080/api/officials', {
        method: 'POST',
        body: JSON.stringify(userapp),
        headers: {
          'Content-type': 'application/json; charset=UTF-8'
        }
      })
      this.$router.push({ path: 'login' });

    }
  },
  computed:{
    enableAddress(){
      if(this.rolSelect.text==="Propietario" || this.rolSelect.text==="Veterinario"){
        return true
      }else return false
    }
  },
  created(){
    this.$http.get("http://localhost:8080/api/officials").then((result) => {
      console.log(result.data);
    })
  }



};
</script>