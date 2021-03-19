package projetfinalarchitecturelogiciel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projetfinalarchitecturelogiciel.demo.dao.IngridientDAO;
import projetfinalarchitecturelogiciel.demo.dao.PizzaDAO;
import projetfinalarchitecturelogiciel.demo.services.OrderDetailsService;
import projetfinalarchitecturelogiciel.demo.services.OrderService;
import projetfinalarchitecturelogiciel.demo.services.ProductService;
import projetfinalarchitecturelogiciel.demo.entity.*;
import projetfinalarchitecturelogiciel.demo.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private IngridientDAO ingridientDAO;
    @Autowired
    private PizzaDAO pizzaDAO;
    @Autowired
    private EntityManager em;
    private double prixsupliment = 0;
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session){

        modelMap.put("total",total(session));

        return "cart/index";
    }
    @RequestMapping(value = "buy/{id}",method = RequestMethod.GET)
    public String buy(@PathVariable("id") int id, Model modelMap, HttpSession session){
        if(session.getAttribute("cart") == null){
            List<item> cart = new ArrayList<item>();
            cart.add(new item(productService.find(id),1));
            session.setAttribute("cart",cart);

             }else {
            List<item> cart = (List<item>) session.getAttribute("cart");
             int index = isExists(id,cart);
             if(index == -1){
                 cart.add(new item(productService.find(id),1));

             }else {
                 int quantity = cart.get(index).getQuantity()+1;
                 cart.get(index).setQuantity(quantity);

             }
        }
        return "redirect:../../cart";
    }
    @RequestMapping(value = "remove/{id}",method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model modelMap, HttpSession session){
        List<item> cart = (List<item>) session.getAttribute("cart");
        int index = isExists(id,cart);
        cart.remove(index);
        session.setAttribute("cart",cart);
        return "redirect:../../cart";
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(HttpSession session, HttpServletRequest request) {
        String [] quantities = request.getParameterValues("quantity");
        List<item> cart =(List<item>) session.getAttribute("cart");

        for(int i =0; i<cart.size();i++){
            cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("cart",cart);
        return "redirect:../cart";
    }

    @RequestMapping(value = "pizzzaa",method = RequestMethod.POST)
    public String pizzzaa(@RequestParam List<Integer> idingridient,Model model,final HttpServletRequest req,HttpSession session) {
        final  Integer pizzaid = Integer.valueOf(req.getParameter("caculer"));
        double ttp = 0;

        Query query;
        query = em.createQuery("select a  from ingridient_pizzas  a inner join a.pizza p  where p.idpizza LIKE :idp and a.Ingridientexist=true ").setParameter("idp",pizzaid);
        List<ingridient_pizzas> inp = query.getResultList();
        for (int i = 0;i<inp.size();i++){
            System.out.println("je suis l'ingridient "+inp.get(i).getIngridient().getNomingridient()+"******* le prix est "+inp.get(i).getIngridient().getPrixingridient());
             ttp = ttp + inp.get(i).getIngridient().getPrixingridient();

        }
         for(ingridient li : ingridientDAO.findAllById(idingridient)){
            System.out.println("je suis l'ingridient "+li.getNomingridient()+"******* le prix est "+li.getPrixingridient());
            prixsupliment = prixsupliment + li.getPrixingridient();
        }
         System.out.println("le prix total du supliment est egal a "+ttp);
        System.out.println("le prix total du supliment est egal a "+prixsupliment);
        prixsupliment = prixsupliment-ttp;
        System.out.println("le vrai prix est de "+prixsupliment);


        List<item> cart = (List<item>) session.getAttribute("cart");
        int index = isExists(pizzaid,cart);
        if(index != -1) {


            cart.remove(index);
            item ii = new item(productService.find(pizzaid),1);
            double prixpizza = ii.getProduct().getPrixproduct();
            ii.getProduct().setPrixproduct(prixpizza+prixsupliment);
            cart.add(ii);
            prixsupliment = 0;
            ttp = 0;
            
        }
        return "redirect:../../cart";
    }
    @RequestMapping(value="checkout",method = RequestMethod.GET)
    public String checkout(Model modelMap, HttpSession session, Principal principal){
        user  user = userService.findByUsername(principal.getName());
        System.out.println(""+principal.getName().toString());
        if(principal.getName().toString()== null){

            return "redirect:../cart";
        }else {

            commande cmd= new commande();

            cmd.setUser(user);
            cmd.setDatecommande(new Date());

            cmd.setPrixtotal(total(session));


            modelMap.addAttribute("price", cmd);
            modelMap.addAttribute("user",user);
            orderService.create(cmd);

            List<item> cart = (List<item>) session.getAttribute("cart");
            for(item item: cart){
                lignecommande lc = new lignecommande();
                lc.setCommande(cmd);
                lc.setProduct(item.getProduct());
                lc.setQuantity(item.getQuantity());
                lc.setPrix(item.getProduct().getPrixproduct()*item.getQuantity());
                orderDetailsService.create(lc);
            }
            modelMap.addAttribute("price", cmd);
            modelMap.addAttribute("user",user);
            //pour supprimer la cart
            session.removeAttribute("cart");


            return "orders/thanks";
        }
    }


    private int isExists(int id,List<item> cart){
        for(int i = 0; i<cart.size(); i++){
            if(cart.get(i).getProduct().getIdproduct() == id){
                return i;
                }
        }
        return -1;
    }
    private double total(HttpSession session){
        List<item> cart =(List<item>) session.getAttribute("cart");

        double s=0;
        if(cart != null){
        for(item item : cart) {

        s+= item.getQuantity()*item.getProduct().getPrixproduct();

        }}
        return s;
    }
}
