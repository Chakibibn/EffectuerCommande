package projetfinalarchitecturelogiciel.demo.controller;

import projetfinalarchitecturelogiciel.demo.dao.BoissonDAO;
import projetfinalarchitecturelogiciel.demo.dao.MagasinDAO;
import projetfinalarchitecturelogiciel.demo.dao.PizzaDAO;
import projetfinalarchitecturelogiciel.demo.dao.VilleDAO;
import projetfinalarchitecturelogiciel.demo.entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import projetfinalarchitecturelogiciel.demo.services.SecurityService;
import projetfinalarchitecturelogiciel.demo.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private BoissonDAO boissonDAO;

    @Autowired
    private VilleDAO villeDAO;

    @Autowired
    private MagasinDAO magasinDAO;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new user());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") user userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/product";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {

        model.addAttribute("pizzas",pizzaDAO.findAll());
        model.addAttribute("boissons",boissonDAO.findAll());
        model.addAttribute("villes",villeDAO.findAll());
        model.addAttribute("magasins",magasinDAO.findAll());

        return "welcome";
    }
}