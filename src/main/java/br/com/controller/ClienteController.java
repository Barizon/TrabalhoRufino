package br.com.controller;

import br.com.model.Cliente;
import br.com.model.PessoaFisica;
import br.com.model.PessoaJuridica;
import br.com.service.AbstractService;
import br.com.service.ClienteService;
import java.io.Serializable;
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
public class ClienteController extends AbstractController<Cliente> implements Serializable {

    private String tipoPessoa = "PF";
    
    @Inject
    private ClienteService clienteService;

    public ClienteController() {
        super(Cliente.class);
    }

    @Override
    protected AbstractService getService() {
        return clienteService;
    }

    @Override
    public void cria() {
        try {
            setViewList(false); 
            setViewForm(true);
            if (tipoPessoa.equals("PF")) {
                setEntidade(new Cliente(new PessoaFisica()));
            } else {
                setEntidade(new Cliente(new PessoaJuridica()));
            }
        } catch (Exception ex) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    
    @Override
    public void alterar() {
        setViewList(false); 
        setViewForm(true);
        if (getEntidade().getPessoa() instanceof PessoaFisica) {
            tipoPessoa = "PF";
        } else {
            tipoPessoa = "PJ";
        }
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

        
}
