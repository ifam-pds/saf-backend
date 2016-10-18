package br.edu.ifam.saf.modelo;

import com.google.common.base.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "aluguel")
public class Aluguel extends EntidadeBase {

    @ManyToOne(optional = false)
    private Usuario cliente;

    @ManyToOne
    private Usuario funcionario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aluguel", orphanRemoval = true)
    private List<ItemAluguel> itens = new ArrayList<>();


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dataHoraDevolucao;

    @Enumerated(EnumType.STRING)
    private StatusAluguel status;

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemAluguel> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void setItens(List<ItemAluguel> itens) {
        Preconditions.checkNotNull(itens, "lista de itens não deve ser nula");
        this.itens = itens;
        for (ItemAluguel item : itens) {
            item.setAluguel(this);
        }
    }

    public Calendar getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Calendar dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Calendar getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Calendar dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public void adicionarItem(ItemAluguel itemAluguel) {
        Preconditions.checkNotNull(itemAluguel, "itemAluguel não deve ser nulo");
        Preconditions.checkNotNull(itemAluguel.getItem(), "itemAluguel.item não deve ser nulo");

        if (!itens.contains(itemAluguel)) {
            itens.add(itemAluguel);
        }

        if (!this.equals(itemAluguel.getAluguel())) {
            itemAluguel.setAluguel(this);
        }
    }


    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Aluguel aluguel = (Aluguel) o;

        if (cliente != null ? !cliente.equals(aluguel.cliente) : aluguel.cliente != null) return false;
        if (funcionario != null ? !funcionario.equals(aluguel.funcionario) : aluguel.funcionario != null) return false;
        if (dataHoraInicio != null ? !dataHoraInicio.equals(aluguel.dataHoraInicio) : aluguel.dataHoraInicio != null)
            return false;
        if (dataHoraDevolucao != null ? !dataHoraDevolucao.equals(aluguel.dataHoraDevolucao) : aluguel.dataHoraDevolucao != null)
            return false;
        return status == aluguel.status;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (funcionario != null ? funcionario.hashCode() : 0);
        result = 31 * result + (dataHoraInicio != null ? dataHoraInicio.hashCode() : 0);
        result = 31 * result + (dataHoraDevolucao != null ? dataHoraDevolucao.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}

