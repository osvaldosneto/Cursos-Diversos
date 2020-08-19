const mongoose = require("mongoose")

//conectando e criando o bando de dados "bancodededados"
mongoose.Promise = global.Promise
mongoose.connect("mongodb://localhost/bancodedados", {useMongoClient: true}).
then(function(){ //teste para conectar no mongo
    console.log("Mongo DB conectado com sucesso...")
}).catch(function(err){
    console.log("Não conectado ao banco de dados, erro "+ err)
});

//Definindo o model Usuários com nome, sobrenome e pais
const usuariosSchema = mongoose.Schema({
    nome:{
        type: String,
        require: true //ver ser o campo será obrigatório true para sim e false para não
    },
    sobrenome:{
        type: String,
        require: true
    },
    email:{
        type: String,
        require: true
    },
    idade:{
        type: Number,
        require: true
    },
    pais:{
        type: String,
        require: false
    }
})

//definindo a colection que irá armazenar no mongo
mongoose.model('Tabelausuarios', usuariosSchema)

//criando novo usuário
const novoUsuario = mongoose.model('tabelausuarios', usuariosSchema)
new novoUsuario({
    nome: "Osvaldo",
    sobrenome: "da Silva Neto",
    email: "osvaldosneto@mail.com",
    idade: 32,
    pais: "Brasil"
}).save() //salvando o usuário
.then(function(){
    console.log("Usuário criado com sucesso!!!")
}).catch(function(err){
    console.log("Houver um erro ao registrar...")
})

new novoUsuario({
    nome: "pedro",
    sobrenome: "da Silva Neto",
    email: "osneto@mail.com",
    idade: 32,
    pais: "Brasil"
}).save() //salvando o usuário
.then(function(){
    console.log("Usuário criado com sucesso!!!")
}).catch(function(err){
    console.log("Houver um erro ao registrar...")
})