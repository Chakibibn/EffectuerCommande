package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ingridient")
public class ingridient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idingridient;
    private String nomingridient;
    private double prixingridient;
    @ManyToMany
    private Collection<pizza> pizzas;
    @OneToMany(mappedBy = "ingridient")
    List<ingridient_pizzas> ingridient_pizzas;

    public List<projetfinalarchitecturelogiciel.demo.entity.ingridient_pizzas> getIngridient_pizzas() {
        return ingridient_pizzas;
    }

    public void setIngridient_pizzas(List<projetfinalarchitecturelogiciel.demo.entity.ingridient_pizzas> ingridient_pizzas) {
        this.ingridient_pizzas = ingridient_pizzas;
    }

    public Integer getIdingridient() {
        return idingridient;
    }

    public void setIdingridient(Integer idingridient) {
        this.idingridient = idingridient;
    }

    public String getNomingridient() {
        return nomingridient;
    }

    public void setNomingridient(String nomingridient) {
        this.nomingridient = nomingridient;
    }

    public double getPrixingridient() {
        return prixingridient;
    }

    public void setPrixingridient(double prixingridient) {
        this.prixingridient = prixingridient;
    }

    public Collection<pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Collection<pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
