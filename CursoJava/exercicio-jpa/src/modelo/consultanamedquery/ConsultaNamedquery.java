package modelo.consultanamedquery;

import java.util.List;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class ConsultaNamedquery {
	
	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>();
		
		//consultando named query
		//dao.consultar("nome da consulta", parametros)	
		List<Filme> filmes = dao.consultar(
				"filmesNotaMaiorQue", 
				"nota", 8.5); //nome do parametro e valor
		
		for(Filme f : filmes) {
			System.out.println(f.getNome());
			
			for(Ator ator : f.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
		
		//consulta por nome
		List<Filme> filme = dao.consultarNome(
				"filmesNome", 
				"nome", "Teste");
		
		for(Filme f : filme) {
			System.out.println(f.getNome());			
			for(Ator ator : f.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
		
	}
}
