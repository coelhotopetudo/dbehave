package coelhotopetudo.zAniversarios;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class MyTest {

	@Inject
	private BehaveContext eng;
	
	@Inject
	private MySteps mySteps;

	@Test
	public void testAllStories() throws Throwable {
		eng.addSteps(mySteps);
		eng.run("/stories");
	}

}
