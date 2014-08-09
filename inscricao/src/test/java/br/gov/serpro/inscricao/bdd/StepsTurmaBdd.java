package br.gov.serpro.inscricao.bdd;

import javax.inject.Inject;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.serpro.inscricao.Turma;

public class StepsTurmaBdd implements Step {
	
	@Inject
	private Turma turma;
	private String nomeAluno;

	@Given("informo \"Santos Dummont\" no campo \"nome do aluno\"")
	public void givenInformoSantosDummontNoCamponomeDoAluno() {
		nomeAluno = "Santos Dumont";
	}

	@When("clico em \"matricular\"")
	public void whenClicoEmmatricular() {
		turma.matricular(nomeAluno);
	}

	@Then("ser\u00E1 exibido na \"situa\u00E7\u00E3o aluno\" o valor \"matriculado\"")
	public void thenSeráExibidoNasituaçãoAlunoOValormatriculado() {
		boolean esperado = true;
		boolean estaMatriculado = turma.estaMatriculado(nomeAluno);
		Assert.assertEquals(esperado, estaMatriculado);

	}
}
