package com.cirpaci.leo.examen_election.examen_election.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,length = 255)
    private String nom;
    @Column(nullable = false)
    private int electeurs;

    public District() {
    }

    public District(int id) {
        this.id = id;
    }

    public District(String nom) {
        this.nom = nom;
    }

    public District(String nom, int electeurs) {
        this.nom = nom;
        this.electeurs = electeurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(int electeurs) {
        this.electeurs = electeurs;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
