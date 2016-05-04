package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 *
 * @author barizon
 */
@Entity
@Table(name = "VENDA")
public class Venda extends AbstractModelIdentifier implements Serializable {
    
    @Column(name = "VENDA_TOTAL")
    private BigDecimal total;
    @Column(name = "VENDA_DESCONTO")
    private BigDecimal desconto;
    @Column(name = "DATA_VENDA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;
    @ManyToOne
    @JoinColumn(name = "PESSOA_ID", nullable = false)
    private Pessoa pessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<VendaItem> vendaItem;
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    public Venda() {
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
     public List<VendaItem> getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(List<VendaItem> vendaItem) {
        this.vendaItem = vendaItem;
    }
    
     public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return id.toString();
    }

   
    
    
}
