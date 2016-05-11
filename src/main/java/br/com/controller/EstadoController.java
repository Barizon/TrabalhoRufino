package br.com.controller;

import br.com.model.Estado;
import br.com.service.AbstractService;
import br.com.service.EstadoService;
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
public class EstadoController extends AbstractController<Estado> implements Serializable {

    @Inject
    private EstadoService estadoService;

    public EstadoController() {
        super(Estado.class);
    }

    @Override
    protected AbstractService getService() {
        return estadoService;
    }
}
