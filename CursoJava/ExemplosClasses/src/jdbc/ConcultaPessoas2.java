package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConcultaPessoas2 {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);	
		System.out.println("Digite os caracteres a pesquisar:");
		String caracteres = entrada.nextLine();
		
		// o % determina o senttido da procura, este comando procura
		// qualquer sequencia destes caractereres
		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + caracteres + "%");
		
		//capturando as pessos
		ResultSet resultado = stmt.executeQuery();
		
		while(resultado.next()) {
			System.out.print(resultado.getInt("codigo") + " - ");
			System.out.println(resultado.getString("nome"));
		}
		conexao.close();
	}
}
