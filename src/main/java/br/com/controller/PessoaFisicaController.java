package br.com.controller;

import br.com.model.PessoaFisica;
import br.com.service.AbstractService;
import br.com.service.PessoaFisicaService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author barizon
 */
@Named
@ViewScoped
public class PessoaFisicaController extends AbstractController<PessoaFisica> implements Serializable {
    
    @Inject
    private PessoaFisicaService pessoaFisicaService;
    
    public PessoaFisicaController() {
        super(PessoaFisica.class);
    }
    
    @Override
    protected AbstractService getService() {
        return pessoaFisicaService;
    }
}
