package oo.desafio;

import java.util.ArrayList;

public class Cliente {
	
	public String nome;
	public ArrayList<Compra> listaCompra = null;
	
	public Cliente(String nome, ArrayList<Compra> listaCompra) {
		this.nome = nome;
		this.listaCompra = listaCompra;
	}
	
	public ArrayList<Double> obterValorTotal() {
		ArrayList<Double> lista = new ArrayList<Double>();
		
		for(Compra c : listaCompra) {
			lista.add(c.obterValorTotal());
		}
		return lista;
	}

}
