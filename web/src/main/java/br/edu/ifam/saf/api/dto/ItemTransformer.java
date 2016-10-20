package br.edu.ifam.saf.api.dto;

import br.edu.ifam.saf.modelo.Item;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ItemTransformer implements DTOTransformer<Item, ItemDTO> {

    @Inject
    CategoriaTransformer categoriaTransformer;
    
    @Override
    public Item toEntity(ItemDTO dto) {
        final Item item = new Item();

        item.setNome(dto.getNome());
        item.setPrecoPorHora(dto.getPrecoPorHora());
        item.setDescricao(dto.getDescricao());
        item.setMarca(dto.getMarca());
        item.setModelo(dto.getModelo());
        item.setCategoria(categoriaTransformer.toEntity(dto.getCategoria()));

        return item;
    }

    @Override
    public ItemDTO toDTO(Item entity) {
        final ItemDTO itemDTO = new ItemDTO();

        itemDTO.setNome(entity.getNome());
        itemDTO.setDescricao(entity.getDescricao());
        itemDTO.setPrecoPorHora(entity.getPrecoPorHora());
        itemDTO.setMarca(entity.getMarca());
        itemDTO.setModelo(entity.getModelo());
        itemDTO.setCategoria(categoriaTransformer.toDTO(entity.getCategoria()));

        return itemDTO;
    }

    public List<Item> toEntityList(List<ItemDTO> dtos) {
        List<Item> itens = new ArrayList<>();
        for (ItemDTO dto : dtos) {
            itens.add(toEntity(dto));
        }
        return itens;
    }

    public List<ItemDTO> toDTOList(List<Item> itens) {
        List<ItemDTO> dtos = new ArrayList<>();

        for (Item bairro : itens) {
            dtos.add(toDTO(bairro));
        }

        return dtos;
    }
}
