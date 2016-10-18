package br.edu.ifam.saf.modelo;

import java.io.Serializable;
import java.sql.Date;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Usuario extends EntidadeBase implements Serializable {
    @Column(nullable = false, unique = true)
    private int cpf;
    
    private String nome;
    private Date dt_nascimento;
    private String telefone;
    private String carteira_habilitacao;
    
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 64)
    private String token;
    @JsonIgnore
    @Column(nullable = false, length = 60)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCarteira_habilitacao() {
        return carteira_habilitacao;
    }

    public void setCarteira_habilitacao(String carteira_habilitacao) {
        this.carteira_habilitacao = carteira_habilitacao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        return email != null ? email.equals(usuario.email) : usuario.email == null && (senha != null ? senha.equals(usuario.senha) : usuario.senha == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}
