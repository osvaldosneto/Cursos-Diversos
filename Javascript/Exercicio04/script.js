function contar(){
    var inicio = Number(window.document.getElementById("inicio").value)
    var fim = Number(window.document.getElementById("fim").value)
    var passo = Number(window.document.getElementById("passo").value)
    if(inicio <= 0 || passo <= 0 || fim <= 0){
        alert("Verifique os dados!!!")
    }else {
        var resposta = window.document.getElementById("div3")
        resposta.innerHTML = ""
        let valores = []

        for(let c = inicio; c <= fim; c += passo){
            resposta.innerHTML += ` ${c} \u{1F449}`
        }
    } 
}