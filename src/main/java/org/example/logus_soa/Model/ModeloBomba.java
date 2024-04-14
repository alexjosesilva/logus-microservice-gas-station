package org.example.logus_soa.Model;

public class ModeloBomba {
    private  long id;
    private String nomeCombustivel;

    public long getId() {
        return id;
    }

    public void setId(long ind) {
        this.id = ind;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }
}
