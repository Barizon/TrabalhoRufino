package br.com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "ESTADO")
public class Estado extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "ESTADO_NOME")
    private String nome;
    @Column(name = "ESTADO_CODIBGE")
    private String codIbge;
    @Column(name = "ESTADO_UF")
    private String uf;
    

    public Estado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
    
}
