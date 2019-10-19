package com.juliancambraia.workshopmongo.services;

import com.juliancambraia.workshopmongo.domain.Post;
import com.juliancambraia.workshopmongo.dto.PostDTO;
import com.juliancambraia.workshopmongo.mappers.PostMapper;
import com.juliancambraia.workshopmongo.repository.PostRepository;
import com.juliancambraia.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepositoryy;

    @Autowired
    private PostMapper postMapper;

    public PostDTO findById(String id) {
        Optional<Post> post = Optional.ofNullable(postRepositoryy.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!")));
        return postMapper.toDto(post.get());
    }

}
