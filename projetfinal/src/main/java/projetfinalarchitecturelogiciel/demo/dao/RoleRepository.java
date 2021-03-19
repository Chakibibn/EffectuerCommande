package projetfinalarchitecturelogiciel.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projetfinalarchitecturelogiciel.demo.entity.role;
public interface RoleRepository extends JpaRepository<role, Integer>{
}