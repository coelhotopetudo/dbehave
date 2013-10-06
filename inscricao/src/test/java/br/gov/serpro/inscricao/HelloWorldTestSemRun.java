package br.gov.serpro.inscricao;

import static junit.framework.Assert.assertNotNull;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class HelloWorldTestSemRun {
	
//    @Inject
//    @Name("system-core")
//    private ResourceBundle bundleCore;
//
//    @Inject
//    @Name("messages")
//    private ResourceBundle bundleMessages;
//
//    @Inject
//    @Name("images")
//    private ResourceBundle bundleImages;
    
    @Inject
    private Logger logger;
    
	@Inject
	private HelloWorld helloWorld;
    
    /**
     * Trata o evento de inicialização do container do Weld para iniciar o sistema.
     * 
     * @param event Evento.
     */
    public void start(@Observes final ContainerInitialized event) {
    	logger.info("inicializando o sistema.");
    	
    	assertNotNull(helloWorld);
    }
	
	public void inicio() {
		String[] args = null;
		new StartMain(args).go();
	}



	@Test
	public void say() {
		assertNotNull(helloWorld);
		helloWorld.say();
	}
	
	@Test
	@Ignore
	public void saySemRun() {
		
		inicio();
		
		assertNotNull(helloWorld);
		helloWorld.say();
	}
}
