package org.example.logus_soa.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeiculoModelTest {

    @Test
    public void testGetterSetterId() {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setId(1L);
        assertEquals(1L, veiculo.getId().longValue());
    }

    @Test
    public void testGetterSetterNomeModelo() {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setNomeModelo("Fusca");
        assertEquals("Fusca", veiculo.getNomeModelo());
    }

    @Test
    public void testGetterSetterConsumoEtanol() {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setConsumoEtanol(10.5);
        assertEquals(10.5, veiculo.getConsumoEtanol(), 0);
    }

    @Test
    public void testGetterSetterConsumoGasolina() {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setConsumoGasolina(15.3);
        assertEquals(15.3, veiculo.getConsumoGasolina(), 0);
    }

    @Test
    public void testGetterSetterConsumoDiesel() {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setConsumoDiesel(20.7);
        assertEquals(20.7, veiculo.getConsumoDiesel(), 0);
    }

    @Test
    public void testConstructorWithArgs() {
        VeiculoModel veiculo = new VeiculoModel(1L, "Gol", 9.5, 14.2, 18.3);
        assertEquals(1L, veiculo.getId().longValue());
        assertEquals("Gol", veiculo.getNomeModelo());
        assertEquals(9.5, veiculo.getConsumoEtanol(), 0);
        assertEquals(14.2, veiculo.getConsumoGasolina(), 0);
        assertEquals(18.3, veiculo.getConsumoDiesel(), 0);
    }
}

