package br.paulo.meireles.web;

import br.paulo.meireles.web.dao.NoticiaDao;
import br.paulo.meireles.web.model.Noticia;

public class InserirTests {
	
	
	public static void main(String[] args) throws Exception{

		// pronto para gravar
		Noticia noticia = new Noticia();
		
		noticia.setNumerodanoticia("2");
		noticia.setTitulodanoticia("Presidente Donald Trumpp");
		noticia.setConteudodanoticia("Presitende dos EUA fez o "
				+ "teste de Covid, acusou positivo mas passa bem");
		noticia.setAutordanoticia("TV Globinho");
		noticia.setDatadecriacao("2020-10-10");
		noticia.setDatadeatualizacao("2020-10-10");

		// grave nessa conexão!!!
		NoticiaDao dao = new NoticiaDao();
		
		// método elegante
		dao.adiciona(noticia);

		System.out.println("Gravado Lindamente");
	}
}