package tn.enis.membreservice.beans;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class PublicationBean {
    private Long id;
    private String titre;
    private String type;
    private String lien;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String sourcePdf;
}
