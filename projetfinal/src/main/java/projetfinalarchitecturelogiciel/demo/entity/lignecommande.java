package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "lignecommande")
public class lignecommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlignecomma;
    @ManyToOne
    @JoinColumn(name = "product")
    private product product;
    private int quantity;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "commande")
    private commande commande;

    public Integer getIdlignecomma() {
        return idlignecomma;
    }


    public void setIdlignecomma(Integer idlignecomma) {
        this.idlignecomma = idlignecomma;
    }

    public projetfinalarchitecturelogiciel.demo.entity.product getProduct() {
        return product;
    }

    public void setProduct(projetfinalarchitecturelogiciel.demo.entity.product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public projetfinalarchitecturelogiciel.demo.entity.commande getCommande() {
        return commande;
    }

    public void setCommande(projetfinalarchitecturelogiciel.demo.entity.commande commande) {
        this.commande = commande;
    }
}
