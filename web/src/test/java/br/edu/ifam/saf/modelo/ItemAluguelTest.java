package br.edu.ifam.saf.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ItemAluguelTest {

    ItemAluguel itemAluguel;

    @Before
    public void setUp() {
        itemAluguel = new ItemAluguel();
        itemAluguel.setItem(new Item("item", 1.0));
    }

    @Test
    public void configuraOBidirecionamento() {

        Aluguel aluguel = new Aluguel();

        itemAluguel.setAluguel(aluguel);

        assertSame(aluguel, itemAluguel.getAluguel());

        assertTrue(aluguel.getItens().contains(itemAluguel));

    }

}