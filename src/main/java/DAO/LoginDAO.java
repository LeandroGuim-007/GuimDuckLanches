package DAO;

import JPA.LoginJPA;
import com.mycompany.projeto_integrador.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginDAO {

    public void cadastrar(LoginJPA l) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();
            manager.persist(l);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public LoginJPA validar(String login, String senha) {
        EntityManager manager = JPAUtil.conectar();

        try {
            Query sql = manager.createQuery("Select l from login l where :login = l.login and :senha = l.senha");
            sql.setParameter("login", login);
            sql.setParameter("senha", senha);
            List<LoginJPA> logins = sql.getResultList();

            if (!logins.isEmpty()) {
                return logins.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JPAUtil.desconectar();
        }
        return null;
    }
}
