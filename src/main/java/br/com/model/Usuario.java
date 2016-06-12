package br.com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "USUARIO")
public class Usuario extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "USUARIO_NOME")
    private String nome;
    @Column(name = "USUARIO_LOGIN")
    private String login;
    @Column(name = "USUARIO_SENHA")
    private String senha;
    @Column(name = "USUARIO_NIVEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;
    
    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
