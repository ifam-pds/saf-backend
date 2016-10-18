package br.edu.ifam.saf.modelo;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeBase {

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataNascimento;

    private String telefone;
    private String numeroHabilitacao;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 64)
    private String token;

    @Column(nullable = false, length = 60)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;

    private String endereco;

    @ManyToOne(optional = false)
    private Bairro bairro;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumeroHabilitacao() {
        return numeroHabilitacao;
    }

    public void setNumeroHabilitacao(String numeroHabilitacao) {
        this.numeroHabilitacao = numeroHabilitacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        if (nome != null ? !nome.equals(usuario.nome) : usuario.nome != null) return false;
        if (cpf != null ? !cpf.equals(usuario.cpf) : usuario.cpf != null) return false;
        if (dataNascimento != null ? !dataNascimento.equals(usuario.dataNascimento) : usuario.dataNascimento != null)
            return false;
        if (telefone != null ? !telefone.equals(usuario.telefone) : usuario.telefone != null) return false;
        if (numeroHabilitacao != null ? !numeroHabilitacao.equals(usuario.numeroHabilitacao) : usuario.numeroHabilitacao != null)
            return false;
        if (email != null ? !email.equals(usuario.email) : usuario.email != null) return false;
        if (token != null ? !token.equals(usuario.token) : usuario.token != null) return false;
        if (senha != null ? !senha.equals(usuario.senha) : usuario.senha != null) return false;
        if (perfil != usuario.perfil) return false;
        if (endereco != null ? !endereco.equals(usuario.endereco) : usuario.endereco != null) return false;
        return bairro != null ? bairro.equals(usuario.bairro) : usuario.bairro == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (numeroHabilitacao != null ? numeroHabilitacao.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (perfil != null ? perfil.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        return result;
    }
}
