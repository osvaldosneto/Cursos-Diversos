const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Usuario = new Schema({
    nome:{
        type:String,
        required: true,
    },
    email:{
        type:String,
        required: true,
    },
    admin:{ //variável que verifica se ele é admin
        type:Number,
        default: 0
    },
    senha:{
        type:String,
        required:true,
    }
})
mongoose.model("usuario", Usuario)