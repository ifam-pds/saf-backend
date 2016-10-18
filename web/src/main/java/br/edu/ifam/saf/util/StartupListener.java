package br.edu.ifam.saf.util;

import br.edu.ifam.saf.modelo.Bairro;
import br.edu.ifam.saf.modelo.Cidade;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Logger;

public class StartupListener implements ServletContextListener {

    @PersistenceContext
    private EntityManager em;

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        popularLocais();

    }

    private void popularLocais() {
        TypedQuery<Cidade> query = em.createQuery("select c from Cidade c", Cidade.class);

        query.setMaxResults(1);
        List<Cidade> cidades = query.getResultList();

        if (cidades.isEmpty()) {
            UserTransaction transaction = getTransaction();
            try {
                transaction.begin();
                Cidade cidade = new Cidade();
                cidade.setNome("Manaus");
                cidade.setEstado("Amazonas");

                cidade = em.merge(cidade);

                Bairro bairro = new Bairro();
                bairro.setNome("Centro");

                bairro.setCidade(cidade);
                em.merge(bairro);

                transaction.commit();
                Logger.getLogger(StartupListener.class.getName()).info("Cidade cadastrada");
            } catch (Throwable e) {
                try {
                    transaction.rollback();
                } catch (SystemException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }

        }


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private UserTransaction getTransaction() {
        UserTransaction transaction = null;
        try {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
