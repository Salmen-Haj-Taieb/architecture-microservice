package tn.enis.evenementservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.evenementservice.dao.EvenementRepository;
import tn.enis.evenementservice.entities.Evenement;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class EvenementImpl implements IEvenementService {
    EvenementRepository evenementRepository;
    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
        return evenementRepository.saveAndFlush(evenement);
    }

    @Override
    public void deleteEvenement(Long id) {
       evenementRepository.deleteById(id);
    }

    @Override
    public Evenement findEvenement(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> findByTitre(String titre) {
        return evenementRepository.findByTitre(titre);
    }

    @Override
    public List<Evenement> findByDate(Date date) {
        return evenementRepository.findByDate(date);
    }

    @Override
    public List<Evenement> findByLieu(String lieu) {
        return evenementRepository.findByLieu(lieu);
    }

    @Override
    public List<Evenement> findByTitreStartingWith(String word) {
        return evenementRepository.findByTitreStartingWith(word);
    }
}
