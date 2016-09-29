package br.edu.ifam.saf.api.data;

import br.edu.ifam.saf.data.Item;

import java.util.Arrays;
import java.util.List;

public class ItemsData {
    private List<Item> items;

    public ItemsData(List<Item> items) {
        this.items = items;
    }

    public ItemsData(Item... itens) {
        this.items = Arrays.asList(itens);

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
