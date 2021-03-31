package pfe.example.demo.Entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Vote {
    @Id
    private Long id;
    private String valeur;
    @ManyToOne
    Project project;
    @ManyToOne
    Contributor contributor;

}
