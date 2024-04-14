package org.example.logus_soa.Model;


public class ModeloVeiculo {

    private Long id;
    private String nomeModelo;
    private double consumoEtanol;
    private double consumoGasolina;
    private double consumoDiesel;

    public ModeloVeiculo(){

    }
    public ModeloVeiculo(Long id, String nomeModelo, double consumoEtanol, double consumoGasolina, double consumoDiesel) {
        this.id = id;
        this.nomeModelo = nomeModelo;
        this.consumoEtanol = consumoEtanol;
        this.consumoGasolina = consumoGasolina;
        this.consumoDiesel = consumoDiesel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public double getConsumoEtanol() {
        return consumoEtanol;
    }

    public void setConsumoEtanol(double consumoEtanol) {
        this.consumoEtanol = consumoEtanol;
    }

    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(double consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }

    public double getConsumoDiesel() {
        return consumoDiesel;
    }

    public void setConsumoDiesel(double consumoDiesel) {
        this.consumoDiesel = consumoDiesel;
    }
}

