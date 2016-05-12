package br.com.controller;

import br.com.model.Usuario;
import br.com.service.AbstractService;
import br.com.service.UsuarioService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author barizon
 */
@Named
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> implements Serializable {
    
    @Inject
    private UsuarioService usuarioService;
    
    public UsuarioController() {
        super(Usuario.class);
    }
    
    @Override
    protected AbstractService getService() {
        return usuarioService;
    }
}
