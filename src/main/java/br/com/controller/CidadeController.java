package br.com.controller;

import br.com.model.Cidade;
import br.com.service.AbstractService;
import br.com.service.CidadeService;
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
public class CidadeController extends AbstractController<Cidade> implements Serializable {
    
    @Inject
    private CidadeService cidadeService;
    
    public CidadeController() {
        super(Cidade.class);
    }
    
    @Override
    protected AbstractService getService() {
        return cidadeService;
    }
}
