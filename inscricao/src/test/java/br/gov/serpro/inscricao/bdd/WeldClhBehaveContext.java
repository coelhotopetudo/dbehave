package br.gov.serpro.inscricao.bdd;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.parser.StoryFileConverter;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.Parser;
import br.gov.frameworkdemoiselle.behave.parser.Step;

public class WeldClhBehaveContext {

	private Parser parser;

	private static Logger log = Logger.getLogger(BehaveContext.class);

	private ArrayList<String> allOriginalStoriesPath = new ArrayList<String>();

	private List<Step> steps = new ArrayList<Step>();

	private List<String> storiesPath = new ArrayList<String>();

	private String step;
	private Throwable fail;

	private BehaveMessage bm;

	public WeldClhBehaveContext() {
		bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
	}
	
	public void addSteps(Step step) {
		steps.add(step);
	}

	@SuppressWarnings("unchecked")
	public void run(List<String> storiesPath) {
		try {
			log.info("----------j----------------------");
			log.info(bm.getString("message-behave-start"));
			log.info("--------------------------------");

			BehaveConfig.logValueProperties();

			if (storiesPath == null || storiesPath.isEmpty()) {
				throw new BehaveException(bm.getString("exception-empty-story-list"));
			}
			// Armazena o array antigo para retirar as histórias depois
			List<String> oldsStories = StoryFileConverter.convertReusedScenarios((List<String>) allOriginalStoriesPath.clone(), BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);

			// Adiciono as novas histórias
			allOriginalStoriesPath.addAll(storiesPath);

			// Faz a conversão
			List<String> allStoriesConverted = StoryFileConverter.convertReusedScenarios(allOriginalStoriesPath, BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);

			// Cria um novo array contendo somente as histórias atuais, sem as
			// antigas
			List<String> finalArray = new ArrayList<String>();
			for (String s : allStoriesConverted) {
				if (!oldsStories.contains(s)) {
					finalArray.add(s);
				}
			}
			// Roda o runner com as histórias convertidas
			parser = (Parser) InjectionManager.getInstance().getInstanceDependecy(Parser.class);
			parser.setSteps(steps);
			parser.setStoryPaths(finalArray);
			parser.run();
			if (fail != null) {
				Assert.fail(bm.getString("exception-fail-step", step, fail.getMessage()));
			}
		} catch (BehaveException ex) {
			log.error(bm.getString("exception-general"), ex);
			throw ex;
		} finally {
			fail = null;
			storiesPath.clear();
			steps.clear();
			log.info("--------------------------------");
			log.info(bm.getString("message-behave-end"));
			log.info("--------------------------------");
		}
	}

	public void run(String storiesPath) {
		ArrayList<String> stories = new ArrayList<String>();
		stories.add(storiesPath);
		run(stories);
	}

	public void run() {
		run(storiesPath);
		this.fail = null;
		this.step = null;
	}

	public WeldClhBehaveContext addStories(String storiesPath) {
		log.debug("addStories:" + storiesPath);
		this.storiesPath.add(storiesPath);
		return this;
	}

	public void fail(String step, Throwable fail) {
		this.step = step;
		this.fail = fail;
	}

}
