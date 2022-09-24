package br.com.viagem.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	// Nome, senha e URL do mysql
	private static final String USERNAME = "root";
	private static final String PASSWORD = "E7g7PRZvtsstrFF";
	private static final String URL = "jdbc:mysql://localhost:3306/crud_atividade";
    private static Connection connection;

	public static Connection createConnectionToMySQL() throws SQLException {
		
// Class.forName("com.mysql.jdbc.cj.Driver");
//		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		return connection;
	}	
	
	public static void main(String[] args) throws Exception{
		
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}
}
