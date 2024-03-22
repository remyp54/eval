package eval.remypaquin.eval.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    private Utilisateur ouvrier;

    @OneToMany(mappedBy = "chantier")
    private List<Operation> operations;
}
