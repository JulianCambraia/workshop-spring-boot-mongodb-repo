package com.juliancambraia.workshopmongo.services;

import com.juliancambraia.workshopmongo.domain.Usuario;
import com.juliancambraia.workshopmongo.dto.UsuarioDTO;
import com.juliancambraia.workshopmongo.mappers.UsuarioMapper;
import com.juliancambraia.workshopmongo.repository.UsuarioRepository;
import com.juliancambraia.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toDtos(usuarios);
    }

    public UsuarioDTO findById(String id) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!")));
        return usuarioMapper.toDto(usuario.get());
    }

    public Usuario save(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        return usuarioRepository.save(usuario);
    }
}
