package coelhotopetudo.zAniversarios;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class MySteps extends CommonSteps implements Step {
	
	public MySteps() {
		super();
		dataProvider.put("usuario", getNomeUsuario());
		dataProvider.put("senha", getSenha());
	}

	private String getSenha() {
		String senha = (BehaveConfig.getProperty("usuario.senha"));
		return senha;
	}

	private String getNomeUsuario() {
		String deveExecutarTestesBdd = (BehaveConfig.getProperty("usuario.nome"));
		return deveExecutarTestesBdd;
	}

}
