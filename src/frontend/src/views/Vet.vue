<template>
  <v-data-table
      :headers="headers"
      :items="visits"
      class="elevation-13"
  >
  </v-data-table>
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
        { text: 'Tipo de visita', value: 'type' },
        { text: 'Descripcion de la visita', value: 'description' }
      ],
      visits: []
    }
  },
  created() {
    this.getVisits();
  },
  methods: {
    getVisits() {
      this.$http.get(visitUrl).then(response =>  this.visits = response.data)
    }
  }
}
</script>