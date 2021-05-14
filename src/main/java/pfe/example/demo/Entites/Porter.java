package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("Porter_p")
@Data
public class Porter {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ListBlack listBlack;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "porter")
    @JsonIgnoreProperties("porter")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Project> project;
    @ManyToOne
    @JsonIgnoreProperties({"vote"})
    private Account account;

}
