package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "boisson")
public class boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idboisson;
    private String nomboisson;
    private double prixboisson;
    private String imageurl;

    public Integer getIdboisson() {
        return idboisson;
    }

    public void setIdboisson(Integer idboisson) {
        this.idboisson = idboisson;
    }

    public String getNomboisson() {
        return nomboisson;
    }

    public void setNomboisson(String nomboisson) {
        this.nomboisson = nomboisson;
    }

    public double getPrixboisson() {
        return prixboisson;
    }

    public void setPrixboisson(double prixboisson) {
        this.prixboisson = prixboisson;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
