package br.edu.ifam.saf.api.dto;

import br.edu.ifam.saf.modelo.Item;

import javax.inject.Singleton;

@Singleton
public class ItemTransformer implements DTOTransformer<Item, ItemDTO> {

    @Override
    public Item toEntity(ItemDTO dto) {
        final Item item = new Item();

        item.setNome(dto.getNome());
        item.setPrecoPorHora(dto.getPrecoPorHora());

        return item;
    }

    @Override
    public ItemDTO toDTO(Item entity) {
        final ItemDTO itemDTO = new ItemDTO();

        itemDTO.setNome(entity.getNome());
        itemDTO.setPrecoPorHora(entity.getPrecoPorHora());

        return itemDTO;
    }

}
