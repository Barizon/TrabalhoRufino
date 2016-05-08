package br.com.service;

import br.com.model.Cidade;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class CidadeService extends AbstractService<Cidade> implements Serializable {
    
    @Inject
    private EntityManager em;
    
    public CidadeService() {
        super(Cidade.class);
    }
    @Override
    public EntityManager getEm() {
        return em;
    }
}
