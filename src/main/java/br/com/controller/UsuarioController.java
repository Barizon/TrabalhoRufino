package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.model.NivelAcesso;
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
    private GenericConverter genericConverter;
    
    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(usuarioService);
        }
        return genericConverter;
    }
    
    public UsuarioController() {
        super(Usuario.class);
    }
    
    public NivelAcesso[] getNiveisAcesso() {
        return NivelAcesso.values();
    }
    
    @Override
    protected AbstractService getService() {
        return usuarioService;
    }
}
