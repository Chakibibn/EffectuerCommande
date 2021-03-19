package projetfinalarchitecturelogiciel.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projetfinalarchitecturelogiciel.demo.entity.ingridient;

public interface IngridientDAO extends JpaRepository<ingridient,Integer> {
}
