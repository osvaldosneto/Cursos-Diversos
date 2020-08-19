package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DAOTeste {
	
	public static void main(String[] args) throws SQLException {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		//todos estes métodos abaixo retornam a id da operação
		dao.incluir(sql, "João da Silva");
		dao.incluir(sql, "Pedro de Lara");
		dao.incluir(sql, "Nogueira jonatam");
		
		sql = "SELECT * FROM pessoas";
		ResultSet resultado = dao.incluir(sql);
		
		while(resultado.next()) {
			System.out.print(resultado.getInt("codigo") + " - ");
			System.out.println(resultado.getString("nome"));
		}
		
		dao.close();
		
	}

}
