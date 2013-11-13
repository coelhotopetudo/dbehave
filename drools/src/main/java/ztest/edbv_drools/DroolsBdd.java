package ztest.edbv_drools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class DroolsBdd {

	private static DroolsBdd instance;
	private Resultado resultado;
	private String situacao;

	private DroolsBdd() {

	}

	public static DroolsBdd getInstance() {
		if (instance == null)
			instance = new DroolsBdd();
		return instance;
	}

	public void iniciar() {
		InputStream is = null;
		try {
			String string = calcularCaminhoArquivo() + "BddDroolExcel.xls";
			is = new FileInputStream(string);

			SpreadsheetCompiler sc = new SpreadsheetCompiler();

			StringBuffer drl = new StringBuffer(sc.compile(is, InputType.XLS));

			BufferedWriter out = new BufferedWriter(new FileWriter(calcularCaminhoArquivo() + "RuleFile.drl"));
			out.write(drl.toString());
			out.close();

			situacao = "Iniciei";

		} catch (FileNotFoundException e) {
			situacao = "Falhei";
		} catch (IOException e) {
			situacao = "Falhei";
		} catch (Exception e) {
			situacao = "Falhei";
		}
	}

	private String calcularCaminhoArquivo() {
		String canonicalName = DroolsBdd.class.getCanonicalName();
		String name = canonicalName.substring(
				canonicalName.lastIndexOf('.') + 1, canonicalName.length());
		String caminho = new File(".").getAbsolutePath().replace(".",
				"src/main/java/")
				+ DroolsBdd.class.getName().replace('.', '/').replace(name, "");
		return caminho;
	}

	public int getResultado() {
		return (resultado.getPeso());
	}

	@SuppressWarnings("unchecked")
	public void informar(String origem, String resid, String pesoBagagem) {
		// Create knowledge builder
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		// Using DRL file
		Resource newClassPathResource = ResourceFactory.newClassPathResource(
				"RuleFile.drl", DroolsBdd.class);
		kbuilder.add(newClassPathResource, ResourceType.DRL);
		// Check the builder for errors
		if (kbuilder.hasErrors()) {
			System.out.println("kbuilder has errors");
			System.out.println(kbuilder.getErrors().toString());
		}
		// get the compiled packages (which are serializable)
		@SuppressWarnings("rawtypes")
		final Collection pkgs = kbuilder.getKnowledgePackages();
		// add the packages to a knowledgebase (deploy the knowledge packages).
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(pkgs);
		// Create stateful session
		final StatefulKnowledgeSession ksession = kbase
				.newStatefulKnowledgeSession();
		// Set event listeners
		ksession.addEventListener(new DebugAgendaEventListener());
		ksession.addEventListener(new DebugWorkingMemoryEventListener());

		Paises pais = new Paises();
		pais.setOrigem(origem);
		pais.setResidencia(resid);

		Bagagem bagagem = new Bagagem();
		bagagem.setPesoBagagem(pesoBagagem);

		resultado = new Resultado();
		ksession.setGlobal("resultado", resultado);

		ksession.insert(pais);
		ksession.insert(bagagem);

		ksession.fireAllRules();

		resultado = (Resultado) ksession.getGlobal("resultado");

		ksession.dispose();
	}

	public static class Resultado {
		private int peso;

		public int getPeso() {
			return peso;
		}

		public void setPeso(int peso) {
			this.peso = peso;
		}
	}

	public static class Paises {

		private String origem;
		private String residencia;

		public Paises() {
		}

		public void aplicarPeso(int test) {
			System.out.println("aplicar peso: " + test);
		}

		public String getOrigem() {
			return origem;
		}

		public void setOrigem(String origem) {
			this.origem = origem;
		}

		public String getResidencia() {
			return residencia;
		}

		public void setResidencia(String residencia) {
			this.residencia = residencia;
		}
	}

	public static class Bagagem {
		private String pesoBagagem;

		public String getPesoBagagem() {
			return pesoBagagem;
		}

		public void setPesoBagagem(String pesoBagagem) {
			this.pesoBagagem = pesoBagagem;
		}
	}

	public String getSituacao() {
		return situacao;
	}
}
