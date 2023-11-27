package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vote {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long valeur;
   @OneToOne
    Project project;
    @ManyToOne
   Account account;



}
