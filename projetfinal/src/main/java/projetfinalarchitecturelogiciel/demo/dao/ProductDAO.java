package projetfinalarchitecturelogiciel.demo.dao;
import projetfinalarchitecturelogiciel.demo.entity.product;

import org.springframework.data.repository.CrudRepository;


public interface ProductDAO extends CrudRepository<product,Integer> {
}
