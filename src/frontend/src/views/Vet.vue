<template>
  <v-app>
    <v-data-table :headers="headers" :items="visitsReform" class="elevation-1">

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