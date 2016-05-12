package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "CLIENTE_CREDITO")
    private BigDecimal credito;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PESSOA_ID", unique = true, nullable = false) 
    private Pessoa pessoa;

    public Cliente() {
    }
    
    public Cliente(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return id.toString();
    }
   
}
