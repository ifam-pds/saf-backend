package br.edu.ifam.saf.api.data;

import br.edu.ifam.saf.api.dto.ItemDTO;

import java.util.Arrays;
import java.util.List;

public class ItemsResponse {
    private List<ItemDTO> items;

    public ItemsResponse(List<ItemDTO> items) {
        this.items = items;
    }

    public ItemsResponse(ItemDTO... itens) {
        this.items = Arrays.asList(itens);

    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
