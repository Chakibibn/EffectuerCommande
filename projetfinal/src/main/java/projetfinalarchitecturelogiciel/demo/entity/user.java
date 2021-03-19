package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;
    private String username;
    private String password;
    private String address;
    private String numtel;
    private String email;
    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "user")
    private Collection<commande> commandes;
    @ManyToMany
    private Set<role> roles;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private cart cart;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<commande> commandes) {
        this.commandes = commandes;
    }

    public Set<role> getRoles() {
        return roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
    }

    public projetfinalarchitecturelogiciel.demo.entity.cart getCart() {
        return cart;
    }

    public void setCart(projetfinalarchitecturelogiciel.demo.entity.cart cart) {
        this.cart = cart;
    }
}
