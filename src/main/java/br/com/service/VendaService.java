package br.com.service;

import br.com.model.Venda;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class VendaService extends AbstractService<Venda> implements Serializable{
    
    @Inject
    public EntityManager em;
    
    public VendaService() {
        super(Venda.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}
