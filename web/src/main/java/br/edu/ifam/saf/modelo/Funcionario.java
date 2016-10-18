/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.saf.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author erick.araujo
 */

@Entity
public class Funcionario extends EntidadeBase {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String usuario;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private Perfil perfil_funcionario;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil_funcionario() {
        return perfil_funcionario;
    }

    public void setPerfil_funcionario(Perfil perfil_funcionario) {
        this.perfil_funcionario = perfil_funcionario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifam.saf.modelo.Funcionario[ usuario=" + usuario + " ]";
    }
    
}
