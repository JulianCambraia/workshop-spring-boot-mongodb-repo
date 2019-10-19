package com.juliancambraia.workshopmongo.repository;

import com.juliancambraia.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String text);

    // Consulta alternativa com MongoDB
    @Query("'titulo': { $regex ?0. $options : 'i'}")
    List<Post> pesquisaTitulo(String texto);
}
