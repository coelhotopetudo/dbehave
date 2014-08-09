package br.gov.serpro.inscricao.bdd;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TestTurmaBdd {

	@Inject
	private BehaveContext eng;
	
	@Inject
	private StepsTurmaBdd steps;

	@Before
	public void antesTodosTestes() {
		eng.addSteps(steps);
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories/inscricao.story");
	}

}
