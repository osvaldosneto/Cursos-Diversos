const express = require("express");
const bodyparser = require("body-parser")
const handlebars = require('express-handlebars');
const Sequelize = require('sequelize')

const app = express();

//configuracao
//template engine handlebars
app.engine('handlebars', handlebars({defaultLayout: 'main'}))
app.set('view engine', 'handlebars')

//configuração bodyparser
app.use(bodyparser.urlencoded({extended: false}))
app.use(bodyparser.json())

//conexão banco de dados mysql
const sequelize = new Sequelize('postagens', 'root', 'rafavedi23', {
    host: "localhost",
    dialect: "mysql"
})


//criação de rotas
app.get('/cad', function(req,res){
    //enviando página html a exibir no caso "formulario"
    res.render("formulario")
})

//rota metodo post
app.post('/add', function(req,res){
    //req.body.nome
    res.send("Titulo: "+req.body.titulo+" Conteudo: "+req.body.conteudo )
})

app.listen(9200, function(){
    console.log("Server rodando na url http://localhost:5000")
})