package br.com.service;

import br.com.model.Usuario;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 */
@Transacional
public class UsuarioService extends AbstractService<Usuario> implements Serializable {
    
    @Inject
    public EntityManager em;
    
    public UsuarioService() {
        super(Usuario.class);
    }
    
    @Override
    public EntityManager getEm() {
        return em;
    }
}

