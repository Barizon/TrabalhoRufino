package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "NOME_PRODUTO")
    private String nome;
    @Column(name = "NCM_PRODUTO")
    private String ncm;
    @Column(name = "PRECO_PRODUTO")
    private BigDecimal preco;
    @Column(name = "ESTOQUE_PRODUTO")
    private BigDecimal estoque;
    @Column(name = "UNID_PRODUTO")
    private String unidadeMedida;

    public Produto() {
    }

    public void baixaEstoque(BigDecimal qtde) throws Exception {
        if (estoque.compareTo(qtde) > 0) {
            estoque = estoque.subtract(qtde);
        } else {
            throw new Exception("Quantidade em estoque insuficiente.");
        }
    }
    
    public void voltaEstoque(BigDecimal qtde) {
        estoque = estoque.add(qtde);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return id.toString();
    }
        
}
