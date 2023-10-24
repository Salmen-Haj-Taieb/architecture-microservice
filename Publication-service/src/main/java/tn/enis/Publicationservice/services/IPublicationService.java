package tn.enis.Publicationservice.services;

import org.springframework.data.repository.query.Param;
import tn.enis.Publicationservice.entities.Publication;

import java.util.Date;
import java.util.List;

public interface IPublicationService {
    //Crud sur les publications
    public Publication addPublication(Publication publication);
    public void deletePublication(Long id) ;
    public Publication updatePublication(Publication publication) ;
    public Publication findPublication(Long id) ;
    public List<Publication> findAll();
    //Filtrage par propriété
    public List<Publication> findByType(String type);
    Publication findByLien(String lien);
    public List<Publication> findByTitre(String titre);
    List<Publication> findByTitreStartingWith(String caractere);
    List<Publication> findByDate(Date date);
    List<Publication> findByPublicationOrderByDateInscriptionDesc(String type);
}
