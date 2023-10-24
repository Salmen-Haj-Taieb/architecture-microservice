package tn.enis.evenementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.evenementservice.entities.Evenement;

import java.util.Date;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
    List<Evenement> findByTitre(String titre);
    List<Evenement> findByTitreStartingWith(String word);
    List<Evenement> findByDate(Date date);
    List<Evenement> findByLieu(String lieu);
}
