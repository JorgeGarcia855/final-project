<template>
  <v-app>
    <v-data-table :headers="ownerHeaders" :items="ownerReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Propietarios</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
    <hr/><hr/>
    <v-data-table :headers="vetHeaders" :items="vetReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Veterinarios</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
    <hr/><hr/>
    <v-data-table :headers="petHeaders" :items="petsReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Mascotas</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
    <hr/><hr/>
    <v-data-table :headers="petCaseHeaders" :items="petCasesReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Casos</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
    <hr/><hr/>
    <v-data-table :headers="visitHeaders" :items="visitsReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Visitas</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
  </v-app>
</template>

<script>
const ownerUrl = 'http://localhost:8080/api/owners';
const vetUrl = 'http://localhost:8080/api/vets';
const visitUrl = 'http://localhost:8080/api/visits';
const petUrl = 'http://localhost:8080/api/pets';
const petCaseUrl = 'http://localhost:8080/api/petCases';

export default {
  name: "Official",
  data() {
    return {
      ownerHeaders: [
        {
          text: 'ID',
          align: 'start',
          sortable: true,
          value: 'personId'
        },
        { text: 'Nombre de usuario', value: 'username' },
        { text: 'Nombre', value: 'name' },
        { text: 'Direccion', value: 'address' },
        { text: 'Localidad', value: 'neighborhood' }
      ],
      owners: [],
      vetHeaders: [
        {
          text: 'Nombre de Usuario',
          align: 'start',
          sortable: true,
          value: 'username',
        },
        { text: 'Nombre', value: 'name' },
        { text: 'Direccion', value: 'address' },
        { text: 'Localidad', value: 'neighborhood' }
      ],
      vets: [],
      petHeaders:[
        {
          text: 'Nombre',
          align: 'start',
          sortable: true,
          value: 'name',
        },
        { text: 'ID', value: 'petId' },
        { text: 'ID del Propietario', value: 'ownerId' },
        { text: 'Microchip', value: 'microchip' },
        { text: 'Especie', value: 'species' },
        { text: 'Raza', value: 'race' },
        { text: 'Tamaño', value: 'size' },
        { text: 'Sexo', value: 'sex' },
        { text: 'Imagen', value: 'picture', sortable: false },
        { text: 'Acciones', value: 'actions', sortable: false },
      ],
      pets: [],
      petCaseHeaders:[
        {
          text: 'ID',
          align: 'start',
          sortable: true,
          value: 'caseId'
        },
        { text: 'ID Mascota', value: 'petId' },
        { text: 'Fecha del Case', value: 'createdAt' },
        { text: 'Tipo de caso', value: 'type' },
        { text: 'Descripcion del caso', value: 'description' }
      ],
      petCases:[],
      visitHeaders: [
        {
          text: 'Fecha de visita',
          align: 'start',
          sortable: true,
          value: 'createdAt',
        },
        { text: 'ID', value: 'visitId' },
        { text: 'Tipo de visita', value: 'type' },
        { text: 'Descripcion de la visita', value: 'description' }
      ],
      visits: []
    }
  },
  created() {
    this.getOwners()
    this.getVets()
    this.getVisits()
    this.getPets()
    this.getPetCases()
  },
  methods: {
    getOwners() {
      this.$http.get(ownerUrl).then(response => this.owners = response.data);
    },
    getVets() {
      this.$http.get(vetUrl).then(response => this.vets = response.data);
    },
    getVisits() {
      this.$http.get(visitUrl).then(response =>  this.visits = response.data)
    },
    getPets() {
      this.$http.get(petUrl).then(response => this.pets = response.data);
    },
    getPetCases() {
      this.$http.get(petCaseUrl).then(response => this.petCases = response.data);
    }
  },
  computed: {
    ownerReform(){
      return this.owners;
    },
    vetReform(){
      return this.vets;
    },
    visitsReform() {
      return this.visits;
    },
    petsReform() {
      return this.pets;
    },
    petCasesReform() {
      return this.petCases;
    }
  }
}
</script>

<style scoped>

</style>