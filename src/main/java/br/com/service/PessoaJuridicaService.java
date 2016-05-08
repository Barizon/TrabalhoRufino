package br.com.service;

import br.com.model.PessoaJuridica;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class PessoaJuridicaService extends AbstractService<PessoaJuridica> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public PessoaJuridicaService() {
        super(PessoaJuridica.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}
