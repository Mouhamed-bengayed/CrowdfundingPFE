package pfe.example.demo.Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@DiscriminatorValue("moderator")
@Data
public class Moderator extends Utilisateur {

}
