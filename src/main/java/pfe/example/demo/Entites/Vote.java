package pfe.example.demo.Entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vote {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long valeur;
    @ManyToOne
    Project project;
    @ManyToOne
   Account account;



}
