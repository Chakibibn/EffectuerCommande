package projetfinalarchitecturelogiciel.demo.services;

import java.util.List;
import projetfinalarchitecturelogiciel.demo.entity.product;

public interface ProductService {
    public Iterable<product> findAll();
    public product find(int id);

}
