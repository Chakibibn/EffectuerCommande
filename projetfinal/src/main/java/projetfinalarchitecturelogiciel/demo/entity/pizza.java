package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="pizza")
public class pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpizza;
    private String nompizza;
    private double prixpizza;
    private String imageurl;
    @ManyToMany(mappedBy = "pizzas")
    private Collection<ingridient> ingridients;
    @OneToMany(mappedBy = "pizza")
    List<ingridient_pizzas> ingridient_pizzas;

    public List<projetfinalarchitecturelogiciel.demo.entity.ingridient_pizzas> getIngridient_pizzas() {
        return ingridient_pizzas;
    }

    public void setIngridient_pizzas(List<projetfinalarchitecturelogiciel.demo.entity.ingridient_pizzas> ingridient_pizzas) {
        this.ingridient_pizzas = ingridient_pizzas;
    }

    public Integer getIdpizza() {
        return idpizza;
    }

    public void setIdpizza(Integer idpizza) {
        this.idpizza = idpizza;
    }

    public String getNompizza() {
        return nompizza;
    }

    public void setNompizza(String nompizza) {
        this.nompizza = nompizza;
    }

    public double getPrixpizza() {
        return prixpizza;
    }

    public void setPrixpizza(double prixpizza) {
        this.prixpizza = prixpizza;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Collection<ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(Collection<ingridient> ingridients) {
        this.ingridients = ingridients;
    }
}
