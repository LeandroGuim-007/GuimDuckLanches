package DAO;

import JPA.ClienteJPA;
import com.mycompany.projeto_integrador.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void cadastrar(ClienteJPA c) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<ClienteJPA> listar() {
        EntityManager manager = JPAUtil.conectar();
        List<ClienteJPA> clientes = new ArrayList<ClienteJPA>();

        try {
            Query sql = manager.createQuery("select c from cliente c");
            clientes = sql.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static int getId(String nome) {
        EntityManager manager = JPAUtil.conectar();
        int id = -1;

        try {
            Query sql = manager.createQuery("select c.id from cliente c where c.nome = :nome");
            sql.setParameter("nome", nome);
            id = (int) sql.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JPAUtil.desconectar();
        }
        return id;
    }

    public static List<ClienteJPA> getDados(String nome) {
        EntityManager manager = JPAUtil.conectar();
        List<ClienteJPA> clientes = new ArrayList<ClienteJPA>();

        try {
            Query sql = manager.createQuery("select c from cliente c where c.nome = :nome");
            sql.setParameter("nome", nome);
            clientes = sql.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JPAUtil.desconectar();
        }
        return clientes;
    }
}
