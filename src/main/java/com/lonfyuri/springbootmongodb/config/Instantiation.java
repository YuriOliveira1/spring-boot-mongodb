package com.lonfyuri.springbootmongodb.config;

import com.lonfyuri.springbootmongodb.domain.Post;
import com.lonfyuri.springbootmongodb.domain.User;
import com.lonfyuri.springbootmongodb.dto.AuthorDTO;
import com.lonfyuri.springbootmongodb.dto.CommentDTO;
import com.lonfyuri.springbootmongodb.repository.PostRepository;
import com.lonfyuri.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("31/07/2024"), "Odeio andar de Busão", "É horrivel ficar 1H 30 em um onibus, lembrando ida e volta então são 3H", new AuthorDTO(alex));
        Post post2 = new Post(null, sdf.parse("31/07/2024"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));

        CommentDTO c1 = new CommentDTO("Para de ser Fresco vá", sdf.parse("01/08/2024"), new AuthorDTO(maria));
        CommentDTO c2 = new CommentDTO("É horrivel mesmo, por isso vou de Helicoptero", sdf.parse("01/08/2024"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Fodase?", sdf.parse("01/08/2024"), new AuthorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        alex.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(alex);

    }
}
