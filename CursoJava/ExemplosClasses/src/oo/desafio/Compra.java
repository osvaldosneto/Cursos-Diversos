package oo.desafio;

import java.util.ArrayList;

public class Compra {
	
	ArrayList<Item> listaItem = new ArrayList<>();
	
	Compra(ArrayList<Item> listaItem){
		this.listaItem = listaItem;
	}
	
	void addItem(Item item) {
		listaItem.add(item);
	}
	
	void rmv(Item item) {
		listaItem.remove(item);
	}
	
	double obterValorTotal() {
		double total = 0;
		for (Item i : listaItem) {
			total += i.precoProduto();
		}
		return total;
	}
}
