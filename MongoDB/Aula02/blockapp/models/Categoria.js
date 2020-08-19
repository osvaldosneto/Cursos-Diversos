//criando banco de dados

var mongoose = require("mongoose")
var Schema = mongoose.Schema;

var Categoria = new Schema({
    nome:{
        type: String,
        required:true
    },
    slug:{
        type: String,
        required:true
    },
    date:{
        type: Date,
        default: Date.now() //cadastra a data em que o usuário registrou automaticamente
    }
});

mongoose.model('categorias', Categoria)