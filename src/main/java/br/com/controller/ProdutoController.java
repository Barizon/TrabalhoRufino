package br.com.controller;

import br.com.model.Produto;
import br.com.service.AbstractService;
import br.com.service.ProdutoService;
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
public class ProdutoController extends AbstractController<Produto> implements Serializable {
    
    @Inject
    private ProdutoService produtoService;
    
    public ProdutoController() {
        super(Produto.class);
    }
    
    @Override
    protected AbstractService getService() {
        return produtoService;
    }
}
