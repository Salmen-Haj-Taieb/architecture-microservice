package tn.enis.membreservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.membreservice.entities.Membre;
import tn.enis.membreservice.entities.Membre_Pub_Id;
import tn.enis.membreservice.entities.Membre_Publication;

import java.util.List;

public interface MembrePubRepository extends
        JpaRepository<Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Membre auteur);
}
