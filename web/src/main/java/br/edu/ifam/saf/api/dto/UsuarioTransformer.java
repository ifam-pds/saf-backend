package br.edu.ifam.saf.api.dto;

import br.edu.ifam.saf.modelo.Usuario;

import javax.inject.Singleton;


@Singleton
public class UsuarioTransformer implements DTOTransformer<Usuario, UsuarioDTO> {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        final Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        final UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setEmail(entity.getEmail());
        usuarioDTO.setToken(entity.getToken());

        return usuarioDTO;
    }
}
