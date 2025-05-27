package com.mycompany.projeto_integrador;

public class jTableDados {
    private String produto, cliente, data, status, formaPagamento;
    private double valor;
    private boolean paraEntregar;
    private int quantidade;

    public jTableDados() {
    }

    public jTableDados(String produto, String cliente, String data, String status, String pagamento, int quantidade, double valor, boolean paraEntregar) {
        this.produto = produto;
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.paraEntregar = paraEntregar;
        this.quantidade = quantidade;
        this.formaPagamento = pagamento;
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

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isParaEntregar() {
        return paraEntregar;
    }

    public void setParaEntregar(boolean paraEntregar) {
        this.paraEntregar = paraEntregar;
    }
}
