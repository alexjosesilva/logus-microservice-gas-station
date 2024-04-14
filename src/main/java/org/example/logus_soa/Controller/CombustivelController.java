package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.CombustivelModel;
import org.example.logus_soa.Services.CombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {

    @Autowired
    private CombustivelService combustivelService;

    @PostMapping
    public String criarVeiculo(@RequestBody CombustivelModel combustivel) {
        combustivelService.salvarCombustivelCSV(combustivel);
        return "Combustivel criado com sucesso!";
    }

    @GetMapping
    public List<CombustivelModel> lerCombustivelCSV() {
        return combustivelService.lerCombustivelCSV();
    }
}
