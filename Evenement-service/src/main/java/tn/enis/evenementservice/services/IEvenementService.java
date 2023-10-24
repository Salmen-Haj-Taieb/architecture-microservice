package tn.enis.evenementservice.services;

import tn.enis.evenementservice.entities.Evenement;

import java.util.Date;
import java.util.List;

public interface IEvenementService {
Evenement addEvenement(Evenement evenement);
Evenement updateEvenement(Evenement evenement);
void deleteEvenement(Long id);
Evenement findEvenement(Long id);
List<Evenement> findAll();
List<Evenement> findByTitre(String titre);
List<Evenement> findByDate(Date date);
List<Evenement> findByLieu(String lieu);
List<Evenement> findByTitreStartingWith(String word);
}
