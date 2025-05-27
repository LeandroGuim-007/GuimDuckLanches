package DAO;

import JPA.BebidaJPA;
import com.mycompany.projeto_integrador.JPAUtil;
import jakarta.persistence.EntityManager;

public class BebidaDAO {

    public void Cadastrar(BebidaJPA bd) {
        EntityManager manager = JPAUtil.conectar();
        
        try{
            manager.getTransaction().begin();
            manager.persist(bd);
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally{
            JPAUtil.desconectar();
        }
    }
}
