package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="cart")
public class cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private Date dateCreated;
    private Date lastUpdated;
    @OneToOne
    private user user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<lignecommande> cartDetails = new ArrayList<>();

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public List<lignecommande> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<lignecommande> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public void addCartDetail(lignecommande cartDetail){
        cartDetails.add(cartDetail);
//            cartDetail.setCart(this);
    }

    public void removeCartDetail(lignecommande cartDetail){
        this.cartDetails.remove(cartDetail);
//            cartDetail.setCart(null);
    }
}
