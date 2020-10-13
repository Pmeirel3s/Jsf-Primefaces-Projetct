package br.paulo.meireles.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.paulo.meireles.web.factory.ConnectionFactory;
import br.paulo.meireles.web.model.Noticia;



public class NoticiaDao {

	private Connection conn;

	String ResultConsult = "Sucess";

	public NoticiaDao() throws Exception {
		try {
			this.conn = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			throw new Exception("Erro: Problema na conexao NoticiaDao" + "\n" + e.getMessage());
		}
	}

	public void adiciona(Noticia noticia) throws Exception {
		String sql = "INSERT INTO noticia (numerodanoticia, titulodanoticia, conteudodanoticia, autordanoticia, datadecriacao, datadeatualizacao) VALUES "
				+ " (?,?,?,?,?,?,);";
	
		try {
			// prepared statement para inserção
			PreparedStatement stmt = conn.prepareStatement(sql);

			
			// seta os valores
			stmt.setString(1, noticia.getNumerodanoticia());
			stmt.setString(2, noticia.getTitulodanoticia());
			stmt.setString(3, noticia.getConteudodanoticia());
			stmt.setString(4, noticia.getAutordanoticia());
			stmt.setString(5, noticia.getDatadecriacao());
			stmt.setString(6, noticia.getDatadeatualizacao());

			// executa
			stmt.execute();

			conn.close();
			System.out.println("Gravado com sucesso");
			
		}catch (SQLException e) {
				
		}
	
			
		
		// pega a conexão e o Statement
			
		  Connection conn = new ConnectionFactory().getConnection();
		  PreparedStatement stmt = conn.prepareStatement("select * from noticia");
		  
		  ResultSet rs = stmt.executeQuery();
		  
		  while (rs.next()) {
			  String tituloDaNoticia = rs.getString("titulodanoticia");
			  String conteudoDaNoticia = rs.getString("conteudodanoticia");
			  String autorDaNoticia = rs.getString("autordanoticia");
		 
					System.out.println(tituloDaNoticia +"_"+ conteudoDaNoticia+"_"+autorDaNoticia);
		  }
		rs.close();
		stmt.close();
		conn.close();
		  
		  }
			
		  
		  
	
//			List<Noticia> noticias = new ArrayList<Noticia>();
//		
//			stmt = this.conn.prepareStatement("SELECT * FROM noticia");
//			rs = stmt.executeQuery();
//
//		while (rs.next()) {
//						
//		//criando o objeto Noticia
//		   noticia = new Noticia();
//		   
//		noticia.setNumerodanoticia(rs.getString("Numerodanoticia"));
//		noticia.setTitulodanoticia(rs.getString("Titulodanoticia"));
//		noticia.setConteudodanoticia(rs.getString("Conteudodanoticia"));
//		noticia.setAutordanoticia(rs.getString("Autordanoticia"));
//		noticia.setDatadecriacao(rs.getString("Datadecriacao"));
//		noticia.setDatadeatualizacao(rs.getString("Datadeatualizacao"));
//		
//		
//		//adicionando o objeto à lista
//		noticias.add(noticia);
//		
//		   }
//		
//		rs.close();
//		stmt.close();
//			
//			return ;

			
	
	public List<Noticia> getList() {

		try {
			List<Noticia> noticias = new ArrayList<Noticia>();
			PreparedStatement stmt = this.conn.prepareStatement("select * from noticia;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setNumerodanoticia(rs.getString("numerodanoticia"));
				noticia.setTitulodanoticia(rs.getString("titulodanoticia"));
				noticia.setConteudodanoticia(rs.getString("conteudodaNoticia"));
				noticia.setAutordanoticia(rs.getString("autordanoticia"));
				noticia.setDatadecriacao(rs.getString("datadecriacao"));
				noticia.setDatadeatualizacao(rs.getString("datadeatualizacao"));

				noticias.add(noticia);
			}

			rs.close();
			stmt.close();

			return noticias;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public void alterar(Noticia noticia) {
		String sql = "UPDATE noticia set numerodanoticia=?, titulodanoticia=?, conteudodanoticia=?, "
				+ "autordanoticia=?, datadecriacao=?, datadealteracao=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, noticia.getNumerodanoticia());
			stmt.setString(2, noticia.getTitulodanoticia());
			stmt.setString(3, noticia.getConteudodanoticia());
			stmt.setString(4, noticia.getAutordanoticia());
			stmt.setString(5, noticia.getDatadecriacao());
			stmt.setString(5, noticia.getDatadeatualizacao());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Noticia noticia) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from noticia where id=?");
			stmt.setString(1, noticia.getNumerodanoticia());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

