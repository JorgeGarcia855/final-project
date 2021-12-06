<template>
  <v-app>
    <h1>Propietario</h1>
      <v-data-table
          :headers="headers"
          :items="petsReform"
          class="elevation-13"
      >
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Mascotas</v-toolbar-title>
          </v-toolbar>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                  color="primary"
                  dark
                  class="mb-2"
                  v-bind="attrs"
                  v-on="on"
              >
                Añadir Mascota
              </v-btn>
            </template>
            <v-card>
              <v-card-title>Añadir Mascota</v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.name" label="Nombre">

                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.microchip" label="Microchip">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.species" label="Especie">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.race" label="Raza">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.sex" label="Sexo">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="defaultPet.image" label="Image">
                      </v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text>
                  Cancelar
                </v-btn>
                <v-btn color="blue darken-1" text @click="postOwnerPet(defaultPet)">
                  Añadir
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog >
          <v-dialog v-model="dialogDelete" max-width="500px">
            <v-card>
              <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text >Cancel</v-btn>
                <v-btn color="blue darken-1" text >OK</v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <!--- edit card dialog --->
          <v-dialog v-model="editDialog" max-width="500px">
            <v-card>
              <v-card-title>Editar Mascota</v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.name" label="Nombre">

                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.species" label="Especie">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.race" label="Raza">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.sex" label="Sexo">
                      </v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.picture" label="Image">
                      </v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text >
                  Cancelar
                </v-btn>
                <v-btn color="blue darken-1" text @click="postEditOwnerPet(editedItem)">
                  Añadir
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </template>
        <template v-slot:item.actions="{ item }">
          <v-icon
              small
              class="mr-2"
              @click="editItem(item)"
          >
            mdi-pencil
          </v-icon>
          <v-icon
              small
              @click="deleteItem(item)"
          >
            mdi-delete
          </v-icon>
        </template>
        <template v-slot:no-data>
          <v-btn
              color="primary"
          >
            Reset
          </v-btn>
        </template>
      </v-data-table>
  </v-app>
</template>

<script>
const petUrl = 'http://localhost:8080/api/owners/owner1/pets';
export default {
  name: "Owner",
  data() {
    return {
      headers:[
        {
          text: 'Nombre',
          align: 'start',
          sortable: true,
          value: 'name',
        },
        { text: 'ID', value: 'petId' },
        { text: 'Microchip', value: 'microchip' },
        { text: 'Especie', value: 'species' },
        { text: 'Raza', value: 'race' },
        { text: 'Tamaño', value: 'size' },
        { text: 'Sexo', value: 'sex' },
        { text: 'Imagen', value: 'picture', sortable: false },
        { text: 'Acciones', value: 'actions', sortable: false },
      ],
      editDialog:false,
      dialog: false,
      showDialog:false,
      editedIndex: -1,
      dialogDelete: false,
      pets: [],
      editedItem: {
        petId:0,
        name: '',
        microchip: '',
        species:'',
        race: '',
        size: '',
        sex: '',
        image: ''
      },
      defaultPet: {
        name: '',
        microchip: '',
        species:'',
        race: '',
        size: '',
        sex: '',
        image: ''
      },
      editedPet: {}
    }
  },
  created() {
    this.getOwnerPets();
  },
  methods: {
    getOwnerPets() {
      this.$http.get(petUrl).then(response => this.pets = response.data);
    },
    postOwnerPet(pet){
      let bodyPost={
        name: pet.name,
        microchip:pet.microchip ,
        species:pet.species,
        race:pet.race ,
        size: pet.size,
        sex: pet.sex,
        picture:pet.image
      }
      this.$http.post(petUrl,bodyPost).then( response => {
        console.log(response)
        this.getOwnerPets()
      })
      this.dialog=false
    },
    editItem(item){
      this.editedIndex = this.pets.indexOf(item)
      this.editedItem={
        petId:this.pets[this.editedIndex].petId,
        name:item.name ,
        microchip: item.microchip,
        species:item.species,
        race:item.race ,
        size: item.size,
        sex: item.sex,
        image:item.image
      }
      this.editDialog=true
    },


    postEditOwnerPet(editedItem){
      let bodyPost={
        petId: editedItem.petId,
        name: editedItem.name,
        species: editedItem.species,
        race: editedItem.race,
        size: editedItem.size,
        sex:editedItem.sex ,
        picture:editedItem.image
      }
      this.$http.put(petUrl,bodyPost).then( (response)=> console.log(response))
      this.editDialog=false
    },
    // deleteItem(item){
    //
    // }
  },
  computed: {
    petsReform(){
      return this.pets
    }
  }
}
</script>
