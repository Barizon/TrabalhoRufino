package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private Date dataVenda = new Date();
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, 
            mappedBy = "venda", 
            fetch = FetchType.LAZY, 
            orphanRemoval = true)
    private List<VendaItem> vendaItens = new ArrayList<>();
    
    @Column(name = "VENDA_TIPO", nullable = true)
    @Enumerated(EnumType.STRING)
    private VendaTipo vendaTipo = VendaTipo.FINALIZADA;

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
    
    public void estornaVenda() {
        for (VendaItem vitens : vendaItens) {
            vitens.getProduto().voltaEstoque(vitens.getQuantidade());
        }
        vendaTipo = VendaTipo.ESTORNADA;
    }
    
    public void adicionaItem(VendaItem item) throws Exception {
        item.setVenda(this);
        if (!vendaItens.contains(item)){
            item.setPreco(item.getProduto().getPreco());
            vendaItens.add(item);
            calcularTotal();
            //validar estoque
        } else {
            throw new Exception("O produto " + item.getProduto().getNome() 
                    + " já foi adicionado à venda");
        }
    }
    
    public void movimenta() throws Exception {
        for (VendaItem item : vendaItens) {
            item.getProduto().baixaEstoque(item.getQuantidade());
        } 
    }
    
    public void validarVenda() throws Exception {
        if (vendaItens.isEmpty()) {
            throw new Exception("Não é possivel salvar uma venda sem itens");
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     public List<VendaItem> getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(List<VendaItem> vendaItens) {
        this.vendaItens = vendaItens;
    }
    
    public VendaTipo getVendaTipo() {
        return vendaTipo;
    }

    public void setVendaTipo(VendaTipo vendaTipo) {
        this.vendaTipo = vendaTipo;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
