package JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "pedido")
public class PedidoJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dataVenda, formaPagamento, status;
    private int quantidade, produto_id, cliente_id;
    private boolean paraEntregar;

    public PedidoJPA(String dataVenda, String formaPagamento, String status, int quantidade, int produto_id, int cliente_id, boolean paraEntregar) {
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.quantidade = quantidade;
        this.produto_id = produto_id;
        this.cliente_id = cliente_id;
        this.paraEntregar = paraEntregar;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    
    public PedidoJPA() {
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isParaEntregar() {
        return paraEntregar;
    }

    public void setParaEntregar(boolean paraEntregar) {
        this.paraEntregar = paraEntregar;
    }
}
