package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pfe.example.demo.dtos.ProjectState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nomProject;
    private String description;
    private Date dateDecreation;
    private String email;
    private Long numero;
    private double prix;
    private double prixCourant;
    private ProjectState state;
    private boolean isActif;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
    @JsonIgnoreProperties("project")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy = "project")
    private Collection<Vote> votes;
    @OneToMany( fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy = "project")
    @JsonIgnoreProperties("project")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Contribution> contribution;
    @ManyToOne
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Porter porter;
    @JsonIgnoreProperties("project")
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "project")
    private Collection<Comment> comments;
  //  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "project")
    private Collection<Contributor> contributor;

}
