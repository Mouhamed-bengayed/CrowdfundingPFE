package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue("contributor")
@Data
public class Contributor extends Utilisateur {


    @ManyToOne
    private ListBlack listBlack;
    @OneToMany(mappedBy = "contributor")
    @JsonIgnoreProperties("contributor")
    private Collection<Contribution> contributions;
    @OneToMany(mappedBy = "contributor")
    @JsonIgnoreProperties("contributor")
    private Collection<Vote> votes;
    @OneToMany(mappedBy = "contributor")
    @JsonIgnoreProperties("contributor")
    private Collection<Comment> comments;



}
