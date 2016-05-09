package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.model.Estado;
import br.com.service.EstadoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author barizon
 */
@Named
@ViewScoped
public class EstadoController implements Serializable {
    
    private Estado estado;
    private boolean viewList = true;
    private boolean viewForm = false;
    @Inject
    private EstadoService estadoService;
    private GenericConverter genericConverter;
    
    public GenericConverter converter() {
        if(genericConverter == null) {
            genericConverter = new GenericConverter(estadoService);
        }
        return genericConverter;
    }
    
    public void criaEstado() {
        try {
            estado = new Estado();
            viewList = false;
            viewForm = true;
        } catch (Exception ex) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void alterar() {
        viewList = false;
        viewForm = true;
    }
    
    public String salvar() {
        estado = estadoService.salvar(estado);
        return "listagem?faces-redirect=true";
    }
    
    public void excluir() {
        estadoService.excluir(estado);
    }

    public List<Estado> getListaEstado() {
        return estadoService.listar();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean getViewList() {
        return viewList;
    }

    public void setViewList(boolean viewList) {
        this.viewList = viewList;
    }

    public boolean getViewForm() {
        return viewForm;
    }

    public void setViewForm(boolean viewForm) {
        this.viewForm = viewForm;
    }
}
