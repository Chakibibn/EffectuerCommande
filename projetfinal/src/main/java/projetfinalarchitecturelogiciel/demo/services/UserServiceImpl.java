package projetfinalarchitecturelogiciel.demo.services;


import projetfinalarchitecturelogiciel.demo.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projetfinalarchitecturelogiciel.demo.dao.RoleRepository;
import projetfinalarchitecturelogiciel.demo.dao.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public user findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}