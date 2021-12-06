<template>
  <v-app>
    <h1>Veterinario</h1>
    <v-data-table :headers="headers" :items="visitsReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Visitas</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
  </v-app>
</template>

<script>
const visitUrl = 'http://localhost:8080/api/visits';
export default {
  name: "Vet",
  data(){
    return {
      headers: [
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
      visits: [],
      editedItem: {
        visitId: 0,
        createdAt: '',
        type: '',
        description: ''
      }
    }
  },
  created() {
    this.getVisits();
  },
  methods: {
    getVisits() {
      this.$http.get(visitUrl).then(response =>  this.visits = response.data)
    }
  },
  computed: {
    visitsReform() {
      return this.visits;
    }
  }
}
</script>