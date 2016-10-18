package br.edu.ifam.saf.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author erick.araujo
 */

@Entity
public class Item extends EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private Integer quantidade;
    private String descricao;
    private Boolean status;
    private Double valor;
    
    @ManyToOne
    private Categoria categoria_codigo;

    public Item() {
    }

    public Item(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Categoria getCategoria_codigo() {
        return categoria_codigo;
    }

    public void setCategoria_codigo(Categoria categoria_codigo) {
        this.categoria_codigo = categoria_codigo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        return !((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome)));
    }

    @Override
    public String toString() {
        return "br.edu.ifam.saf.modelo.Categoria[ nome=" + nome + " ]";
    }
    
}
