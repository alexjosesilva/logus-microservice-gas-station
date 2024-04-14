package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.BombaModel;
import org.example.logus_soa.Services.BombaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bomba")
public class BombaController {

    @Autowired
    private BombaService bombaService;

    @PostMapping
    public String criarVeiculo(@RequestBody BombaModel bomba) {
        bombaService.salvarBombaCSV(bomba);
        return "Bomba criado com sucesso!";
    }

    @GetMapping
    public List<BombaModel> listarBombas() {
        return bombaService.lerBombaCSV();
    }

    // Implemente outros métodos CRUD aqui

}
