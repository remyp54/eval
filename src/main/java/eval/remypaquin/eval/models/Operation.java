package eval.remypaquin.eval.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "chantier_id")
    private Chantier chantier;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    private Utilisateur ouvrier;

    @Getter
    private int temps;
}
