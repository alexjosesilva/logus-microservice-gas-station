package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.CombustivelModel;
import org.example.logus_soa.Services.CombustivelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CombustivelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CombustivelService combustivelService;

    @InjectMocks
    private CombustivelController combustivelController;

    @Test
    void testCriarVeiculo() throws Exception {
        CombustivelModel combustivel = new CombustivelModel(); // Você deve inicializar um objeto CombustivelModel válido aqui
        when(combustivelService.salvarCombustivelCSV(combustivel)).thenReturn(true); // Supondo que o método retorne um booleano indicando o sucesso
        mockMvc.perform(MockMvcRequestBuilders.post("/combustivel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // Aqui você deve passar o corpo do JSON com os dados do combustível
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Combustivel criado com sucesso!"));
    }

    @Test
    void testLerCombustivelCSV() throws Exception {
        CombustivelModel combustivel = new CombustivelModel(); // Você deve inicializar um objeto CombustivelModel válido aqui
        when(combustivelService.lerCombustivelCSV()).thenReturn(Collections.singletonList(combustivel)); // Supondo que o método retorne uma lista com um único combustível
        mockMvc.perform(MockMvcRequestBuilders.get("/combustivel")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].campo").value("valor")); // Aqui você deve validar os campos do JSON retornado
    }
}

