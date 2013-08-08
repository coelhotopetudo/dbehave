package br.gov.serpro.behave.wsapipnr;

/**
 * Representa o resultado da consistência feita ao receber a mensagem 
 *
 */

public enum RetornoMensagemEnum {
	OK("OK"),
	ERRO_DE_HASH("ERRO DE HASH"),	
	ERRO_DE_XSD("ERRO DE XSD"),	
	
	
	ERRO_INTERNO("ERRO INTERNO")
	;
	
	private String descricao;

	private RetornoMensagemEnum(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return this.getDescricao();
	}

	public String getDescricao() {
		return this.descricao;
	}

}
