package tn.enis.evenementservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.evenementservice.entities.Evenement;
import tn.enis.evenementservice.services.IEvenementService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class EvenementRestContoller {
    IEvenementService evenementService;
    @RequestMapping(value="/evenements", method= RequestMethod.GET)
    public List<Evenement> findEvenements (){
        System.out.println("*********findEvenements**********");
         return evenementService.findAll();
    }
    @GetMapping(value="/evenements/{id}")
    public Evenement findOneEvenementById(@PathVariable Long id){
        return evenementService.findEvenement(id);
    }
    @GetMapping(value="/evenements/search/titre")
    public List<Evenement> findEvenementListByTitre(@RequestParam String titre)
    {
        return evenementService.findByTitre(titre);
    }
    @GetMapping(value="/evenements/search/dateString")
    public List<Evenement> findEvenementListByDate(@RequestParam String dateString)
    {
        System.out.println("***********findEvenementListByDate***********");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
          Date  date = dateFormat.parse(dateString) ;
            System.out.println(date);
            return evenementService.findByDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping(value="/evenements/search/lieu")
    public List<Evenement> findEvenementByTitre(@RequestParam String lieu)
    {
        return evenementService.findByLieu(lieu);
    }
    @PostMapping(value="/evenements/evenement")
    public Evenement addEvenement(@RequestBody Evenement evenement)
    {
        return evenementService.addEvenement(evenement);
    }
    @DeleteMapping(value="/evenements/{id}")
    public void deleteEvenement(@PathVariable Long id)
    {
        evenementService.deleteEvenement(id);
    }
    @PutMapping(value="/evenements/evenement/{id}")
    public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement evenement)
    {
        evenement.setId(id);
        return evenementService.updateEvenement(evenement);
    }
}
