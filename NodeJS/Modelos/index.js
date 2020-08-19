const express = require('express')
const app = express()
const handlebars = require('express-handlebars')
const bodyParser = require('body-parser')

//constante post
const Post = require('./Post')

//configurações
//handlebars
app.engine('handlebars', handlebars({defaultLayout: 'main'}))
app.set('view engine', 'handlebars')
//bosyparser
app.use(bodyParser.urlencoded({extended: false}))
app.use(bodyParser.json())

//rota cadastro - metodo get
app.get('/cadastro', function(req, res){
    //mostrando html formulario.html
    res.render('formulario')
})

//rota adiciona - metodo post
app.post('/adiciona', function(req, res){
    Post.create({
        titulo: req.body.titulo,
        conteudo: req.body.conteudo
    }).then(function(){ //se postado com sucesso
        res.redirect('/postagens')//redirecionando para home
    }).catch(function(erro){ //se não postado com sucesso retorna erro
        res.send("Houve um erro "+ erro)
    })
})

//rota de direcionamento do método adiciona
app.get('/postagens', function(req, res){
   // Post.findAll().then(function(posts){ //função que lista os dados
   //     res.render('postagens', {post: posts}) //chamando a página html e enviando os posts
   // }) 

   //ordenando pela ordem decrescente pela chave 'titulo'
    //Post.findAll({order: [['titulo', 'DESC']]}).then(function(posts){ //função que lista os dados
    //    res.render('postagens', {post: posts}) //chamando a página html e enviando os posts
    //})

    //ordenando pela ordem decrescente pela chave 'id' ordem decrescente 'desc'ou 'asc' crescente
    Post.findAll({order: [['id', 'DESC']]}).then(function(posts){ //função que lista os dados
        res.render('postagens', {post: posts}) //chamando a página html e enviando os posts
    }) 
})

//rota de apagar postagens
app.get('/deletar/:id', function(req, res){
    //para deletar o post com a id acina
    Post.destroy({where:{'id':req.params.id}}).then(function(){
        res.send("Postagem apagada com sucesso!!!")
    }).catch(function(erro){
        res.send("Esta postagem não existe!!!")
    })
})

//fica ouvindo na porta 9550
app.listen(9550, function(){
    console.log("Servidor rodando na url http://localhost:9550")
})