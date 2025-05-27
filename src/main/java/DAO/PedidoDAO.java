package DAO;

import JPA.PedidoJPA;
import com.mycompany.projeto_integrador.JPAUtil;
import com.mycompany.projeto_integrador.jTableDados;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void cadastrar(PedidoJPA p) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<jTableDados> listar() {
        EntityManager manager = JPAUtil.conectar();

        try {
            Query sql = manager.createNativeQuery("SELECT pr.nome AS nome_produto,"
                    + "c.nome AS nome_cliente,"
                    + "pr.valor AS valor_produto,"
                    + "p.dataVenda,"
                    + "p.paraEntregar,"
                    + "p.status, "
                    + "p.quantidade,"
                    + "p.formaPagamento "
                    + "FROM pedido p "
                    + "JOIN cliente c ON p.cliente_id = c.id "
                    + "JOIN produto pr ON p.produto_id = pr.id;");
            List<Object[]> resultados = sql.getResultList();
            List<jTableDados> dados = new ArrayList<>();

            for (Object[] linha : resultados) {
                jTableDados dado = new jTableDados();
                dado.setProduto((String) linha[0]);
                dado.setCliente((String) linha[1]);
                dado.setValor((Double) linha[2]);
                dado.setData(linha[3].toString());
                dado.setParaEntregar((Boolean) linha[4]);
                dado.setStatus((String) linha[5]);
                dado.setQuantidade((int) linha[6]);
                dado.setFormaPagamento((String) linha[7]);
                dados.add(dado);
            }
            return dados;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return new ArrayList<>();
        } finally {
            JPAUtil.desconectar();
        }
    }
}
