package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String commenter;
    @ManyToOne
    private Contributor contributor;
    @ManyToOne
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Project project;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "comment")
    @JsonIgnoreProperties("comment")
    private Collection<ReplyComment> replyComments;

}
