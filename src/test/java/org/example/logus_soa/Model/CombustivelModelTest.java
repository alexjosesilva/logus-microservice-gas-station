package org.example.logus_soa.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombustivelModelTest {

    @Test
    public void testGetNome() {
        String nomeEsperado = "Gasolina";
        CombustivelModel combustivel = new CombustivelModel(nomeEsperado);
        assertEquals(nomeEsperado, combustivel.getNome());
    }

    @Test
    public void testSetNome() {
        String novoNome = "Diesel";
        CombustivelModel combustivel = new CombustivelModel();
        combustivel.setNome(novoNome);
        assertEquals(novoNome, combustivel.getNome());
    }

    @Test
    public void testGetId() {
        Long idEsperado = 1L;
        CombustivelModel combustivel = new CombustivelModel();
        combustivel.setId(idEsperado);
        assertEquals(idEsperado, combustivel.getId());
    }

    @Test
    public void testSetId() {
        Long novoId = 2L;
        CombustivelModel combustivel = new CombustivelModel();
        combustivel.setId(novoId);
        assertEquals(novoId, combustivel.getId());
    }
}
