package tn.enis.outilservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.outilservice.dao.OutilRepository;
import tn.enis.outilservice.entities.Outil;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class OutilImpl implements IOutilService {
    OutilRepository outilRepository;
    @Override
    public Outil addOutil(Outil outil) {
        return outilRepository.save(outil);
    }

    @Override
    public Outil updateOutil(Outil outil) {
        return outilRepository.saveAndFlush(outil);
    }

    @Override
    public void deleteOutil(Long id) {
         outilRepository.deleteById(id);
    }

    @Override
    public Outil findOutil(Long id) {
        return outilRepository.findById(id).get();
    }

    @Override
    public List<Outil> findAll() {
        return outilRepository.findAll();
    }

    @Override
    public List<Outil> findByDate(Date date) {
        return outilRepository.findByDate(date);
    }

    @Override
    public List<Outil> findBySource(String source) {
        return outilRepository.findBySource(source);
    }

}
