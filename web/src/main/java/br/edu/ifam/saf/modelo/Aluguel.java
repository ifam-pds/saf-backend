/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.saf.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author erick.araujo
 */
@Entity
public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Usuario cliente_codigo;
    @ManyToOne
    private Usuario cliente_cpf;
    @ManyToOne
    private Usuario funcionario_codigo;
    @ManyToOne
    private Item item_codigo;
    
    @Column(nullable = false)
    private Timestamp dataInicio;
    @Column(nullable = true)
    private Timestamp dataDevolucao;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(Usuario cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public Usuario getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(Usuario cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public Usuario getFuncionario_codigo() {
        return funcionario_codigo;
    }

    public void setFuncionario_codigo(Usuario funcionario_codigo) {
        this.funcionario_codigo = funcionario_codigo;
    }

    public Item getItem_codigo() {
        return item_codigo;
    }

    public void setItem_codigo(Item item_codigo) {
        this.item_codigo = item_codigo;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Timestamp dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.edu.ifam.saf.modelo.Aluguel[ id=" + id + " ]";
    }
    
}
