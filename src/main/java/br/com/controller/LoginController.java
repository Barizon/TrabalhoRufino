package br.com.controller;

import br.com.model.Usuario;
import br.com.service.UsuarioService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author barizon
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    
    @Inject
    private UsuarioService usuarioService;
    private Usuario usuario;
    private String login;
    private String senha;
    private boolean logado = false;
    
    public String logar() {
        usuario = usuarioService.pesquisaUsuario(login, senha);
//        System.out.println(usuario.getLogin());
        if (usuario != null || (login.equals("admin") && senha.equals("admin"))) {
            logado = true;
            return "app/index?faces-redirect=true";
        } else {
            logado = false;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário não encontrado no sistema", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }
    
    public String logoff() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        return "/login?faces-redirect=true";
    }

    public boolean getLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
