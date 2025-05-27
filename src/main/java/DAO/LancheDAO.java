package DAO;

import JPA.ClienteJPA;
import JPA.LancheJPA;
import JPA.ProdutoJPA;
import com.mycompany.projeto_integrador.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LancheDAO {

    public void cadastrar(LancheJPA l) {
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

    public static List<ProdutoJPA> Listar(boolean lanche, boolean bebida, boolean preco) {
        EntityManager manager = JPAUtil.conectar();
        List<ProdutoJPA> produtos = new ArrayList<ProdutoJPA>();

        try {
            if (lanche && !preco) {
                Query sql = manager.createQuery("Select l from lanche l order by l.valor");
                produtos.addAll(sql.getResultList());
            } else if (lanche) {
                Query sql = manager.createQuery("Select l from lanche l order by l.valor desc");
                produtos.addAll(sql.getResultList());
            }
            if (bebida && !preco) {
                Query sql = manager.createQuery("Select b from bebida b order by b.valor");
                produtos.addAll(sql.getResultList());
            } else if (bebida) {
                Query sql = manager.createQuery("Select b from bebida b order by b.valor desc");
                produtos.addAll(sql.getResultList());
            }
            return produtos;
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return null;
    }

    public static int getId(String nome) {
        EntityManager manager = JPAUtil.conectar();        
        int id = -1;
        
        try {
            Query sql = manager.createQuery("select p.id from produto p where p.nome = :nome");
            sql.setParameter("nome", nome);
            id = (int) sql.getSingleResult();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return id;
    }
    
    public static List<ProdutoJPA> getDados(String nome) {
        EntityManager manager = JPAUtil.conectar();
        List<ProdutoJPA> produtos = new ArrayList<ProdutoJPA>();

        try {
            Query sql = manager.createQuery("select p from produto p where p.nome = :nome");
            sql.setParameter("nome", nome);
            produtos = sql.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JPAUtil.desconectar();
        }
        return produtos;
    }
}
