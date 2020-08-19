package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* precisa baixar o driver sql 
 * https://dev.mysql.com/downloads/file/?id=494901
 * download arquivo e colocar na pasta libs criada por mim
 * clicar botao direito em cima de mysql conector em build path
 * e add build path
 * */

public class TesteConexao {
	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:mysql://localhost?verifyCertificate=false&userSSl=true";
		String usuario = "root";
		String senha = "rafavedi23";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("Conexão efetuada com sucesso...");
		conexao.close();
	}
}