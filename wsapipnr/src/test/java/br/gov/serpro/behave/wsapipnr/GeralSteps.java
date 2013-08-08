package br.gov.serpro.behave.wsapipnr;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.parser.Step;

public class GeralSteps implements Step {
	
	private String caminhoComBarra;
	private String nomeArquivo;
	
	public GeralSteps() {
		caminhoComBarra = new File(".").getAbsolutePath().replace(".", "src/test/java/") + GeralSteps.class.getName().replace('.', '/').replace("GeralSteps", "");
	}

	@When("recebo uma mensagem \"$formaMensagem\"")
	public void whenReceboUmaMensagem(String formaMensagem) {
	  nomeArquivo = formaMensagem.replace(" ", "_") + ".xml";
	}

	@Then("deve retornar \"$msgRetorno\"")
	public void thenDeveRetornar(String msgRetorno) {
		assertEquals(msgRetorno.toUpperCase(), PrincipalWsApiPnr.getInstance().receberArquivo(caminhoComBarra + nomeArquivo).getDescricao());
	}
	

}
