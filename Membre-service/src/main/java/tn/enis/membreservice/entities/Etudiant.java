package tn.enis.membreservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Etudiant extends Membre{
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @NonNull
    private String diplome;
    private String sujet;
    @ManyToOne
    @JoinColumn(name = "enseignant_chercheur_id")
    private EnseignantChercheur encadrant;
    @Builder
    public Etudiant(String cin,
                    String nom,
                    String prenom,
                    Date dateNaissance,
                    String cv,
                    String email,
                    String password,
                    @NonNull Date dateInscription,
                    @NonNull String diplome,
                    String sujet) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.diplome = diplome;
        this.sujet = sujet;
    }
}
