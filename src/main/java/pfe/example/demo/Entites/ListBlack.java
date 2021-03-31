package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Data
public class ListBlack {
    @Id
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "listBlack")
    @JsonIgnoreProperties("listBlack")
    private Collection<Porter> porter;
    @OneToMany(mappedBy = "listBlack")
    @JsonIgnoreProperties("listBlack")
    private Collection<Contributor> contributors;


}
