package oo.desafio;

public class Item {
	
	Produto produto;
	int qtdade;
	
	Item (int qtdade, Produto produto) {
		this.qtdade = qtdade;
		this.produto = produto;
	}
	
	public double precoProduto() {
		return produto.preco*qtdade;
	}
	
}
