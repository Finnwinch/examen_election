package com.cirpaci.leo.examen_election.examen_election.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,length = 120)
    private String nom;
    @Column(length = 80)
    private String parti;
    @Column()
    private int votes;
    @ManyToOne
    @JoinColumn(name="district_id", nullable=false)
    private District district;

    public Candidat() {
    }

    public Candidat(int id) {
        this.id = id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    public String getParti() {
        return parti;
    }

    public void setParti(String parti) {
        this.parti = parti;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", parti='" + parti + '\'' +
                ", votes=" + votes +
                ", district=" + district +
                '}';
    }
}
