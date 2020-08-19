function carregar(){

    var msg = window.document.getElementById("msg")
    var img = window.document.getElementById("imagem")
    var data = new Date()
    var hora = data.getHours()
    msg.innerHTML = `Agora são ${hora} horas.`
    
    if(hora >= 0 && hora < 12){
        //Bom dia
        img.src = 'm.png'
    } else if (hora >= 12 && hora < 18){
        //Boa tarde
        img.src = 't.png'
    } else {
        //Boa Noite
        img.src = 'n.png'
    }
}