import React from 'react';

//criação do componente, deve retornar apenas um nó
//modelo 01
//function componenteFuncional(){
//  return(
//    <h1>Hello</h1>
//  )
//}

//modelo 02
// criação do componente de classe
class App extends React.Component{
  //criando um estado
  state = {
    nome: 'Osvaldo Neto'
  }


  //e = evento disparado neste caso onChange
  modificarNome = (event) => {
    this.setState({ //modificando o state
      nome: event.target.value, //capturan o nome no campo
    })
  }

  //criando array de instruções
  criaComboBox = () => {
    const opcoes = ["fulano", "ciclano", "beltrano"]
    //metodo map do array, transforma cada variável em um componente
    //percorrendo array de opcoes e enviando ao view
    const comboBox = opcoes.map(opcao => <option>{opcao}</option>)
    return(
      <select>
        {comboBox}
      </select>
    )
  }
  
  render(){
    const MeuComboBox = () => this.criaComboBox()
    return(
      //gerando mais de uma instrução react
      <>
      <input type="text" value={this.state.nome} onChange={this.modificarNome}/>
      <h1>Hello {this.state.nome}</h1>
      <h2>Hello props {this.props.nome}</h2>
      </>
    )
  }
}
export default App;