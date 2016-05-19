package br.com.service;

import br.com.model.Venda;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author barizon
 * @param <T>
 */

public abstract class AbstractService<T> implements Serializable{
    
    private final Class<T> classe;
    
    public AbstractService(Class<T> classe) {
        this.classe = classe;
    }
    
    public abstract EntityManager getEm();
    
    public T salvar(T entidade) throws Exception {
        if (entidade instanceof Venda) {
            Venda v = (Venda) entidade;
            v.movimenta();
            v.validarVenda();
        }
        entidade = getEm().merge(entidade);
        return entidade;
    }
    
    public void excluir(T entidade) {
        getEm().remove(getEm().merge(entidade));
    }
    
    public T pesquisar(Object id) {
        T entidade = getEm().find(classe, id);
        return entidade;
    }
    
    public List<T> listar() {
        return getEm().createQuery("FROM " + classe.getSimpleName()).getResultList();
    }
}
