package br.paulo.meireles.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class ConnectionFactory {
	
	public Connection getConnection() {
		
		 try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_desafio", "postgres", "dpbrlpjc");
			
			
		 }         
		 catch(SQLException e) {
			throw new RuntimeException(e);
		 }
}
}