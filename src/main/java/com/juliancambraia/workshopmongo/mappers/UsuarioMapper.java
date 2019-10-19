package com.juliancambraia.workshopmongo.mappers;

import com.juliancambraia.workshopmongo.domain.Usuario;
import com.juliancambraia.workshopmongo.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDto(Usuario entity);
    List<UsuarioDTO> toDtos(List<Usuario> usuarios);
}
