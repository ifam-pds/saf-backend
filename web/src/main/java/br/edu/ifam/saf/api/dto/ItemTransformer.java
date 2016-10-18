package br.edu.ifam.saf.api.dto;

import br.edu.ifam.saf.modelo.Equipamento;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemTransformer implements DTOTransformer<Equipamento, ItemDTO> {

    @Override
    public Equipamento toEntity(ItemDTO dto) {
        final Equipamento item = new Equipamento();

        item.setNome(dto.getNome());
        item.setValor(dto.getValor());

        return item;
    }

    @Override
    public ItemDTO toDTO(Equipamento entity) {
        final ItemDTO itemDTO = new ItemDTO();

        itemDTO.setNome(entity.getNome());
        itemDTO.setValor(entity.getValor());

        return itemDTO;
    }

}
