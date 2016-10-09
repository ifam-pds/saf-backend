package br.edu.ifam.saf.dao;


import javax.persistence.EntityManager;
import java.util.List;


public class GenericDAO<E> {

    private final EntityManager em;
    private final Class<E> classe;

    public GenericDAO(EntityManager em, Class<E> classe) {
        this.em = em;
        this.classe = classe;
    }

    public void inserir(E entidade) {
        em.persist(entidade);
    }

    public E consultar(Integer id) {
        return em.find(classe, id);
    }

    public List<E> listarTodos() {
        return em.createQuery("select o from " + classe.getName() + " o", classe).getResultList();
    }

    public void remover(E entidade) {
        em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
    }

    public E atualizar(E entidade) {
        return em.merge(entidade);
    }

}