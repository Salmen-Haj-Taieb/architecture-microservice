package tn.enis.membreservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.membreservice.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDiplome(String diplome);
    @Query("SELECT e FROM Etudiant e WHERE e.diplome = :diplome ORDER BY e.dateInscription DESC")
    List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(@Param("diplome") String diplome);
    List<Etudiant> findByDateInscription(Date date);
    @Query("select e from Etudiant e where e.nom like :x")
    List<Etudiant> chercherEtudiantList(@Param("x") String mc);
}