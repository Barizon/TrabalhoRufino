package br.com.controller;

import br.com.model.PessoaJuridica;
import br.com.service.AbstractService;
import br.com.service.PessoaJuridicaService;
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
public class PessoaJuridicaController extends AbstractController<PessoaJuridica> implements Serializable {
    
    @Inject
    private PessoaJuridicaService pessoaJuridicaService;
    
    public PessoaJuridicaController() {
        super(PessoaJuridica.class);
    }
    
    @Override
    protected AbstractService getService() {
        return pessoaJuridicaService;
    }
}
