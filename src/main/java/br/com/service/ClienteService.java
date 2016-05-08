package br.com.service;

import br.com.model.Cliente;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class ClienteService extends AbstractService<Cliente> implements Serializable{
    
    @Inject
    public EntityManager em;
    
    public ClienteService() {
        super(Cliente.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}
