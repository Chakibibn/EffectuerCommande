package projetfinalarchitecturelogiciel.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetfinalarchitecturelogiciel.demo.dao.OrderDAO;
import projetfinalarchitecturelogiciel.demo.entity.commande;
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public commande create(commande order) {
        return orderDAO.save(order);
    }
}
