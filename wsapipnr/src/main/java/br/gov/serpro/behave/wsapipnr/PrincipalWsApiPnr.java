package br.gov.serpro.behave.wsapipnr;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

public class PrincipalWsApiPnr {

	private static PrincipalWsApiPnr instance;

	private PrincipalWsApiPnr() {
	}

	public static PrincipalWsApiPnr getInstance() {
		if (instance == null)
			instance = new PrincipalWsApiPnr();
		return instance;
	}

	public RetornoMensagemEnum receberArquivo(String caminho) {
		Mensagem mensagem = null;

		// o xml recebido deve ser transformado em um objeto antes de passar pelas verificações das regra de negócio
		try {
			mensagem = new LeitorMensagemXml().parseDocumento(caminho);
		} catch (ParserConfigurationException e) {
			return RetornoMensagemEnum.ERRO_INTERNO;
		} catch (SAXException e) {
			return RetornoMensagemEnum.ERRO_DE_XSD;
		} catch (IOException e) {
			return RetornoMensagemEnum.ERRO_INTERNO;
		}

		// todos os campos obrigatorios devem ter valor
		if (todosCamposObrigatoriosPosuemValor(mensagem)) {
			return RetornoMensagemEnum.ERRO_DE_XSD;
		}

		// tanto o hash enviado quanto o calculado devem ser iguais
		if (osHashesSaoDiferentes(mensagem)) {
			return RetornoMensagemEnum.ERRO_DE_HASH;
		}
		
		return RetornoMensagemEnum.OK;
	}

	private boolean osHashesSaoDiferentes(Mensagem mensagem) {
		// implementacao ficticia
		boolean osHashesSaoDiferentes = mensagem.getConteudo().endsWith(mensagem.getHash()) == false;
		return osHashesSaoDiferentes;
	}

	private boolean todosCamposObrigatoriosPosuemValor(Mensagem mensagem) {
		boolean todosCamposObrigatoriosPosuemValor = StringUtils.isBlank(mensagem.getId()) 
		|| StringUtils.isBlank(mensagem.getHash())
		|| StringUtils.isBlank(mensagem.getConteudo());
		return todosCamposObrigatoriosPosuemValor;
	}

}
