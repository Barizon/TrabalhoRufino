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
@Table(name = "PESSOAFISICA")
public class PessoaFisica extends Pessoa implements Serializable {
    
    @Column(name = "PESSOA_CPF", unique = true) //nullable = false
    private String cpf;
    @Column(name = "PESSOA_RG", unique = true) //nullable = false
    private String rg;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
}
