package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Atualizar {
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o código da pessoa a atualizar:");
		String codigo = entrada.nextLine();
		
		System.out.println("Digite o novo nome:");
		String nome = entrada.nextLine();
		
		String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, codigo);
		stmt.execute();
		
		stmt.close();
		
	}

}
