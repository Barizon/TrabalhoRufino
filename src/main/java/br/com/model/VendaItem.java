package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author barizon
 */
@Entity
@Table(name = "VENDAITEM")
public class VendaItem extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "QUANTIDADE_VITEM")
    private BigDecimal quantidade;
    @Column(name = "PRECO_VITEM")
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "VENDA_ID", nullable = false)
    private Venda venda;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUTO_ID", nullable = false)
    private Produto produto;

    public VendaItem() {
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaItem other = (VendaItem) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return id.toString();
    }

    
        
}
