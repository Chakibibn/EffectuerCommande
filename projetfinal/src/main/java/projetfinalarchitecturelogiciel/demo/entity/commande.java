package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="commande")
public class commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcommande;
    private double prixtotal;
    private Date datecommande;
    @OneToMany(mappedBy = "commande")
    private Collection<lignecommande> lignecommandes;
    @ManyToOne
    @JoinColumn(name = "user")
    private user user;
    //List<product> products;
    //madertch le magasin Collection<magasin>

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Collection<lignecommande> getLignecommandes() {
        return lignecommandes;
    }

    public void setLignecommandes(Collection<lignecommande> lignecommandes) {
        this.lignecommandes = lignecommandes;
    }

    public projetfinalarchitecturelogiciel.demo.entity.user getUser() {
        return user;
    }

    public void setUser(projetfinalarchitecturelogiciel.demo.entity.user user) {
        this.user = user;
    }
}
