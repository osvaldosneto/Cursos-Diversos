const express = require('express')
const router = express.Router()
const mongoose = require('mongoose')

//categorias.js copia o modelo json
require("../models/Categoria")//..volta um diretório
const Categoria = mongoose.model("categorias")

//definição rotas
//método get
router.get('/', function(req, res){
    res.render("admin/index") //admin/index é o caminho do arquivo a renderizar
    //res.send("Página principal do painel adm....")
})

//metodo post
router.post('/posts', function(req, res){
    res.send("Página de posts...")
})

//metodo get cadastro
router.get('/categorias', function(req, res){
    //res.send("Página de categorias")
    Categoria.find().sort({date:'desc'}).then(function (categorias){ //listando as caegorias
        res.render("admin/categorias", {categorias: categorias})
    }).catch(function(error){
        res.flash("error_msg", "Houve um erro ao listar categorias.")
        res.redirect("/admin")
        console.log('Erro na listagem de categorias')
    })
    
})

//rota de edição de categorias
router.post("/categorias/edit", function(req, res){
    //id vem do editcategorias.handlebars campo hiden
    Categoria.findOne({_id: req.body.id}).then(function(categoria){
        //editando categorias
        categoria.nome = req.body.nome
        categoria.slug = req.body.slug
        categoria.save().then(function(){
            req.flash("success_msg", "Categoria criada com sucesso!!") //mensagem
            console.log("Dado armazenado com sucesso.")
            res.redirect("/admin/categorias") //redirecionando a rota
        }).catch(function(error){
            res.flash("error_msg", "Houve um erro ao salvar edição da categorias.")
            res.redirect("/admin/categorias") //redirecionando a rota
        })


    }).catch(function(error){
        res.flash("error_msg", "Houve um erro ao editar categorias.")
    })

})

//rota para deletar posts Aula 43
router.post("/categorias/deletar", function(req, res){
    Categoria.remove({_id: req.body.id}).then(function(){
        req.flash("success_msg", "Categoria excluida com sucesso!!") //mensagem
        res.redirect("/admin/categorias")
    }).catch(function(error){
        req.flash("error_msg", "Houve um problema ao deletar categoria!!") //mensagem
        res.redirect("/admin/categorias")
    })
})

//rota de edição de categorias Aula 44
router.get("/categorias/edit/:id", function(req, res){
    //localizando catergorias
    //passado como parametro por isto param
    Categoria.findOne({_id:req.params.id}).then(function(categoria){
        res.render("admin/editcategorias", {categoria: categoria}) //enviando categorias
    }).catch(function(err){
        req.flash("error_msg", "Esta categoria não existe.")
        res.redirect("/admin/categorias")
    })
})

router.get('/categorias/add', function(req, res){
    res.render('admin/addcategorias')
})

router.post('/categorias/nova', function(req, res){
    //validando categorias
    var erros = []
    if(!req.body.nome || req.body.nome == undefined || req.body.nome==null){
        erros.push({texto: "Nome inválido"})
    }
    if(!req.body.slug || req.body.slug == undefined || req.body.slug==null){
        erros.push({texto: "Slug inválido"})
    }
    if(erros.length > 0){
        res.render('admin/addcategorias',{erros:erros})
    } else {
          //recebe os dados do formulário
        const novaCategoria = {
            nome: req.body.nome,
            slug: req.body.slug,
        }
        new Categoria(novaCategoria).save().then(function(){
            req.flash("success_msg", "Categoria criada com sucesso!!") //mensagem
            res.redirect("/admin/categorias") //redirecionando a rota
            console.log("Dado armazenado com sucesso.")
        }).catch(function(err){
            req.flash("error_msg", "Houve um erro ao salvar a categoria!!") //mensagem
            res.redirect("/admin")
            console.log("Erro ao armazenar...")
        })
    }
})

module.exports = router