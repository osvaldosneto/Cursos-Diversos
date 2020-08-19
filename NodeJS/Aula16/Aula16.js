const Sequelize = require('sequelize')
const sequelize = new Sequelize('sistemaDeCadastro','root','rafavedi23',{
    host:"localhost",
    dialect:'mysql'
})

sequelize.authenticate().then(function() {
    console.log('Conectado com sucesso')
}).catch(function (erro) {
    console.log('Falha ao conectar: '+erro)
})
/*
//criando model postagem uma -- nova tabela
const Postagem = sequelize.define('postagem', {
    titulo: {
        type: Sequelize.STRING
    },
    Conteudo: {
        type: Sequelize.TEXT
    }
})

//inserindo dados na tabela
Postagem.create({
    titulo: "Um titulo",
    Conteudo: "Conteudo de um livro qualquer"
})*/

const Cadastros = sequelize.define('cadastro',{
    nome: {
        type: Sequelize.STRING
    },
    sobrenome:{
        type: Sequelize.STRING
    },
    idade:{
        type: Sequelize.INTEGER
    },
})

Cadastros.create({
    nome: "Osvaldo",
    sobrenome:"da Silva Neto",
    idade: 37,
})

Cadastros.create({
    nome: "Rafa",
    sobrenome:"da Silva",
    idade: 27,
})