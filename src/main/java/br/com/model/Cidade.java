package br.com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "CIDADE")
public class Cidade extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "CIDADE_NOME")
    private String nome;
    @Column(name = "CIDADE_CODIBGE")
    private String codIbge;


    public Cidade() {
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
        
    @Override
    public String toString() {
        return id.toString();
    }

}
