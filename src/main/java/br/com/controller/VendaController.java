package br.com.controller;

import br.com.model.Venda;
import br.com.service.AbstractService;
import br.com.service.VendaService;
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
public class VendaController extends AbstractController<Venda> implements Serializable {
    
    @Inject
    private VendaService vendaService;
    
    public VendaController() {
        super(Venda.class);
    }
    
    @Override
    protected AbstractService getService() {
        return vendaService;
    }
}
