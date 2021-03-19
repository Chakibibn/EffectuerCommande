package projetfinalarchitecturelogiciel.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import projetfinalarchitecturelogiciel.demo.dao.IngridientDAO;
import projetfinalarchitecturelogiciel.demo.dao.PizzaDAO;
import projetfinalarchitecturelogiciel.demo.services.ProductService;
import projetfinalarchitecturelogiciel.demo.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IngridientDAO ingridientDAO;
    @Autowired
    private EntityManager em;
    @Autowired
    private PizzaDAO pizzaDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model modelMap){
        modelMap.addAttribute("products",productService.findAll());
        return "product/index";
    }
    @RequestMapping(value = "PizzaPer/{id}",method = RequestMethod.GET)
    public String PizzaPer(@PathVariable("id") int id, Model model, final HttpServletRequest req){
        System.out.println(id);

        Query query,tt,mm;

        query = em.createQuery("select a  from ingridient_pizzas  a inner join a.pizza p  where p.idpizza LIKE :idp ").setParameter("idp",id);
        List<ingridient_pizzas> inp = query.getResultList();
        tt = em.createQuery("select a from ingridient_pizzas a   where a.pizza.idpizza like :idp ").setParameter("idp",id);
        List<ingridient> oo = tt.getResultList();
        mm = em.createQuery("select a from ingridient_pizzas  a where a.pizza.idpizza like :idp ").setParameter("idp",id);
        List<ingridient_pizzas> kk= mm.getResultList();
        System.out.println("//////////////////////////////////////////////***************"+kk.size());
        for(int i=0; i<kk.size();i++){
            if(kk.get(i).getIngridientexist() == true){
            System.out.println(" je suis l'ingridient"+kk.get(i).getIngridient().getNomingridient()+" et j'existe");}
            else   {
                System.out.println(" je suis l'ingridient"+kk.get(i).getIngridient().getNomingridient()+" et j'existe pas");
            }
        }


        pizza p = pizzaDAO.findById(id).get();
        List<ingridient> ii =(List<ingridient>) p.getIngridients();
         model.addAttribute("oo",oo);
        model.addAttribute("kk",kk);
        model.addAttribute("ingridiant",ingridientDAO.findAll());
        model.addAttribute("inp",inp);
        model.addAttribute("pizza",ii);
        model.addAttribute("id",id);
        model.addAttribute("p",p);


        return "product/pizzaP";
    }
}
