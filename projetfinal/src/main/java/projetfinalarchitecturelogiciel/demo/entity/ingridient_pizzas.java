package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingridient_pizzas")
public class ingridient_pizzas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDPI;




    @ManyToOne
    @JoinColumn(name = "ingridients_idingridient")
    private ingridient ingridient;



    @ManyToOne
    @JoinColumn(name = "pizzas_idpizza")
    private pizza pizza;
    @Column(name = "isIngridient")
    Boolean Ingridientexist;

    public void setIngridient(projetfinalarchitecturelogiciel.demo.entity.ingridient ingridient) {
        this.ingridient = ingridient;
    }

    public Boolean getIngridientexist() {
        return Ingridientexist;
    }

    public void setIngridientexist(Boolean ingridientexist) {
        Ingridientexist = ingridientexist;
    }

    public Integer getIDPI() {
        return IDPI;
    }

    public void setIDPI(Integer IDPI) {
        this.IDPI = IDPI;
    }

    public projetfinalarchitecturelogiciel.demo.entity.ingridient getIngridient() {
        return ingridient;
    }



    public projetfinalarchitecturelogiciel.demo.entity.pizza getPizza() {
        return pizza;
    }

    public void setPizza(projetfinalarchitecturelogiciel.demo.entity.pizza pizza) {
        this.pizza = pizza;
    }


}
