<template>
  <v-app>
    <v-data-table :headers="petCaseHeaders" :items="petCasesReform" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Casos</v-toolbar-title>
        </v-toolbar>
      </template>
    </v-data-table>
  </v-app>
</template>

<script>
const petCaseUrl = 'http://localhost:8080/api/petCases';
export default {
  name: "PetCase",
  data() {
    return {
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
      petCases:[]
    };
  },
  created() {
    this.getPetCases()
  },
  methods:{
    getPetCases() {
      this.$http.get(petCaseUrl).then(response => this.petCases = response.data);
    }
  },
  computed:{
    petCasesReform() {
      return this.petCases;
    }
  }
}
</script>

<style scoped>

</style>