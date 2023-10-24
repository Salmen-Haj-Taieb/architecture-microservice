package tn.enis.membreservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.membreservice.entities.EnseignantChercheur;
import tn.enis.membreservice.entities.Etudiant;
import tn.enis.membreservice.entities.Membre;
import tn.enis.membreservice.services.IMemberService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
public class MemberRestController {
    IMemberService memberService;

    @RequestMapping(value = "/membres", method = RequestMethod.GET)
    public List<Membre> findMembres() {
        return memberService.findAll();
    }

    @GetMapping(value = "/membres/{id}")
    public Membre findOneMemberById(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    @GetMapping(value = "/membres/search/cin")
    public Membre findOneMemberByCin(@RequestParam String cin) {
        return memberService.findByCin(cin);
    }

    @GetMapping(value = "/membres/search/email")
    public Membre findOneMemberByEmail(@RequestParam String email) {
        return memberService.findByEmail(email);
    }

    @GetMapping(value = "/membres/search/nom")
    public List<Membre> findMemberByNom(@RequestParam String nom) {
        return memberService.findByNom(nom);
    }

    @GetMapping(value = "/membres/search/nomStartingWith")
    public List<Membre> findMembreListByNomStartingWith(@RequestParam String nomStartingWith) {
        return memberService.findByNomStartingWith(nomStartingWith);
    }

    @GetMapping(value = "/membres/etudiants/search/nom")
    public List<Etudiant> findEtudiantListByNom(@RequestParam String nom) {
        return memberService.chercherEtudiantList(nom);
    }

    @GetMapping(value = "/membres/etudiants/search/inscriptionDate")
    public List<Etudiant> findEtudiantListByDateInscription(@RequestParam String inscriptionDate) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(inscriptionDate);
        return memberService.findByDateInscription(date);
    }

    @GetMapping(value = "/membres/enseignants/search/grade")
    public List<EnseignantChercheur> findEnseignantListByGrade(@RequestParam String grade) {
        return memberService.findByGrade(grade);
    }

    @GetMapping(value = "/membres/enseignants/search/etablissement")
    public List<EnseignantChercheur> findEnseignantListByEtablissement(@RequestParam String etablissement) {
        return memberService.findByEtablissement(etablissement);
    }

    @GetMapping(value = "/membres/etudiants/search/diplome")
    public List<Etudiant> findEtudiantListByDiplome(@RequestParam String diplome) {
        return memberService.findByDiplome(diplome);
    }

    @GetMapping(value = "/membres/etudiants/search/diplomeOrderInscDateDesc")
    public List<Etudiant> findEtudiantListByDiplomeOrderByDateInscriptionDescByDiplome(@RequestParam String diplomeOrderInscDateDesc) {
        return memberService.findByDiplomeOrderByDateInscriptionDesc(diplomeOrderInscDateDesc);
    }

    @GetMapping(value = "/membres/etudiants/search/enseignantChercheur")
    public List<Etudiant> findEtudiantListByEncadrant(@RequestBody EnseignantChercheur enseignantChercheur) {
        return memberService.findEtudiantListByEncadrant(enseignantChercheur);
    }

    @PostMapping(value = "/membres/enseignants/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur enseignantChercheur) {
        return memberService.addMember(enseignantChercheur);
    }

    @PostMapping(value = "/membres/etudiants/etudiant")
    public Membre addMembre(@RequestBody Etudiant etudiant) {
        return memberService.addMember(etudiant);
    }

    @DeleteMapping(value = "/membres/{id}")
    public void deleteMembre(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PutMapping(value = "/membres/etudiants/etudiant/{id}")
    public Membre updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return memberService.updateMember(etudiant);
    }

    @PutMapping(value = "/membres/enseignants/enseignant/{id}")
    public Membre updateEnseignant(@PathVariable Long id, @RequestBody EnseignantChercheur enseignantChercheur) {
        enseignantChercheur.setId(id);
        return memberService.updateMember(enseignantChercheur);
    }

    @PutMapping(value = "/membres/etudiants/etudiant/{etudiantId}/enseignant/{enseignantId}")
    public void affectEudiantToEnseignant(@PathVariable Long etudiantId, @PathVariable Long enseignantId) {
        memberService.affecterEudiantToEnseignant(etudiantId, enseignantId);
    }
}
