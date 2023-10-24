package tn.enis.outilservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.outilservice.entities.Outil;
import tn.enis.outilservice.services.IOutilService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class OutilRestController {
    IOutilService outilService;
    @RequestMapping(value="/outils", method= RequestMethod.GET)
    public List<Outil> findOutils (){
        return outilService.findAll();
    }
    @GetMapping(value="/outils/{id}")
    public Outil findOneOutilById(@PathVariable Long id){
        return outilService.findOutil(id);
    }
    @GetMapping(value="/outils/search/dateString")
    public List<Outil> findOutilListByDate(@RequestParam String dateString)
    {   String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateString);
            return outilService.findByDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping(value="/outils/search/source")
    public List<Outil> findOutilListBySource(@RequestParam String source)
    {
        return outilService.findBySource(source);
    }
    @PostMapping(value="/outils/outil")
    public Outil addOutil(@RequestBody Outil outil)
    {
        return outilService.addOutil(outil);
    }
    @DeleteMapping(value="/outils/{id}")
    public void deleteOutil(@PathVariable Long id)
    {
        outilService.deleteOutil(id);
    }
    @PutMapping(value="/outils/outil/{id}")
    public Outil updateOutil(@PathVariable Long id, @RequestBody Outil outil)
    {
        outil.setId(id);
        return outilService.updateOutil(outil);
    }
}
