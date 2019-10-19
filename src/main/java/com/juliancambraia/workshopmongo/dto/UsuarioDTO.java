package com.juliancambraia.workshopmongo.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private String id;
    private String nome;
    private String email;
    private List<PostDTO>  posts = new ArrayList<>();

    public UsuarioDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }
}
