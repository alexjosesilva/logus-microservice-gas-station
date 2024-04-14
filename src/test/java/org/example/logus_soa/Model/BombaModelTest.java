package org.example.logus_soa.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombaModelTest {

    @Test
    public void testGetId() {
        BombaModel bomba = new BombaModel();
        bomba.setId(1);
        assertEquals(1, bomba.getId());
    }

    @Test
    public void testSetId() {
        BombaModel bomba = new BombaModel();
        bomba.setId(1);
        assertEquals(1, bomba.getId());
    }

    @Test
    public void testGetNomeCombustivel() {
        BombaModel bomba = new BombaModel();
        bomba.setNomeCombustivel("Gasolina");
        assertEquals("Gasolina", bomba.getNomeCombustivel());
    }

    @Test
    public void testSetNomeCombustivel() {
        BombaModel bomba = new BombaModel();
        bomba.setNomeCombustivel("Diesel");
        assertEquals("Diesel", bomba.getNomeCombustivel());
    }
}

