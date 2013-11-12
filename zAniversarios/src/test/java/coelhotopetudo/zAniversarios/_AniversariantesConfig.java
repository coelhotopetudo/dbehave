package coelhotopetudo.zAniversarios;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "aniversariantes")
public class _AniversariantesConfig {

	private String nomeUsuario;
	private String senha;

	@Name("usuario.nome")
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	@Name("usuario.senha")
	public String getSenha() {
		return senha;
	}

}
