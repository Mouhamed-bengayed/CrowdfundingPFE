package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class ListBlack {
    @Id
    private Long id;
    private String nom;

    @OneToMany(fetch = FetchType.LAZY , cascade= CascadeType.ALL,mappedBy = "listBlack")
    @JsonIgnoreProperties("listBlack")
    private Collection<Porter> porter;
    @ManyToOne
    private Contributor contributor;


}
