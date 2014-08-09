package br.gov.serpro.inscricao.bdd;

import javax.enterprise.inject.Produces;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class BehaveContextFactory {
	
    @Produces
    public BehaveContext create() {
        return BehaveContext.getInstance();
    }

}
