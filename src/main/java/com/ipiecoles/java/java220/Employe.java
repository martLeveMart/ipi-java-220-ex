package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    //Liste des constructeur
    public Employe(){

    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    //Liste des méthodes publics de la classe
    public final Integer getNombreAnneeAnciennete(){
        Integer annee = this.dateEmbauche.getYear();
        return LocalDate.now().getYear() - annee;
    }

    public void augmenterSalaire(Double augmentation){
        Double newSalaire = this.getSalaire() + this.getSalaire() * augmentation;
        this.setSalaire(newSalaire);
    }

    public static final Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public final String toString(){
        return  "Employe{nom='" + this.nom + "', prenom='" + this.prenom + "', matricule='" + this.matricule + "', dateEmbauche=" + this.dateEmbauche + ", salaire=" + this.salaire + "}";
    }

    @Override
    public boolean equals(Object d){
        if(this == d) return true;
        if(d == null) return false;
        if(d.getClass() != this.getClass()) return false;
        Employe autreEmploye = (Employe)d;
        return this.toString().equals(autreEmploye.toString());
        /*return this.nom == autreEmploye.nom && this.prenom == autreEmploye.prenom
                && this.matricule == autreEmploye.matricule && this.salaire == autreEmploye.salaire
                && this.dateEmbauche.equals(autreEmploye.dateEmbauche);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nom,this.prenom,this.matricule,this.dateEmbauche,this.salaire);
    }

    //Liste des getters et setters de la classe Employé
    public String getNom() {return nom;}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {return matricule;}

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {return dateEmbauche;}

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception{
        if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {return salaire;}

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
}
