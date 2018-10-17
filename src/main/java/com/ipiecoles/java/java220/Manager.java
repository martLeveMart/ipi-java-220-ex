package com.ipiecoles.java.java220;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by mleveque on 17/10/2018.
 */
public class Manager extends Employe{
    private HashSet<Technicien> equipe = new HashSet();

    public Double getPrimeAnnuelle(){
        return 5.0;
    }

    //Listes getters et setters
    public HashSet<Technicien> getEquipe() {return this.equipe;}

    public void setEquipe(HashSet equipe) {
        this.equipe = equipe;
    }
}
