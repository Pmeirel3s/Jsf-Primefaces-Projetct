package br.paulo.meireles.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.paulo.meireles.web.factory.ConnectionFactory;

public class InserirNoticia {
	
	
	public static void main (String[] args) throws SQLException{
		
		
	try {
	Connection conn = new ConnectionFactory().getConnection();

	String sql = "INSERT INTO noticia"
			+ "  (numerodanoticia, titulodanoticia, conteudodanoticia, autordanoticia, datadecriacao, datadeatualizacao) VALUES "
			+ " (?'?'?'?'?'?);";

	PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "NumeroDaNoticia");
		stmt.setString(2, "TituloDaNoticia");
		stmt.setString(3, "ConteudoDaNoticia");
		stmt.setString(4, "AutorDaNoticia");
		stmt.setString(5, "DataDeCriacao");
		stmt.setString(6, "DataDeAtualizacao");
		// executa
					stmt.execute();
					stmt.close();
					System.out.println("Gravado com sucesso");
					conn.close();
}
	   catch(SQLException e) {
		    System.out.println(e);
		  }
}
}