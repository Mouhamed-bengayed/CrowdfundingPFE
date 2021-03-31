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
    private String nom;
    private String descrption;
    private Date dateDecreation;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "project")
    private Collection<Vote> votes;
    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Contribution> contribution;
    @ManyToOne
    private Porter porter;
    @JsonIgnoreProperties("comment")
    @OneToMany(mappedBy = "comment")
    private Collection<Comment> comments;

}
