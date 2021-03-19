package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "ville")
public class ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idville;
    private String nomville;


    @OneToMany(mappedBy = "ville")
    private Collection<magasin> magasinCollection;

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public String getNomville() {
        return nomville;
    }

    public void setNomville(String nomville) {
        this.nomville = nomville;
    }

    public Collection<magasin> getMagasinCollection() {
        return magasinCollection;
    }

    public void setMagasinCollection(Collection<magasin> magasinCollection) {
        this.magasinCollection = magasinCollection;
    }
}
