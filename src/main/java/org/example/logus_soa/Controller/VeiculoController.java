package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.VeiculoModel;
import org.example.logus_soa.Services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public String criarVeiculo(@RequestBody VeiculoModel veiculo) {
        veiculoService.salvarVeiculoCSV(veiculo);
        return "Veículo criado com sucesso!";
    }

    @GetMapping
    public List<VeiculoModel> listarVeiculos() {
        return veiculoService.lerVeiculosCSV();
    }

    // Implemente outros métodos CRUD aqui
}
