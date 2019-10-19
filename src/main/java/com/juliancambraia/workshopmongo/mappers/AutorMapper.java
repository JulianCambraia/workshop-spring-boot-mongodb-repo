package com.juliancambraia.workshopmongo.mappers;

import com.juliancambraia.workshopmongo.domain.Usuario;
import com.juliancambraia.workshopmongo.dto.AutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    Usuario toEntity(AutorDTO dto);

    AutorDTO toDto(Usuario entity);

    List<AutorDTO> toDtos(List<Usuario> autores);
}
