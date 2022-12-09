package com.example.odontologos.service.security;

import com.example.odontologos.model.security.Rol;
import com.example.odontologos.model.security.Usuario;
import com.example.odontologos.repository.security.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoadUsers implements ApplicationRunner {


    private IUserRepository userRepository;

    @Autowired
    public LoadUsers(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass1 = passwordEncoder.encode("password1");
        userRepository.save(new Usuario("Agus", "123", "agus,casarone@gmail.com", pass1, Rol.ROL_ADMIN));


    }
}
