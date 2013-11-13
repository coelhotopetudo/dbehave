package ztest.edbv_drools;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class DroolsBddTest {

	private BehaveContext eng = null;

	public DroolsBddTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new DroolsBddSteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
