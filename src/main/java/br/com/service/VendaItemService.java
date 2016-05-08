package br.com.service;

import br.com.model.VendaItem;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class VendaItemService extends AbstractService<VendaItem> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public VendaItemService() {
        super(VendaItem.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}
