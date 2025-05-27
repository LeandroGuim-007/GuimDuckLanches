package JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "produto")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProdutoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome, informacaoNutricional, imagem;
    private double valor;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String Imagem) {
        this.imagem = Imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacaoNutricional() {
        return informacaoNutricional;
    }

    public void setInformacaoNutricional(String informacaoNutricional) {
        this.informacaoNutricional = informacaoNutricional;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
