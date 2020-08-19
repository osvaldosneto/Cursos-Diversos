package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
	
	public static Connection getConexao() {
		
		try {
			Properties prop = getPropeties();
			String url = prop.getProperty("banco.url"); //usar a chave para acessar o dado
			String usuario = prop.getProperty("banco.usuario"); //usar a chave para acessar o dado
			String senha = prop.getProperty("banco.senha"); //usar a chave para acessar o dado
			return DriverManager.getConnection(url, usuario, senha);
		
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getPropeties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties"; //caminno do arquivo
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		return prop;	
	}
}