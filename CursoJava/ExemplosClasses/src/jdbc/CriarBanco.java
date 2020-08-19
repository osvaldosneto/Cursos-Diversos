package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	
public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:mysql://localhost?verifyCertificate=false&userSSl=true";
		String usuario = "root";
		String senha = "rafavedi23";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("Criando banco de dados...");
		Statement stmt = conexao.createStatement();
		
		//criando banco de dados
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java"); //incerindo comando sql
		System.out.println("Banco criado com sucesso...");
		
		conexao.close();
	}

}
