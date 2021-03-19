package projetfinalarchitecturelogiciel.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetfinalarchitecturelogiciel.demo.dao.OrderDetailsDAO;
import projetfinalarchitecturelogiciel.demo.entity.lignecommande;
@Service("orderDetailsService")
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{
    @Autowired
    private OrderDetailsDAO orderDetailsDAO;
    @Override
    public lignecommande create(lignecommande orderdetail) {
        return orderDetailsDAO.save(orderdetail);
    }
}
