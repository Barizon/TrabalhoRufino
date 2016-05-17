package br.com.controller;

import br.com.model.Venda;
import br.com.model.VendaItem;
import br.com.service.AbstractService;
import br.com.service.VendaService;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private VendaItem vendaItem = new VendaItem();
    
    public VendaController() {
        super(Venda.class);
    }
    
    @Override
    protected AbstractService getService() {
        return vendaService;
    }
    
    public void adicionaItem() {
        try {
            super.getEntidade().adicionaItem(vendaItem);
            vendaItem = new VendaItem();
        } catch (Exception ex) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
}
