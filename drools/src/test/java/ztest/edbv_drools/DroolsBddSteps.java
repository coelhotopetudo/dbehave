package ztest.edbv_drools;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.parser.Step;

public class DroolsBddSteps implements Step {

	private DroolsBdd drools;

	@When("inicio o motor de regras")
	public void whenInicioOMotorDeRegras() {
		drools = DroolsBdd.getInstance();
		drools.iniciar();
	}

	@When("informo origem-residencia-bagagem \"{$informado}\"")
	public void whenInformoOrigemresidenciabagagem(String informado) {
		String[] aInf = informado.split("-");
		drools.informar(aInf[0], aInf[1], aInf[2]);
	}
	
	@Then("o motor de regras dir\u00E1 \"{$parm}\"")
	public void thenOMotorDeRegrasDiráIniciei(String parm) {
		String resultado = drools.getSituacao();
		assertEquals(parm, resultado);
	}
	
	@When("inicio o motor de regras com a planilha \"{$arquivo}\"")
	@Pending
	public void whenInicioOMotorDeRegrasComAPlanilhaXYZxls(String arquivo) {
//	  String arq = "XYZ.xls";
	}

	@Then("seu valor ser\u00E1 \"{$esperado}\"")
	public void thenSeuValorSera(String esperado) {
		String resultado = String.valueOf(drools.getResultado());
		assertEquals(esperado, resultado);
	}
}
