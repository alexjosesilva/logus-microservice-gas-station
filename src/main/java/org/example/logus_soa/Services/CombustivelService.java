package org.example.logus_soa.Services;

import org.example.logus_soa.Model.ModeloCombustivel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CombustivelService {

    private static final String CSV_FILE_PATH = "src/main/resources/csv/combustivel.csv";

    public void salvarCombustivelCSV(ModeloCombustivel combustivel) {

        // Gerar um ID aleatório
        long id = gerarIdAleatorio();

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.println(id + "," + combustivel.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ModeloCombustivel> lerCombustivelCSV() {
        List<ModeloCombustivel> combustivels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linha;
            // Ignorar a primeira linha (cabeçalhos das colunas)
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                ModeloCombustivel combustivel = new ModeloCombustivel();
                combustivel.setId(Long.parseLong(dados[0]));
                combustivel.setNome(dados[1]);
                combustivels.add(combustivel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return combustivels;
    }

    // Implemente métodos para atualizar e excluir dados do arquivo CSV
    // Método para gerar um ID aleatório do tipo Long
    private long gerarIdAleatorio() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
