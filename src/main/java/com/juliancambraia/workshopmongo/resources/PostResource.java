package com.juliancambraia.workshopmongo.resources;

import com.juliancambraia.workshopmongo.domain.Post;
import com.juliancambraia.workshopmongo.dto.PostDTO;
import com.juliancambraia.workshopmongo.resources.util.URL;
import com.juliancambraia.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/pesquisaTitulo")
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
        texto = URL.decodeParam(texto);
        List<Post> list = postService.findByTitulo(texto);
        return ResponseEntity.ok().body(list);
    }

}
