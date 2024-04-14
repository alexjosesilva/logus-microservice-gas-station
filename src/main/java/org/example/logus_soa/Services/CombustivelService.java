package org.example.logus_soa.Services;

import org.example.logus_soa.Model.CombustivelModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CombustivelService {

    private static final String CSV_FILE_PATH = "src/main/resources/csv/combustiveis.csv";
    private static boolean flag = false;
    public void salvarCombustivelCSV(CombustivelModel combustivel) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            flag = verificaFlag();
            if (flag) {
                writer.println("ID,NomeCombustivel");
            }

            // Gerar um ID aleatório
            long id = gerarIdAleatorio();
            writer.println(id + "," + combustivel.getNome());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CombustivelModel> lerCombustivelCSV() {
        List<CombustivelModel> combustivels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linha;
            // Ignorar a primeira linha (cabeçalhos das colunas)
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                CombustivelModel combustivel = new CombustivelModel();
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
    private boolean verificaFlag() {
        File file = new File(CSV_FILE_PATH);
        return file.exists() && file.length() == 0; // Retorna true se o arquivo existir, false caso contrário
    }
}
