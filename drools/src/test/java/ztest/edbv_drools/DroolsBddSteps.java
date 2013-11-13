package ztest.edbv_drools;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.parser.Step;

public class DroolsBddSteps implements Step {

	private static final String ORIGEM = "origem";
	private static final String RESIDENCIA = "residencia";
	private static final String BAGAGEM = "bagagem";
	
	protected DataProvider dataProvider = (DataProvider) InjectionManager.getInstance().getInstanceDependecy(DataProvider.class);
	
	private DroolsBdd drools;
	
	@Given("a origem do viajante \u00E9 \"{$origem}\"")
	public void givenAOrigemDoViajante(String origem) {
		dataProvider.put(ORIGEM, origem);
	}

	@Given("o pa\u00EDs de resid\u00EAncia do viajante \u00E9 \"{$residencia}\"")
	public void givenOPaísDeResidenciaDoViajante(String residencia) {
		dataProvider.put(RESIDENCIA, residencia);
	}

	@Given("a quantidade de bagagem \u00E9 \"{$bagagem}\"")
	public void givenAQuantidadeDeBagagem(String bagagem) {
		dataProvider.put(BAGAGEM, bagagem);
	}

	@When("solicito a execu\u00E7\u00E3o das regras")
	public void whenSolicitoAExecuçãoDasRegras() {
		String origem = (String) dataProvider.get(ORIGEM);
		String residencia = (String) dataProvider.get(RESIDENCIA);
		String bagagem = (String) dataProvider.get(BAGAGEM);
		drools.informar(origem, residencia, bagagem);
	}

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
