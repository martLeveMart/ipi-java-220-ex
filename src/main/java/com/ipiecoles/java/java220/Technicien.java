package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by mleveque on 17/10/2018.
 */
public class Technicien extends Employe {
    private Integer grade;
    private static final Double BONUS_ANCIENNETE = 100.0;

    //listes constructeurs de la classes
    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    //listes méthodes de la classe
    public Double getPrimeAnnuelle() {
        Double primeBase = Entreprise.getPrimeAnnuelleBase();
        Double prime = primeBase + primeBase + this.getNombreAnneeAnciennete() * this.BONUS_ANCIENNETE;
        prime += primeBase * (this.grade / 10.0);
        return prime;
    }

    public Integer getNbConges(){
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    //Listes getters et setters
    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if (grade > 5 || grade < 1)
            throw new TechnicienException("Le grade doit être compris entre 1 et 5 : " + grade + ", technicien : Technicien{grade=" + this.grade + "} " + this.toString());
        this.grade = grade;
    }

    public void setSalaire(Double salaire){
        if(this.grade == null)
            super.setSalaire(salaire);
        Double taux = this.grade / 10.0;
        super.setSalaire(salaire * (1 + taux));
    }
}
