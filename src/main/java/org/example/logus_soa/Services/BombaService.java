package org.example.logus_soa.Services;

import org.example.logus_soa.Model.ModeloBomba;
import org.example.logus_soa.Model.ModeloCombustivel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BombaService {

    private static final String CSV_FILE_PATH = "src/main/resources/csv/bombagasolina.csv";

    public void salvarBombaCSV(ModeloBomba bomba) {

        // Gerar um ID aleatório
        long id = gerarIdAleatorio();

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.println(id + "," + bomba.getNomeCombustivel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ModeloBomba> lerBombaCSV() {
        List<ModeloBomba> bombas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linha;
            // Ignorar a primeira linha (cabeçalhos das colunas)
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                ModeloBomba bomba = new ModeloBomba();
                bomba.setId(Long.parseLong(dados[0]));
                bomba.setNomeCombustivel(dados[1]);
                bombas.add(bomba);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bombas;
    }

    // Implemente métodos para atualizar e excluir dados do arquivo CSV
    // Método para gerar um ID aleatório do tipo Long
    private long gerarIdAleatorio() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

}
