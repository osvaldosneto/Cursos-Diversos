const express = require('express')
const router = express.Router()
const mongoose = require('mongoose')

//categorias.js copia o modelo json
require("../models/Categoria")//..volta um diretório
require("../models/Postagem")
const Categoria = mongoose.model("categorias")
const Postagem = mongoose.model("postagens")

//carregando helper que vai liberar admin a mexer nas postagens
const {eadmin} = require("../helpers/eadmin") //Aula60

//definição rotas
//método get
//eadmin só libera se estiver logado
router.get('/', eadmin, function(req, res){
    res.render("admin/index") //admin/index é o caminho do arquivo a renderizar
    //res.send("Página principal do painel adm....")
})

//metodo get cadastro
router.get('/categorias', eadmin, function(req, res){
    //res.send("Página de categorias")
    Categoria.find().sort({date:'desc'}).then(function (categorias){ //listando as caegorias
        res.render("admin/categorias", {categorias: categorias})
    }).catch(function(error){
        req.flash("error_msg", "Houve um erro ao listar categorias.")
        res.redirect("/admin")
        console.log('Erro na listagem de categorias')
    })
})

//rota de edição de categorias
router.post("/categorias/edit", eadmin, function(req, res){
    //id vem do editcategorias.handlebars campo hiden
    Categoria.findOne({_id: req.body.id}).then(function(categoria){
        //editando categorias
        categoria.nome = req.body.nome
        categoria.slug = req.body.slug
        categoria.save().then(function(){
            req.flash("success_msg", "Categoria criada com sucesso!!") //mensagem
            console.log("Dado armazenado com sucesso.")
            res.redirect("/admin/categorias") //redirecionando a rota
        }).catch(function(err){
            req.flash("error_msg", "Houve um erro ao salvar edição da categorias.")
            res.redirect("/admin/categorias") //redirecionando a rota
        })
    }).catch(function(error){
        req.flash("error_msg", "Houve um erro ao editar categorias.")
    })
})

//rota para deletar posts Aula 43
router.post("/categorias/deletar", eadmin, function(req, res){
    Categoria.remove({_id: req.body.id}).then(function(){
        req.flash("success_msg", "Categoria excluida com sucesso!!") //mensagem
        res.redirect("/admin/categorias")
    }).catch(function(err){
        req.flash("error_msg", "Houve um problema ao deletar categoria!!") //mensagem
        res.redirect("/admin/categorias")
    })
})

//rota de edição de categorias Aula 44
router.get("/categorias/edit/:id", eadmin, function(req, res){
    //localizando catergorias
    //passado como parametro por isto param
    Categoria.findOne({_id:req.params.id}).then(function(categoria){
        res.render("admin/editcategorias", {categoria: categoria}) //enviando categorias
    }).catch(function(err){
        req.flash("error_msg", "Esta categoria não existe.")
        res.redirect("/admin/categorias")
    })
})

router.get('/categorias/add', eadmin, function(req, res){
    res.render('admin/addcategorias')
})

router.post('/categorias/nova', eadmin, function(req, res){
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

router.get("/postagens", eadmin, function(req, res){
    //enviando informação de uma tabela x com a tabela y categorias vem do model que é exportado Aula 47
    Postagem.find().populate("categoria").sort({data:"desc"}).then(function(postagens){
        res.render("admin/postagens", {postagens:postagens})
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro ao carregar as postagens")
        res.redirect("/admin")
    })
})  

router.get("/postagens/add", eadmin, function(req, res){
    //enviando categorias para listagem
    Categoria.find().then(function(categorias){
        res.render("admin/addpostagem", {categorias: categorias})
    }).catch(function(err){
        req.flash("error_msg", "Houve um erro ao carregar o formulário")
        res.redirect("/admin")
    })
})

router.post("/postagens/nova", eadmin, function(req, res){
    //sem validação
    var erros = []
    //verificando se categoria foi modificada
    if(req.body.categoria == "0"){
        erros.push({texto: "Categoria inválida, registre uma categoria"})
    }
    if(erros.length > 0){
        res.render('admin/postagens',{erros:erros})
    } else {
        const novaPostagem = {
            titulo: req.body.titulo,
            descricao: req.body.descricao,
            conteudo: req.body.conteudo,
            categoria: req.body.categoria,
            slug: req.body.slug
        }
        new Postagem(novaPostagem).save().then(function(){
            req.flash("success_msg", "Postagem criada com sucesso!")
            res.redirect("/admin/postagens")
        }).catch(function(err){
            req.flash("error_msg", "Houve um erro no salvamento da postagem")
            res.redirect("/admin")
        })
    }
})

//rota de edição de postagens
router.get("/postagens/edit/:id", eadmin, function(req, res){
    //localizando catergorias
    //passado como parametro o id
    Postagem.findOne({_id:req.params.id}).then(function(postagem){      
        // res.render("admin/editpostagem", {categorias: categorias, postagem: postagem}) //enviando categorias e postagens para edit postagens
        res.render("admin/editpostagem", {postagem: postagem}) //enviando categorias
    }).catch(function(err){
        req.flash("error_msg", "Esta postagem não existe.")
        res.redirect("/admin/postagens")
    })
})

//fazendo por conta - metodo deletar postagens
router.post("/postagens/deletar", eadmin, function(req, res){
    Postagem.remove({_id: req.body.id}).then(function(){
        req.flash("success_msg", "Postagem excluida com sucesso!!") //mensagem
        res.redirect("/admin/postagens")
    }).catch(function(err){
        req.flash("error_msg", "Houve um problema ao deletar categoria!!") //mensagem
        res.redirect("/admin/postagens")
    })
})

//edição de postagens
router.post("/postagem/edit", eadmin, function(req, res){
      //id vem do editpostagem.handlebars campo hiden
    Postagem.findOne({_id: req.body.id}).then(function(postagem){
        postagem.titulo = req.body.titulo,
        postagem.conteudo = req.body.conteudo,
        postagem.descricao = req.body.descricao,
        postagem.slug = req.body.slug,
        postagem.save().then(function(){
            req.flash("success_msg", "Postagem editada com sucesso!!") //mensagem
            console.log("Dado editado com sucesso.")
            res.redirect("/admin/postagens") //redirecionando a rota
        }).catch(function(err){
            req.flash("error_msg", "Houve um erro ao salvar edição da postagem.")
            res.redirect("/admin/postagens") //redirecionando a rota
        })
    }).catch(function(error){
        req.flash("error_msg", "Houve um erro ao editar postagem.")
    })
})

module.exports = router