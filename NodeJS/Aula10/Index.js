var express = require("express")
var app = express() //variável app está recebendo a função express

//carregando página html
app.get("/", function(req, res){
    res.sendFile(__dirname + "/tabuada.html")
})

//criando mais rotas
app.get("/rota", function(req,res){
    res.send("rota aberta...")
})

//criando rota Ola com parâmetros :nome
app.get("/ola/:nome/:salario", function(req, res){
    res.send("<h1><p>Ola"+ req.params.nome+"</p></h1>"+"<p>Seu salário é:"+req.params.salario+"</p>")
    //res.send(req.params.nome)
    //res.send("Seu salário é:" + req.params.salario)
})

//abrindo o servidor
app.listen(8081, function(){
    console.log("servidor rodando na porta 8081...") //código da função
}) //escutando na porta 8081 sempre deve ser a última linha do código