package pfe.example.demo.Entites;


import lombok.Data;

import javax.persistence.*;


@Entity
@DiscriminatorValue("moderator")
@Data
public class Moderator extends Utilisateur {

}
