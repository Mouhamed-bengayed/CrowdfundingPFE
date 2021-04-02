package pfe.example.demo.Entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public abstract class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private Collection<Account> accountRepositories;
    public Utilisateur() {
    }
}
