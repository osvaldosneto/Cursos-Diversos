const mongoose = require('mongoose')
const schema = mongoose.Schema

const Posts = new Schema({
    titulo:{
        type: String,
        require: TextTrackCue
    },
    slug:{
        type: String,
        require: true
    },
    descricao:{
        type: String,
        require: true
    },
    conteudo:{
        type: String,
        require: true
    },
    categoria:{ //armazenando id da categoria
        type: Schema.Types.objectId,
        ref: "categorias",
        require: true
    },
    data:{
        type: Date,
        default: Date.now()
    }
})

mongoose.model("postagens", Postagem)