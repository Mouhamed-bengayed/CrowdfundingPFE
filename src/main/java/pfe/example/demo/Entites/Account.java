package pfe.example.demo.Entites;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String CPassword;
    @ManyToOne
    private Utilisateur utilisateur;
    private boolean isValid;

}
