//carrregando módulos
const express = require('express')
const handlebars = require('express-handlebars')
const bodyparser = require('body-parser')
const mongoose = require('mongoose')
const app = express()
const session = require('express-session')
const flash = require('connect-flash')

//carregando módulo para carregar diretórios
const path = require('path')

//carregando classe admin com as rotas
const admin = require('./routes/admin')

//configurações
    //session 
    app.use(session({
        secret: "qualquercoisa",
        resave: true,
        saveUninitialized: true,
    }))
    app.use(flash())
    //midleware
    app.use(function(req, res, next){
        //criando variáveis globais
        res.locals.success_msg = req.flash("success_msg")
        res.locals.error_msg = req.flash("error_msg")
        next()
    })
    //bodyparser
    app.use(bodyparser.urlencoded({extended:true}))
    app.use(bodyparser.json())
    //handlebars
    app.engine('handlebars', handlebars({defaultLayout:'main'}))
    app.set('view engine', 'handlebars')
    //mongoose
    mongoose.Promise = global.Promise
    mongoose.connect("mongodb://localhost/blogapp").then(function(){
        console.log("conectado ao Mongo")
    }).catch(function(err){
        console.log("Erro ao conectar "+ err)
    })
    //public - informa que na pasta public esta todos os arquivos estáticos
    app.use(express.static(path.join(__dirname,"public")))

//rotass
//chamando a rota de ad que abre q página admin.js com os grupos de rotas
app.use('/admin', admin)

//ouros 
const PORTA = 9800
app.listen(PORTA, function(){
    console.log("Servidor rodando no endereço http://localhost:9800")
}) 