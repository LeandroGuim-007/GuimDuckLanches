package JPA;

import jakarta.persistence.Entity;

@Entity(name = "bebida")
public class BebidaJPA extends ProdutoJPA{
   
    private int mls;
    private String sabor, marca;
    private boolean comGas, comAlcool;

    public BebidaJPA(int mls, String sabor, String marca, boolean comGas, boolean comAlcool) {
        this.mls = mls;
        this.sabor = sabor;
        this.marca = marca;
        this.comGas = comGas;
        this.comAlcool = comAlcool;
    }

    public BebidaJPA() {
    }

    public int getMls() {
        return mls;
    }

    public void setMls(int mls) {
        this.mls = mls;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isComGas() {
        return comGas;
    }

    public void setComGas(boolean comGas) {
        this.comGas = comGas;
    }

    public boolean isComAlcool() {
        return comAlcool;
    }

    public void setComAlcool(boolean comAlcool) {
        this.comAlcool = comAlcool;
    }
}
