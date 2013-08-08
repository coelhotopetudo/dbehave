package br.gov.serpro.behave.wsapipnr;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class GeralTest {

	private BehaveContext eng = null;

	public GeralTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new GeralSteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories/geral.story");
	}

}
