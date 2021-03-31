package pfe.example.demo.Entites;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Data
public class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private Date datedecreation;
    @ManyToOne
    private Utilisateur utilisateur;


}
