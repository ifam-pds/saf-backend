package br.edu.ifam.saf.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AluguelTest {

    Aluguel aluguel;

    @Before
    public void setUp() {
        aluguel = new Aluguel();
    }

    @Test
    public void adicionarItemConfiguraBidirecional() {


        ItemAluguel itemAluguel = new ItemAluguel();

        itemAluguel.setItem(new Item("item", 1.0));

        aluguel.adicionarItem(itemAluguel);


        assertEquals(1, aluguel.getItens().size());

        assertSame(itemAluguel.getAluguel(), aluguel);

    }

    @Test
    public void naoAdicionaMesmoItemDuasVezes() {


        ItemAluguel itemAluguel = new ItemAluguel();

        itemAluguel.setItem(new Item("item", 1.0));

        aluguel.adicionarItem(itemAluguel);
        aluguel.adicionarItem(itemAluguel);


        assertEquals(1, aluguel.getItens().size());

    }

    @Test(expected = NullPointerException.class)
    public void naoAceitaItemAluguelNulo() {
        aluguel.adicionarItem(null);
    }

    @Test(expected = NullPointerException.class)
    public void naoAceitaItensNulos() {
        ItemAluguel itemAluguel = new ItemAluguel();
        itemAluguel.setItem(null); //
        aluguel.adicionarItem(itemAluguel);
    }

    @Test(expected = NullPointerException.class)
    public void naoAceitaListaDeItensNulos() {
        aluguel.setItens(null);
    }

    @Test
    public void setItensConfiguraBidirecional() {

        Item item1 = new Item("item 1", 1.0);
        Item item2 = new Item("item 2", 1.0);
        Item item3 = new Item("item 3", 1.0);

        ItemAluguel itemAluguel1 = new ItemAluguel();
        itemAluguel1.setItem(item1);

        ItemAluguel itemAluguel2 = new ItemAluguel();
        itemAluguel1.setItem(item2);

        ItemAluguel itemAluguel3 = new ItemAluguel();
        itemAluguel1.setItem(item3);


        aluguel.setItens(Arrays.asList(itemAluguel1, itemAluguel2, itemAluguel3));

        assertSame(aluguel, itemAluguel1.getAluguel());
        assertSame(aluguel, itemAluguel2.getAluguel());
        assertSame(aluguel, itemAluguel3.getAluguel());

    }


}
