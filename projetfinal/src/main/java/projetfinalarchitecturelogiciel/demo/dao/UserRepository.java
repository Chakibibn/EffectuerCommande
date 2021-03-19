package projetfinalarchitecturelogiciel.demo.dao;

import projetfinalarchitecturelogiciel.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Integer> {
    user findByUsername(String username);
}