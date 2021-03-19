package projetfinalarchitecturelogiciel.demo.dao;
import projetfinalarchitecturelogiciel.demo.entity.pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaDAO extends JpaRepository<pizza,Integer> {
}
