package com.juliancambraia.workshopmongo.resources;

import com.juliancambraia.workshopmongo.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        Usuario usuario1 = new Usuario("1", "Maria Silva", "maria@gmail.com");
        Usuario usuario2 = new Usuario("2", "Alex Green", "maria@gmail.com");
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(usuario1, usuario2));

        return ResponseEntity.ok().body(list);
    }
}
