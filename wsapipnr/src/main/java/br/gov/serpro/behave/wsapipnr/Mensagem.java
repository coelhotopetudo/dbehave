package br.gov.serpro.behave.wsapipnr;

import java.util.Date;

public class Mensagem {

	private String id;
	private String hash;
	private Date dataEnvio;
	private String conteudo;

	public String getId() {
		return id;
	}

	public void setId(String valorTmp) {
		this.id = valorTmp;
		
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String valorTmp) {
		this.hash = valorTmp;
	}
	
	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date data) {
		this.dataEnvio = data;
		
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
