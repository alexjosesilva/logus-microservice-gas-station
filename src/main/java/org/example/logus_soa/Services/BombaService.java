package org.example.logus_soa.Services;

import org.example.logus_soa.Model.BombaModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BombaService {

    private static final String CSV_FILE_PATH = "src/main/resources/csv/bombagasolina.csv";
    private static boolean flag;
    public void salvarBombaCSV(BombaModel bomba) {

        // Gerar um ID aleatório
        long id = gerarIdAleatorio();
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            // Adicionar cabeçalho se o arquivo estiver vazio
            flag = verificaFlag();
            if (flag) {
                writer.println("ID,NomeCombustivel");
            }
            writer.println(id + "," + bomba.getNomeCombustivel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<BombaModel> lerBombaCSV() {
        List<BombaModel> bombas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linha;
            // Ignorar a primeira linha (cabeçalhos das colunas)
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                BombaModel bomba = new BombaModel();
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

    private boolean verificaFlag() {
        File file = new File(CSV_FILE_PATH);
        return file.exists() && file.length() == 0; // Retorna true se o arquivo existir, false caso contrário
    }
}
