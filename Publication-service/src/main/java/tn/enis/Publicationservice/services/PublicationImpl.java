package tn.enis.Publicationservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.Publicationservice.dao.PublicationRepository;
import tn.enis.Publicationservice.entities.Publication;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class PublicationImpl implements IPublicationService {
    PublicationRepository publicationRepository;
    @Override
    public Publication addPublication(Publication publication) {
        publicationRepository.save(publication);
        return publication;
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public Publication updatePublication(Publication publication) {
        return publicationRepository.saveAndFlush(publication);
    }

    @Override
    public Publication findPublication(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> findByType(String type) {
        return publicationRepository.findByType(type);
    }

    @Override
    public Publication findByLien(String lien) {
        return publicationRepository.findByLien(lien);
    }

    @Override
    public List<Publication> findByTitre(String titre) {
        return publicationRepository.findByTitre(titre);
    }

    @Override
    public List<Publication> findByTitreStartingWith(String caractere) {
        return publicationRepository.findByTitreStartingWith(caractere);
    }

    @Override
    public List<Publication> findByDate(Date date) {
        return publicationRepository.findByDate(date);
    }

    @Override
    public List<Publication> findByPublicationOrderByDateInscriptionDesc(String type) {
        return publicationRepository.findByPublicationOrderByDateInscriptionDesc(type);
    }
}
