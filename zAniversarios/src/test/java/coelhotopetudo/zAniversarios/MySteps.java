package coelhotopetudo.zAniversarios;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class MySteps extends CommonSteps implements Step {
	
	@Inject
	private _AniversariantesConfig config;
	
	public MySteps() {
		super();
		dataProvider.put("usuario", config.getNomeUsuario());
		dataProvider.put("senha", config.getSenha());
	}

}
