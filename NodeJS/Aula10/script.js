function gerartabuada(){
    var n = Number(window.document.getElementById("n").value)
    var tabela = window.document.getElementById("sel")
    tabela.innerHTML = ""
    
    for(var i=1; i<=10; i++){
        let item = document.createElement('option')
        item.text = `${n} x ${i} = ${n*i}`
        tabela.appendChild(item)
    }    
}