package com.ipiecoles.java.java220;

import java.util.HashSet;

/**
 * Created by mleveque on 17/10/2018.
 */
public class Unite {
    private Object responsable;
    private HashSet membres;

    public Unite(){}

    public Unite(Object membre){
        this.responsable = membre;
        //this.membres.push(membre);
    }

    public Object getResponsable() {return responsable;}
    public void setResponsable(Object responsable) {this.responsable = responsable;}
    public HashSet getMembres() {return membres;}
    public void setMembres(HashSet membres) {this.membres = membres;}
}
