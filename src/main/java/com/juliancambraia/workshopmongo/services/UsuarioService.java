package com.juliancambraia.workshopmongo.services;

import com.juliancambraia.workshopmongo.domain.Usuario;
import com.juliancambraia.workshopmongo.dto.UsuarioDTO;
import com.juliancambraia.workshopmongo.mappers.UsuarioMapper;
import com.juliancambraia.workshopmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
