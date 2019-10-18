package com.juliancambraia.workshopmongo.repository;

import com.juliancambraia.workshopmongo.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
