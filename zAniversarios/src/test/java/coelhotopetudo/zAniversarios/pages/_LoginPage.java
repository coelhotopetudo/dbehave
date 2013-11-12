package coelhotopetudo.zAniversarios.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Login", location = "https://www.serpro.gov.br/conteudo-minhaempresa/aniversariantes/")
public class _LoginPage {

	@ElementMap(name = "Nome do Usuário", locatorType = ElementLocatorType.Id, locator = "__ac_name")
	private TextField nome;
	
	@ElementMap(name = "Senha", locatorType = ElementLocatorType.Id, locator = "__ac_password")
	private TextField senha;

	@ElementMap(name = "Acessar", locatorType = ElementLocatorType.Value, locator = "Acessar")
	private Button buttonLuckSearch;

}
