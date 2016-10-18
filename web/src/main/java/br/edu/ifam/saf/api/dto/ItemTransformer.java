package br.edu.ifam.saf.api.dto;

import br.edu.ifam.saf.modelo.Item;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemTransformer implements DTOTransformer<Item, ItemDTO> {

    @Override
    public Item toEntity(ItemDTO dto) {
        final Item item = new Item();

        item.setNome(dto.getNome());
        item.setValor(dto.getValor());

        return item;
    }

    @Override
    public ItemDTO toDTO(Item entity) {
        final ItemDTO itemDTO = new ItemDTO();

        itemDTO.setNome(entity.getNome());
        itemDTO.setValor(entity.getValor());

        return itemDTO;
    }

}
