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
    private List<VendaItem> vendaItens;
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    public Venda() {
    }

    public void calcularTotal() {
        if (desconto == null || desconto.compareTo(total) >= 0) {
            desconto = BigDecimal.ZERO;
        }
        total = BigDecimal.ZERO;
        for (VendaItem vitens : vendaItens) {
            total = total.add(vitens.getPreco().multiply(vitens.getQuantidade()));
        }
        total = total.subtract(desconto);
    }
    
    public void adicionaItem(VendaItem item) throws Exception {
        item.setVenda(this);
        if (!vendaItens.contains(item)){
            item.setPreco(item.getProduto().getPreco());
            vendaItens.add(item);
            calcularTotal();
            item.getProduto().baixaEstoque(item.getQuantidade());
        } else {
            throw new Exception("O produto" + item.getProduto().getNome() 
                    + "já foi adicionado à venda");
        }
    }
    
    public void removeItem(VendaItem item) {
        vendaItens.remove(item);
        calcularTotal();
        item.getProduto().voltaEstoque(item.getQuantidade());
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
    
     public List<VendaItem> getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(List<VendaItem> vendaItens) {
        this.vendaItens = vendaItens;
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
