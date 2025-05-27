
package JPA;

import jakarta.persistence.Entity;

@Entity(name = "lanche")
public class LancheJPA extends ProdutoJPA{

    private String ingredientes;
    private double peso;

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
