package tn.enis.membreservice.services;

import org.springframework.data.repository.query.Param;
import tn.enis.membreservice.beans.PublicationBean;
import tn.enis.membreservice.entities.EnseignantChercheur;
import tn.enis.membreservice.entities.Etudiant;
import tn.enis.membreservice.entities.Membre;

import java.util.Date;
import java.util.List;

  public interface IMemberService {
         Membre addMember(Membre m);
         void deleteMember(Long id) ;
         Membre updateMember(Membre p) ;
         Membre findMember(Long id) ;
         List<Membre> findAll();
         Membre findByCin(String cin);
         Membre findByEmail(String email);
         List<Membre> findByNom(String nom);
         List<Membre> findByNomStartingWith(String caractere);
         List<Etudiant> findByDiplome(String diplome);
         List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
         List<Etudiant> findByDateInscription(Date date);
         List<EnseignantChercheur> findByGrade(String grade);
         List<EnseignantChercheur> findByEtablissement(String etablissement);
         void affecterEudiantToEnseignant(Long idEtd,Long idEns);
         List<Etudiant> findEtudiantListByEncadrant(EnseignantChercheur ens);
         List<Etudiant> chercherEtudiantList(@Param("x") String mc);
         public void affecterauteurTopublication(Long idauteur, Long idpub);
         public List<PublicationBean> findPublicationparauteur (Long idauteur);
}
