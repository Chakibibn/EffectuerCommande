package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproduct;
    private String nomproduct;
    private double prixproduct;
    private String imageurl;

    //private List<commande> commandes;

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getNomproduct() {
        return nomproduct;
    }

    public void setNomproduct(String nomproduct) {
        this.nomproduct = nomproduct;
    }

    public double getPrixproduct() {
        return prixproduct;
    }

    public void setPrixproduct(double prixproduct) {
        this.prixproduct = prixproduct;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
