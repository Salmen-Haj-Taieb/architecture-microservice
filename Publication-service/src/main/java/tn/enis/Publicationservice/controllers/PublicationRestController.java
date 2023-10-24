package tn.enis.Publicationservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.Publicationservice.entities.Publication;
import tn.enis.Publicationservice.services.IPublicationService;


import java.util.List;


@RestController
@AllArgsConstructor
public class PublicationRestController {
    IPublicationService publicationService;
    @RequestMapping(value="/publications", method= RequestMethod.GET)
    public  List<Publication> findPublication(){
        return publicationService.findAll();
    }
    @GetMapping(value ="/publications/{id}")
    public Publication findOnePublicationById(@PathVariable Long id){
        return publicationService.findPublication(id);
    }
    @GetMapping(value = "/publications/search/lien")
    public Publication findOnePublicationByLien(@RequestParam String lien){
        return publicationService.findByLien(lien);
    }
    @GetMapping(value = "/publications/search/type")
    public List<Publication> findPublicationListByType(@RequestParam String type){
        return publicationService.findByType(type);
    }
    @GetMapping(value = "/publications/search/titre")
    public List<Publication> findPublicationListByTitre(@RequestParam String titre){
        return publicationService.findByTitre(titre);
    }
    @PostMapping(value = "/publications/publication")
    public Publication addPublication(@RequestBody Publication publication){
        return publicationService.addPublication(publication);
    }
    @DeleteMapping(value = "/publications/{id}")
    public void deletePublication(@PathVariable Long id){
        publicationService.deletePublication(id);
    }
    @PutMapping(value = "/publications/publication/{id}")
    public Publication updatePublication(@PathVariable Long id, @RequestBody Publication publication){
        publication.setId(id);
        return publicationService.updatePublication(publication);
    }
}
