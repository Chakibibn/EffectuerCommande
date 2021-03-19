package projetfinalarchitecturelogiciel.demo.dao;
import projetfinalarchitecturelogiciel.demo.entity.commande;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<commande,Integer> {
}
