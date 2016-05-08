package br.com.service;

import br.com.model.Produto;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class ProdutoService extends AbstractService<Produto> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public ProdutoService() {
        super(Produto.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}

