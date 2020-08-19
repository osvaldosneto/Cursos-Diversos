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

//carregando classe admin e usuarios com as rotas
const admin = require('./routes/admin')
const usuarios = require("./routes/usuario")

//carregando modulos de postagens
require('./models/Postagem')
const Postagem = mongoose.model('postagens')
require("./models/Categoria")
const Categoria = mongoose.model("categorias")

//carreegando modulo de login
const passport = require("passport")
require("./autenticacao/auth")(passport)

//configurações
    //session 
    app.use(session({
        secret: "qualquercoisa",
        resave: true,
        saveUninitialized: true,
    }))

    //deve ser neste ordem, session, passport e depois flash
    app.use(passport.initialize())
    app.use(passport.session())

    app.use(flash())
    //midleware
    app.use(function(req, res, next){
        //criando variáveis globais
        res.locals.success_msg = req.flash("success_msg")
        res.locals.error_msg = req.flash("error_msg")
        res.locals.error = req.flash("error")
        res.locals.user = req.user || null; //autenticação de usuários Aula 60
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
    mongoose.connect("mongodb://blogapp:rafavedi23@cluster0-shard-00-00-icgkg.mongodb.net:27017,cluster0-shard-00-01-icgkg.mongodb.net:27017,cluster0-shard-00-02-icgkg.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority", { useNewUrlParser: true, useUnifiedTopology: true }).then(function(){
    

        console.log("conectado ao Mongo")
    }).catch(function(err){
        console.log("Erro ao conectar "+ err)
    })
    //public - informa que na pasta public esta todos os arquivos estáticos
    app.use(express.static(path.join(__dirname,"public")))

//rotass
app.get('/', function(req, res){
    Postagem.find().populate("categoria").sort({data: "desc"}).then(function(postagens){
        res.render("index", {postagens: postagens})
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro!!")
        res.redirect("/404")
    })   
})

app.get('/posts', function(req, res){
    res.send("Lista de posts")
})

//Aula 51
app.get("/postagem/:slug", function(req,res){
    Postagem.findOne({slug: req.params.slug}).then(function(postagem){
        if(postagem){
            res.render("postagem/index", {postagem: postagem})
        } else{
            req.flash("error_msg", "Essa postagem não existe")
        }
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro interno.")
        res.redirect("/")
    })
})

//chamando a rota de ad que abre q página admin.js com os grupos de rotas
app.use('/admin', admin)
app.use('/usuarios', usuarios)

//categorias aula52
app.get("/categorias", function(req, res){
    Categoria.find().then(function(categorias){
        res.render("categorias/index", {categorias: categorias})
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro interno ao listar as categorias.")
        res.redirect("/")
    })
})

app.get("/categorias/:slug", function(req, res){
    Categoria.findOne({slug: req.params.slug}).then(function(categoria){
        if(categoria){
            //iniciando outra busca dos posts da categoria
            Postagem.find({categoria: categoria._id}).then(function(postagens){
                res.render("categorias/postagens", {postagens: postagens, categoria: categoria})
            }).catch(function(err){
                req.flash("error_msg", "Houve um erro interno ao listar as categoria.")
                res.redirect("/")
            })
        }else{
            req.flash("error_msg", "Houve um erro interno.")
            res.redirect("/")
        }
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro interno ao listar as categoria.")
        res.redirect("/")
    })
})

//ouros 
//const PORTA = 8081

//configuração heroku
const PORT = process.env.PORT || 8089
app.listen(PORT, function(){
    console.log("Servidor rodando no endereço http://localhost:8081")
}) 