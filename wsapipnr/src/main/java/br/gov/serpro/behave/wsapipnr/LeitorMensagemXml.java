package br.gov.serpro.behave.wsapipnr;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Transforma um xml em um objeto mensagem 
 *
 */
public class LeitorMensagemXml extends DefaultHandler {
	String mensagemXmlFileName;
	String valorTmp;
	Mensagem mensagemTmp;

	public Mensagem parseDocumento(String caminho)
			throws ParserConfigurationException, SAXException, IOException {
		mensagemXmlFileName = caminho;

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(mensagemXmlFileName, this);

		return mensagemTmp;
	}
	
	/* *******************************************************
	 * Métodos obrigatórios da SAX
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	

	@Override
	public void startElement(String s, String s1, String elemento,
			Attributes atributos) throws SAXException {
		if (elemento.equalsIgnoreCase("mensagem")) {
			mensagemTmp = new Mensagem();
		}
	}

	@Override
	public void endElement(String s, String s1, String elemento)
			throws SAXException {
		if (elemento.equalsIgnoreCase("id")) {
			mensagemTmp.setId(valorTmp);
		}
		if (elemento.equalsIgnoreCase("hash")) {
			mensagemTmp.setHash(valorTmp);
		}
		if (elemento.equalsIgnoreCase("data-de-envio")) {
			Date data;
			try {
				data = new SimpleDateFormat("dd-MM-yyyy").parse(valorTmp);
			} catch (ParseException e) {
				throw new SAXException(e);
			}
			mensagemTmp.setDataEnvio(data);
		}
		if (elemento.equalsIgnoreCase("conteudo")) {
			mensagemTmp.setConteudo(valorTmp);
		}

	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		valorTmp = new String(ac, i, j);
	}

}