package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by mleveque on 17/10/2018.
 */
public class Commercial extends Employe{
    private static final Double PRIME_MIN = 500.0;
    private static final Double POURCENTAGE_PRIME = 0.05;
    private Double caAnnuel;
    private Integer performance;

    //liste des constructeurs
    public Commercial(){

    };

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance){
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Boolean performanceEgale(Integer performance){
        if(this.performance == null)
            return false;
        else
            return this.performance.equals(performance) ? true : false;
    }

    //listes méthodes de la classe
    public Double getPrimeAnnuelle(){
        if(this.caAnnuel == null)
            return this.PRIME_MIN;
        Double prime = this.caAnnuel * this.POURCENTAGE_PRIME;
        return prime < this.PRIME_MIN ? this.PRIME_MIN : Math.ceil(prime);
    }

    public Object equivalenceNote(){
        switch(this.performance){
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return "dommage";
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        if(super.equals(o)){
            Commercial autreCom = (Commercial)o;
            return this.caAnnuel.equals(autreCom.caAnnuel);
        }else{
            return false;
        }
    }

    //listes getters et setter

    public Double getCaAnnuel() {return caAnnuel;}

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {return performance;}

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }
}