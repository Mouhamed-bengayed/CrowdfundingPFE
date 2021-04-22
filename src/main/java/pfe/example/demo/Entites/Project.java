package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

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
    private double prix;
    private Long likes;
    private boolean isActif;
    @ManyToOne
    private Category category;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy = "project")
    private Collection<Vote> votes;
    @OneToMany( fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Contribution> contribution;
    @ManyToOne
    private Porter porter;
    @JsonIgnoreProperties("project")
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "project")
    private Collection<Comment> comments;

}
