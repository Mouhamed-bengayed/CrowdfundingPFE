package pfe.example.demo.Entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
public class ReplyComment implements Serializable {
    @Id
    private Long id;
    private Date datereply;
    private String reply;
    @ManyToOne
    private Porter porter;
    @ManyToOne
    private Comment comment;
    }
