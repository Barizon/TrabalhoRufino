package br.com.controller;

import br.com.model.VendaItem;
import br.com.service.AbstractService;
import br.com.service.VendaItemService;
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
public class VendaItemController extends AbstractController<VendaItem> implements Serializable {
    
    @Inject
    private VendaItemService vendaItemService;
    
    public VendaItemController() {
        super(VendaItem.class);
    }
    
    @Override
    protected AbstractService getService() {
        return vendaItemService;
    }
}
