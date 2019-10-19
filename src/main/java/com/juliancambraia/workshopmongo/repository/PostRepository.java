package com.juliancambraia.workshopmongo.repository;

import com.juliancambraia.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String text);

    // Consulta alternativa com MongoDB
    @Query("{ 'titulo': { $regex ?0, $options : 'i'} }")
    List<Post> pesquisaTitulo(String texto);

    @Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> pesquisaCompleta(String texto, Date dataMinima, Date dataMaxima);
}
