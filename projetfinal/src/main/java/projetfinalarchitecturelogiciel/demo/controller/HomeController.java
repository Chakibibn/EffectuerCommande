package projetfinalarchitecturelogiciel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import projetfinalarchitecturelogiciel.demo.dao.BoissonDAO;
import projetfinalarchitecturelogiciel.demo.dao.MagasinDAO;
import projetfinalarchitecturelogiciel.demo.dao.PizzaDAO;
import projetfinalarchitecturelogiciel.demo.dao.VilleDAO;
import projetfinalarchitecturelogiciel.demo.entity.ingridient_pizzas;
import projetfinalarchitecturelogiciel.demo.entity.pizza;
import projetfinalarchitecturelogiciel.demo.entity.ingridient;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(name = "welcome")
public class HomeController {



    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private BoissonDAO boissonDAO;

    @Autowired
    private VilleDAO villeDAO;

    @Autowired
    private MagasinDAO magasinDAO;
    @Autowired
    private EntityManager em;

    public String index(Model model){
        model.addAttribute("pizzas",pizzaDAO.findAll());
        model.addAttribute("boissons",boissonDAO.findAll());
        model.addAttribute("villes",villeDAO.findAll());
        model.addAttribute("magasins",magasinDAO.findAll());

        return "welcome";

    }
    @RequestMapping(value = "welcome/ingridients/{id}",method = RequestMethod.GET)
    public String ingridients(@PathVariable("id") int id, Model model){

        Query query;
        query = em.createQuery("select a.ingridient  from ingridient_pizzas  a inner join a.pizza p  where p.idpizza LIKE :idp and a.Ingridientexist=true ").setParameter("idp",id);
        List<ingridient> inp = query.getResultList();

        System.out.println("************************"+inp.size()+"******************");
        pizza pi = pizzaDAO.getOne(id);
        model.addAttribute("pi",pi);
        model.addAttribute("inp",inp);
        return "welcome/showmeurcomp";
    }
}
