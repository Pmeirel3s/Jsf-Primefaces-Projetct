package br.paulo.meireles.web.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceUnit;


@MappedSuperclass
@Entity
@PersistenceUnit
@ManagedBean
public class Noticia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String numerodanoticia ;
	
	private String titulodanoticia = "Presidente Donald Trump";
	private String conteudodanoticia = "Presitende dos EUA fez o teste de Covid, acusou positivo mas passa bem";
	private String autordanoticia = "TV Record";
	private String datadecriacao = "10-10-2020";
	private String datadeatualizacao = "10-10-2020";
	
	
	
	public String getNumerodanoticia() {
		return numerodanoticia;
	}
	public void setNumerodanoticia(String numerodanoticia) {
		this.numerodanoticia = numerodanoticia;
	}
	public String getTitulodanoticia() {
		return titulodanoticia;
	}
	public void setTitulodanoticia(String titulodanoticia) {
		this.titulodanoticia = titulodanoticia;
	}
	public String getConteudodanoticia() {
		return conteudodanoticia;
	}
	public void setConteudodanoticia(String conteudodanoticia) {
		this.conteudodanoticia = conteudodanoticia;
	}
	public String getAutordanoticia() {
		return autordanoticia;
	}
	public void setAutordanoticia(String autordanoticia) {
		this.autordanoticia = autordanoticia;
	}
	public String getDatadecriacao() {
		return datadecriacao;
	}
	public void setDatadecriacao(String datadecriacao) {
		this.datadecriacao = datadecriacao;
	}
	public String getDatadeatualizacao() {
		return datadeatualizacao;
	}
	public void setDatadeatualizacao(String datadeatualizacao) {
		this.datadeatualizacao = datadeatualizacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numerodanoticia == null) ? 0 : numerodanoticia.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (numerodanoticia == null) {
			if (other.numerodanoticia != null)
				return false;
		} else if (!numerodanoticia.equals(other.numerodanoticia))
			return false;
		return true;
	}
	
	
	
	
	
}