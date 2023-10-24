package tn.enis.outilservice.services;

import org.springframework.data.repository.query.Param;
import tn.enis.outilservice.entities.Outil;

import java.util.Date;
import java.util.List;

public interface IOutilService {
    Outil addOutil(Outil outil);
    Outil updateOutil(Outil outil);
    void  deleteOutil(Long id);
    Outil findOutil(Long id);
    List<Outil> findAll();
    List<Outil> findByDate(Date date);
    List<Outil> findBySource(String source);
}
