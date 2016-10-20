package br.edu.ifam.saf.dao;

import br.edu.ifam.saf.modelo.Item;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemDAO {
    private GenericDAO dao;
    
    @PersistenceContext
    EntityManager em;
    
    @PostConstruct
    public void init(){
        dao = new GenericDAO(em, Item.class);
    }

    public void inserir(Object entidade) {
        dao.inserir(entidade);
    }

    public Object consultar(Integer id) {
        return dao.consultar(id);
    }

    public List listarTodos() {
        return dao.listarTodos();
    }

    public void remover(Object entidade) {
        dao.remover(entidade);
    }

    public Object atualizar(Object entidade) {
        return dao.atualizar(entidade);
    }
    
    
}
