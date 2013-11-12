package coelhotopetudo.zAniversarios.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Login", location = "https://www.serpro.gov.br/conteudo-minhaempresa/aniversariantes/")
public class _LoginPage {

	@ElementMap(name = "Nome do Usuário", locatorType = ElementLocatorType.XPath, locator = "id('login_form')//div[label[contains(text(), 'Nome')]]/input")
	private TextField nome;
	
	@ElementMap(name = "Senha", locatorType = ElementLocatorType.XPath, locator = "id('login_form')//div[label[contains(text(), 'Senha')]]/input")
	private TextField senha;

	@ElementMap(name = "Acessar", locatorType = ElementLocatorType.XPath, locator = "id('login_form')//div[input[@value='Acessar']]/input")
	private Button buttonLuckSearch;

}
