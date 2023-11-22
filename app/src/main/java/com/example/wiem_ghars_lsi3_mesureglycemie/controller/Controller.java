package com.example.wiem_ghars_lsi3_mesureglycemie.controller;

import com.example.wiem_ghars_lsi3_mesureglycemie.model.Patient;
//Class doit etre final (pattern singleton)
public final class Controller {
    //attribut privé et statique qui mémorise l’instance unique
    private static Controller instance = null;
    private static Patient patient;
    //public Controller(){super();}
    private Controller(){super();}
    public void createPatient(int age,float valeur,boolean fasting)
    {patient = new Patient(age,valeur,fasting); }

    //update Contoller -->view
    public String getResult()
    {return patient.getResult(); //update Patient --> contoller
         }
    // methode remplace le rôle du constructeur ailleurs de la classe Controlleret retourne une instance unique
    public static Controller getInstance() {
        if(instance==null)
            instance = new Controller();
         return instance;
    }
}

