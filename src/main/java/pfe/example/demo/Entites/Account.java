package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pfe.example.demo.dtos.UserType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Number number;
    private String address;
    private String bio;
    private String city;
    private UserType type;
    private boolean isValid;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "account")
    @JsonIgnoreProperties("account")
    private List<Vote> vote;


}
