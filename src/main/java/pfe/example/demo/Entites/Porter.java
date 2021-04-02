package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Porter_p")
@Data
public class Porter extends Utilisateur {
    @ManyToOne
    private ListBlack listBlack;
    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL,mappedBy = "porter")
    @JsonIgnoreProperties("porter")
    private List<Project> project;
}
