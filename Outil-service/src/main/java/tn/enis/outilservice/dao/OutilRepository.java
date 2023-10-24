package tn.enis.outilservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.outilservice.entities.Outil;

import java.util.Date;
import java.util.List;

public interface OutilRepository extends JpaRepository<Outil,Long> {
    List<Outil> findByDate(Date date);
    List<Outil> findBySource(String source);
}
