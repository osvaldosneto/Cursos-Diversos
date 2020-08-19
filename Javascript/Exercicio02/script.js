function verificar(){
    var data = new Date()
    var ano = data.getFullYear();
    var txtano = window.document.getElementById("ano")
    var sexo = document.getElementsByName('sexo')
    var idade = Number(ano) - Number(txtano.value)
    var genero =''
    var resultado = window.document.getElementById("resultado")
    var img = document.createElement('img') //criação objeto html
       
    if(txtano.value.length == 0 || txtano.value > ano){
        window.alert("Informe um ano correto!!!")
    } else {
        img.setAttribute('id', 'foto')
        if(sexo[0].checked){           
            genero = "masculino"
            if(idade >=0 && idade < 10){
                //criança
                img.setAttribute('src', 'criancamenino.png')
            }else if (idade >= 10 && idade < 50){
                //adulto
                img.setAttribute('src', 'homemjovem.png')
            } else {
                //idoso
                img.setAttribute('src', 'homemidoso.png')
            }
        } else if (sexo[1].checked){
            genero = "feminino"
            if(idade >=0 && idade < 10){
                //criança
                img.setAttribute('src', 'criancamenina.png')
            }else if (idade >= 10 && idade < 50){
                //adulto
                img.setAttribute('src', 'mulherjovem.png')
            } else {
                //idoso
                img.setAttribute('src', 'mulheridosa.png')
            }
        }
        resultado.innerHTML = `Detectamos o sexo ${genero} com ${idade} anos.`
        resultado.appendChild(img)
    }
}