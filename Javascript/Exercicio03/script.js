function calcula(){
    
    var v = window.document.getElementById("valor")
    var op = document.getElementsByName("op")
    var resultado = document.getElementById("div2")
    
    if(v.value < 0){
        window.alert("Informe um valor válido!!!")
    }
    if(op[0].checked){     
        resultado.innerHTML = `Você depositou ${v.value} em sua conta`       
    } else if (op[1].checked){
        resultado.innerHTML = `Você retirou ${v.value} de sua conta`    
    }
}