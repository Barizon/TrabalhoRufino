package br.com.controller;

import br.com.converter.GenericConverter;
import br.com.service.AbstractService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author barizon
 * @param <T>
 */
public abstract class AbstractController<T> implements Serializable {

    private T entidade;
    private Class<T> classe;
    private GenericConverter genericConverter;
    private boolean viewList = true;
    private boolean viewForm = false;

    public AbstractController(Class<T> classe) {
        this.classe = classe;
    }

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(getService());
        }
        return genericConverter;
    }

    protected abstract AbstractService getService();

    public void cria() {
        try {
            entidade = classe.newInstance();
            viewList = false;
            viewForm = true;
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvar() {
        try {
            getService().salvar(entidade);
            return "listagem?faces-redirect=true";
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }

    public void excluir() {
        getService().excluir(entidade);
    }

    public List<T> getListaEntidade() {
        return getService().listar();
    }

    public void alterar() {
        viewList = false;
        viewForm = true;
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

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

}
