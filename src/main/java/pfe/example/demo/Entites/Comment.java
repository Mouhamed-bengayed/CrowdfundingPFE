package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateComment;
    private String comment;
    @ManyToOne
    private Contributor contributor;
    @ManyToOne
    private Project project;
    @OneToMany(mappedBy = "comment")
    @JsonIgnoreProperties("comment")
    private Collection<ReplyComment> replyComments;

}
