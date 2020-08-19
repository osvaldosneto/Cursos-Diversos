var http = require('http') //modulo que permite aplicações web

http.createServer(function(req, res){
    res.end("Hello World - Ola Mundo!!") //escrevendo mensagem, "somente res"
}).listen(5000) //createserver abrindo servidor
                                //listen escutando na porta 5000

console.log("Servidor Rodando...")
