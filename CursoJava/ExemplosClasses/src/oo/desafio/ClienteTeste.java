package oo.desafio;

import java.util.ArrayList;

public class ClienteTeste {
	public static void main(String[] args) {
		Produto caneta = new Produto("Canete", 10.5);
		Produto lapis = new Produto("lapis", 12);
		Produto papel = new Produto("papel", 0.5);
		Produto grampo = new Produto("grampo", 8.5);
		
		Item canetas = new Item(2, caneta);
		Item lapises = new Item(2, lapis);
		
		ArrayList<Item> itens1 = new ArrayList<>();
		itens1.add(canetas);
		itens1.add(lapises);
		
		Compra O1 = new Compra(itens1);
		
		Item grampos = new Item(3, grampo);
		Item papeis = new Item(3, papel);
		
		ArrayList<Item> itens2 = new ArrayList<>();
		itens2.add(grampos);
		itens2.add(papeis);
		
		Compra O2 = new Compra(itens2);
		
		ArrayList<Compra> listaCompras = new ArrayList<>();
		
		listaCompras.add(O1);
		listaCompras.add(O2);
		
		Cliente Osvaldo = new Cliente("Osvaldo", listaCompras);
		
		
		ArrayList<Double> valores = Osvaldo.obterValorTotal();
		
		for (double valor : valores) {
			System.out.println(valor);
		}
	}
}
