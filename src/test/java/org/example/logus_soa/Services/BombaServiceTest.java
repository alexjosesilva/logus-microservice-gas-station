package org.example.logus_soa.Services;

import org.example.logus_soa.Model.BombaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BombaServiceTest {

    private BombaService bombaService;
    private static final String CSV_FILE_PATH = "src/test/resources/csv/test_bombagasolina.csv";

    @BeforeEach
    void setUp() {
        bombaService = new BombaService();
    }

    @Test
    void salvarBombaCSV_DeveSalvarUmaBombaNoArquivo() throws IOException {
        // Arrange
        BombaModel bomba = new BombaModel();
        bomba.setNomeCombustivel("Gasolina");

        // Act
        bombaService.salvarBombaCSV(bomba);

        // Assert
        BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));
        String linha;
        int linhasNoArquivo = 0;
        while ((linha = reader.readLine()) != null) {
            linhasNoArquivo++;
        }
        reader.close();
        assertEquals(2, linhasNoArquivo); // Verifica se houve adição de uma linha além do cabeçalho
    }

    @Test
    void lerBombaCSV_DeveLerAsBombasDoArquivo() throws IOException {
        // Arrange
        criarArquivoCSVTeste();

        // Act
        List<BombaModel> bombas = bombaService.lerBombaCSV();

        // Assert
        assertEquals(2, bombas.size()); // Verifica se foram lidas duas bombas do arquivo
        assertEquals("Gasolina", bombas.get(0).getNomeCombustivel());
        assertEquals("Diesel", bombas.get(1).getNomeCombustivel());
    }

    private void criarArquivoCSVTeste() throws IOException {
        PrintWriter writer = new PrintWriter(CSV_FILE_PATH);
        writer.println("ID,NomeCombustivel");
        writer.println("123456789,Gasolina");
        writer.println("987654321,Diesel");
        writer.close();
    }
}

