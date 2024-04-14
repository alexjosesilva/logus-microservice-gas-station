package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.BombaModel;
import org.example.logus_soa.Services.BombaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringBootTest
public class BombaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BombaService bombaService;

    @InjectMocks
    private BombaController bombaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bombaController).build();
    }

    @Test
    public void testCriarBomba() throws Exception {
        BombaModel bomba = new BombaModel(/* construa um objeto bomba válido aqui */);

        when(bombaService.salvarBombaCSV(any(BombaModel.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/bomba")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(/* serializar o objeto bomba para JSON aqui */))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Bomba criado com sucesso!"));

        verify(bombaService, times(1)).salvarBombaCSV(any(BombaModel.class));
    }

    @Test
    public void testListarBombas() throws Exception {
        when(bombaService.lerBombaCSV()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/bomba")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        verify(bombaService, times(1)).lerBombaCSV();
    }
}
