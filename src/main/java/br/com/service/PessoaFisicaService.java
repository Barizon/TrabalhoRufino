package br.com.service;

import br.com.model.PessoaFisica;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class PessoaFisicaService extends AbstractService<PessoaFisica> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public PessoaFisicaService() {
        super(PessoaFisica.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}
