package br.com.model;

/**
 *
 * @author barizon
 */
public enum NivelAcesso {
    ADMIN("Administrador"),
    USER("Usuário");
    
    private final String descricao;
    
    private NivelAcesso(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
