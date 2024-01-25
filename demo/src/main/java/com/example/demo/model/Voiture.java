package com.example.demo.model;

public class Voiture {
    private String marque;

    private String model;
    
    private String quantite;

    public Voiture(String nom, String prenom) {
        this.marque = marque;
        this.model = model;
        this.quantite = quantite;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }    
    
    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
