package tn.enis.membreservice.services;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.enis.membreservice.beans.PublicationBean;
import tn.enis.membreservice.dao.EnseignantChercheurRepository;
import tn.enis.membreservice.dao.EtudiantRepository;
import tn.enis.membreservice.dao.MemberRepository;
import tn.enis.membreservice.dao.MembrePubRepository;
import tn.enis.membreservice.entities.*;
import tn.enis.membreservice.proxies.PublicationProxyService;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService {
    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;
    MembrePubRepository membrePubRepository;
    PublicationProxyService publicationProxyService;
    public Membre addMember(Membre m) {
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Membre updateMember(Membre m) {
        return memberRepository.saveAndFlush(m);
    }

    public Membre findMember(Long id) {
        return memberRepository.findById(id).get();

    }
    public List<Membre> findAll() {
        return memberRepository.findAll();}
    public Membre findByCin(String cin) {
        return memberRepository.findByCin(cin);}
    public Membre findByEmail(String email) {
        return memberRepository.findByEmail(email);}
    public List<Membre> findByNom(String nom) {
        return  memberRepository.findByNom(nom);
    }
    public List<Membre> findByNomStartingWith(String caractere){
        return  memberRepository.findByNomStartingWith(caractere);
    }
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }
    public List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome){
        return etudiantRepository.findByDiplomeOrderByDateInscriptionDesc(diplome);
    }
    public List<Etudiant> findByDateInscription(Date date){
        return etudiantRepository.findByDateInscription(date);
    }
    public List<Etudiant> chercherEtudiantList(String mc){
        return etudiantRepository.chercherEtudiantList(mc);
    }
    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }
    public void affecterEudiantToEnseignant(Long idEtd,Long idEns){
        Etudiant etd =(Etudiant) memberRepository.findById(idEtd).get();
        EnseignantChercheur ens = (EnseignantChercheur) memberRepository.findById(idEns).get();
        etd.setEncadrant(ens);
    }

    @Override
    public List<Etudiant> findEtudiantListByEncadrant(EnseignantChercheur ens) {
        return ens.getEtudiantList();
    }

    public void affecterauteurTopublication(Long idauteur, Long idpub)
    {
        Membre mbr= memberRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrePubRepository.save(mbs);
    }

    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<>();
        Membre auteur= memberRepository.findById(idauteur).get();
        List< Membre_Publication>
                idpubs=membrePubRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(publicationProxyService.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }

}