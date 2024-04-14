package org.example.logus_soa.Controller;

import org.example.logus_soa.Model.VeiculoModel;
import org.example.logus_soa.Services.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VeiculoControllerTest {

    @Mock
    private VeiculoService veiculoService;

    @InjectMocks
    private VeiculoController veiculoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarVeiculo() {
        VeiculoModel veiculo = new VeiculoModel();
        doNothing().when(veiculoService).salvarVeiculoCSV(veiculo);

        ResponseEntity<String> responseEntity = veiculoController.criarVeiculo(veiculo);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Veículo criado com sucesso!", responseEntity.getBody());
        verify(veiculoService, times(1)).salvarVeiculoCSV(veiculo);
    }

    @Test
    void testListarVeiculos() {
        List<VeiculoModel> veiculos = Collections.singletonList(new VeiculoModel());
        when(veiculoService.lerVeiculosCSV()).thenReturn(veiculos);

        List<VeiculoModel> veiculosListados = veiculoController.listarVeiculos();

        assertEquals(veiculos, veiculosListados);
        verify(veiculoService, times(1)).lerVeiculosCSV();
    }
}

