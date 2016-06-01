package br.com.model;

/**
 *
 * @author barizon
 */
public enum VendaTipo {
    ESTORNADA("Estornada"), FINALIZADA("Finalizada");
    
    private final String descricao;
    
    private VendaTipo(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
