package br.com.service;

import br.com.model.Estado;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class EstadoService extends AbstractService<Estado> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public EstadoService() {
        super(Estado.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}


