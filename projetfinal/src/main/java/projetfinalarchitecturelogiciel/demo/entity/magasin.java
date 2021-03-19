package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "magasin")
public class magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmagasin;
    private String nommagasin;
    private String adresse;
    @ManyToOne
    private ville ville;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(Integer idmagasin) {
        this.idmagasin = idmagasin;
    }

    public String getNommagasin() {
        return nommagasin;
    }

    public void setNommagasin(String nommagasin) {
        this.nommagasin = nommagasin;
    }

    public projetfinalarchitecturelogiciel.demo.entity.ville getVille() {
        return ville;
    }

    public void setVille(projetfinalarchitecturelogiciel.demo.entity.ville ville) {
        this.ville = ville;
    }
}
