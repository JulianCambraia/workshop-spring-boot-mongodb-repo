package com.juliancambraia.workshopmongo.config;

import com.juliancambraia.workshopmongo.domain.Post;
import com.juliancambraia.workshopmongo.domain.Usuario;
import com.juliancambraia.workshopmongo.dto.AutorDTO;
import com.juliancambraia.workshopmongo.dto.CommentDTO;
import com.juliancambraia.workshopmongo.repository.PostRepository;
import com.juliancambraia.workshopmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        usuarioRepository.deleteAll();
        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));

        postRepository.deleteAll();
        Post post1 = new Post(sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Brumadinho. Abraços!", new AutorDTO(maria));
        Post post2 = new Post(sdf.parse("23/03/2018"), "Good Morning Vietnã", "Acordei feliz hoje!", new AutorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        usuarioRepository.save(maria);


    }
}
