var express = require("express")
var app = express()
const Sequelize = require('sequelize')
const hadlebars = require("express-handlebars")

//config handlebars
    //template engine
    //app.engine('handlebars', handlebars({defaultLayout: 'main'}))
    app.set('view engine', 'handlebars')

    //conexão banco de dados mysql

    
    const sequelize = new Sequelize('Aula19', 'root', 'refevedi23', {
        host: "localhost",
        dialect: "mysql"
    })

app.listen(8081, function(){
    console.log("servidor no ar")
})