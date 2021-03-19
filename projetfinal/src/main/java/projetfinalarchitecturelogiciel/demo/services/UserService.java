package projetfinalarchitecturelogiciel.demo.services;
import projetfinalarchitecturelogiciel.demo.entity.user;
public interface UserService {
    void save(user user);

    user findByUsername(String username);
}