package projetfinalarchitecturelogiciel.demo.dao;
import projetfinalarchitecturelogiciel.demo.entity.lignecommande;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsDAO extends CrudRepository<lignecommande,Integer> {
}
