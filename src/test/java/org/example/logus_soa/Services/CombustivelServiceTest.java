package org.example.logus_soa.Services;

import org.example.logus_soa.Model.CombustivelModel;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombustivelServiceTest {

    @Test
    void salvarCombustivelCSV_DeveSalvarCombustivel() {
        // Arrange
        CombustivelService combustivelService = new CombustivelService();
        CombustivelModel combustivel = new CombustivelModel();
        combustivel.setNome("Gasolina");

        // Act
        combustivelService.salvarCombustivelCSV(combustivel);

        // Assert
        List<CombustivelModel> combustiveis = combustivelService.lerCombustivelCSV();
        assertEquals(1, combustiveis.size());
        assertEquals("Gasolina", combustiveis.get(0).getNome());
    }

    @Test
    void lerCombustivelCSV_DeveLerCombustiveis() {
        // Arrange
        CombustivelService combustivelService = new CombustivelService();

        // Act
        List<CombustivelModel> combustiveis = combustivelService.lerCombustivelCSV();

        // Assert
        assertFalse(combustiveis.isEmpty());
    }
}
