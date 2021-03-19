package projetfinalarchitecturelogiciel.demo.dao;
import projetfinalarchitecturelogiciel.demo.entity.magasin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MagasinDAO extends JpaRepository<magasin,Integer> {
}
