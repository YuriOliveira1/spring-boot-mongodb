package com.lonfyuri.springbootmongodb.config;

import com.lonfyuri.springbootmongodb.domain.Post;
import com.lonfyuri.springbootmongodb.domain.User;
import com.lonfyuri.springbootmongodb.repository.PostRepository;
import com.lonfyuri.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("31/07/2024 19:32:42"), "Partiu Viagem", "To indo Familia", bob);
        Post post2 = new Post(null, sdf.parse("31/07/2024 19:34:42"), "Joguei RPG", "Foi Pessimo", alex);

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
