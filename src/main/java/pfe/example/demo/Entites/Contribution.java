package pfe.example.demo.Entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Contribution {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double montantDeInvestissement;
    private Date dateDeContribution;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Contributor contributor;
}
