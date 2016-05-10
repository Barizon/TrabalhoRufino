package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.model.Cliente;
import br.com.service.ClienteService;
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
public class ClienteController implements Serializable {
    
    private Cliente cliente;
    private boolean viewList = true;
    private boolean viewForm = false;
    @Inject
    private ClienteService clienteService;
    private GenericConverter genericConverter;
    
    public GenericConverter converter() {
        if(genericConverter == null) {
            genericConverter = new GenericConverter(clienteService);
        }
        return genericConverter;
    }
    
    
}
