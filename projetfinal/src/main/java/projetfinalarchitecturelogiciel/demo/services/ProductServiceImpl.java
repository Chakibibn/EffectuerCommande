package projetfinalarchitecturelogiciel.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetfinalarchitecturelogiciel.demo.dao.ProductDAO;
import projetfinalarchitecturelogiciel.demo.entity.product;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    public Iterable<product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public product find(int id) {
        return productDAO.findById(id).get();
    }
}
