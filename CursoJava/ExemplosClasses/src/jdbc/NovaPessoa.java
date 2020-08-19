package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		Connection conexao = FabricaConexao.getConexao();
		
		System.out.println("Informe o nome:");
		String nome = entrada.nextLine();
		
		//inserindo de forma segura
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		//String sql = "INSERT INTO pessoas (nome, CODIGO) VALUES (?, ?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome); //enviando parametro 1
		//stmt.setInt(2, 10);
		stmt.execute();
		
		System.out.println(sql);
		System.out.println("Pessoa inserida com sucesso!!!!");
		entrada.close();
	}
}