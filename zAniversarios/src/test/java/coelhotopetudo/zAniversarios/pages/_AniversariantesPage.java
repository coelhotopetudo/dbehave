package coelhotopetudo.zAniversarios.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Aniversariantes", location = "https://www.serpro.gov.br/conteudo-minhaempresa/aniversariantes/")
public class _AniversariantesPage {

	@ElementMap(name = "Campo de Busca", locatorType = ElementLocatorType.Id, locator = "gbqfq")
	private TextField searchField;

	@ElementMap(name = "Link", locatorType = ElementLocatorType.XPath, locator = "id('content')/div[@id=('parent-fieldname-text')]/div/a[contains(text(), '%param1%')]")
	private Button buttonLuckSearch;

}
