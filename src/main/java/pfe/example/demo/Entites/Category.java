package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("category")
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL ,mappedBy = "category")
    @JsonIgnoreProperties("category")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Project> project;

}
