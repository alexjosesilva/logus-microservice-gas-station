package org.example.logus_soa.Services;

import org.example.logus_soa.Model.ModeloVeiculo;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VeiculoService {

    private static final String CSV_FILE_PATH = "src/main/resources/csv/veiculos.csv";

    public void salvarVeiculoCSV(ModeloVeiculo veiculo) {

        // Gerar um ID aleatório
        long id = gerarIdAleatorio();

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.println(
                    id + "," +
                    veiculo.getNomeModelo() + "," +
                    veiculo.getConsumoEtanol() + "," +
                    veiculo.getConsumoGasolina() + "," +
                    veiculo.getConsumoDiesel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ModeloVeiculo> lerVeiculosCSV() {
        List<ModeloVeiculo> veiculos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linha;
            // Ignorar a primeira linha (cabeçalhos das colunas)
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                ModeloVeiculo veiculo = new ModeloVeiculo();
                veiculo.setId(Long.parseLong(dados[0]));
                veiculo.setNomeModelo(dados[1]);
                veiculo.setConsumoEtanol(Double.parseDouble(dados[2]));
                veiculo.setConsumoGasolina(Double.parseDouble(dados[3]));
                veiculo.setConsumoDiesel(Double.parseDouble(dados[4]));
                veiculos.add(veiculo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    // Implemente métodos para atualizar e excluir dados do arquivo CSV
    // Método para gerar um ID aleatório do tipo Long
    private long gerarIdAleatorio() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
