package tn.enis.membreservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class EnseignantChercheur extends Membre{
    @NonNull
    private String grade;
    @NonNull
    private String etablissement;
    @JsonIgnore
    @OneToMany(mappedBy = "encadrant")
    private List<Etudiant> etudiantList;
    @Builder
    public EnseignantChercheur(
                    String cin,
                    String nom,
                    String prenom,
                    Date dateNaissance,
                    String cv,
                    String email,
                    String password,
                    @NonNull String grade,
                    @NonNull String etablissement,List<Etudiant> etudiantList
                   ) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
        this.etudiantList = etudiantList;
    }
}
