package projetfinalarchitecturelogiciel.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrole;
    private String nomrole;
    @ManyToMany(mappedBy = "roles")
    private Set<user> users;

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
    }

    public String getNomrole() {
        return nomrole;
    }

    public void setNomrole(String nomrole) {
        this.nomrole = nomrole;
    }

    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
    }
}
