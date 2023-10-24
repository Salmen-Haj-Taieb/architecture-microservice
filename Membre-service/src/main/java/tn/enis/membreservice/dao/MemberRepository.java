package tn.enis.membreservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.membreservice.entities.Membre;

import java.util.List;

public interface MemberRepository extends JpaRepository<Membre,Long>
{

    Membre findByCin(String cin);
    List<Membre> findByNomStartingWith(String caractere);
    Membre findByEmail(String email);
    List<Membre> findByNom(String nom);
}
