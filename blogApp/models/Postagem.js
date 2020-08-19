var mongoose = require("mongoose")
var Schema = mongoose.Schema;

const Postagem = new Schema({
    titulo:{
        type: String,
        required: true
    },
    slug:{
        type: String,
        required: true
    },
    descricao:{
        type: String,
        required: true
    },
    conteudo:{
        type: String,
        required: true
    },
    categoria:{ //armazenando id da categoria tabela ja criada Aula 44
        type: Schema.Types.ObjectId,
        ref: "categorias", //objeto categorias, nome do model Categorias
        required: true
    },
    data:{
        type: Date,
        default: Date.now()
    }
});

mongoose.model('postagens', Postagem)