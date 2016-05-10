package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.model.Cidade;
import br.com.service.CidadeService;
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
public class CidadeController implements Serializable {
    
    private Cidade cidade;
    private boolean viewList = true;
    private boolean viewForm = false;
    @Inject
    private CidadeService cidadeService;
    private GenericConverter genericConverter;
    
    public GenericConverter converter() {
        if(genericConverter == null) {
            genericConverter = new GenericConverter(cidadeService);
        }
        return genericConverter;
    }
    
    public void criaCidade() {
        try {
            cidade = new Cidade();
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
        cidade = cidadeService.salvar(cidade);
        return "listagem?faces-redirect=true";
    }
    
    public void excluir() {
        cidadeService.excluir(cidade);
    }
    
    public List<Cidade> getListaCidade() {
        return cidadeService.listar();
    }
    
    public Cidade getCidade() {
        return cidade;
    }
    
    public void setCidade(Cidade estado) {
        this.cidade = estado;
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
