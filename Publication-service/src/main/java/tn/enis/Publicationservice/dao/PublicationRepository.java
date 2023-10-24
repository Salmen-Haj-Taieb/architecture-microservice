package tn.enis.Publicationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.Publicationservice.entities.Publication;

import java.util.Date;
import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication,Long>{
    List<Publication> findByTitre(String titre);
    List<Publication> findByTitreStartingWith(String caractere);
    Publication findByLien(String lien);
    List<Publication> findByType(String type);
    List<Publication> findByDate(Date date);
    @Query("SELECT p FROM Publication p WHERE p.type = :type ORDER BY p.date DESC")
    List<Publication> findByPublicationOrderByDateInscriptionDesc(@Param("type") String type);
}
