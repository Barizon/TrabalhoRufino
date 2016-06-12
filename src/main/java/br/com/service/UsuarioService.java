package br.com.service;

import br.com.model.Usuario;
import br.com.utils.Criptografia;
import br.com.utils.Transacional;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
    public Usuario pesquisaUsuario(String login, String senha) {
        Query query = em.createQuery("FROM Usuario AS u WHERE u.login='" 
                + login + "' AND u.senha='" 
                + Criptografia.md5(senha) + "'");
        if (query.getResultList().size() == 1) {
            return (Usuario) query.getResultList().get(0);
        }
        return null;
    }
}

