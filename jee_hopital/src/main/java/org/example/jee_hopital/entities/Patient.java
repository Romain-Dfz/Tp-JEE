package org.example.jee_hopital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public Patient() {

    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public Patient(String marque, String reference, Date dateAchat, double prix, int stock) {

        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    public Patient(String marque, String reference, Date dateAchat, double prix, int stock, byte[] image) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return nom;
    }

    public void setMarque(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
