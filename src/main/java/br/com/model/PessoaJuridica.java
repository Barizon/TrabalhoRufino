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
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa implements Serializable {
    
    @Column(name = "PESSOA_CNPJ", unique = true, nullable = false) 
    private String cnpj;
    @Column(name = "PESSOA_IE", nullable = false) 
    private String ie;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
    
}
