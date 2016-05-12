package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.model.Cliente;
import br.com.service.AbstractService;
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
public class ClienteController extends AbstractController<Cliente> implements Serializable {
    
   @Inject
   private ClienteService clienteService;
   
   public ClienteController() {
       super(Cliente.class);
   }
   
   @Override
   protected AbstractService getService() {
       return clienteService;
   }
       
}
