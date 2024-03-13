package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "test-animal-table")
public class Animal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String Kind;
    String Breed;
    int BornDate;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    Person person;

    public Animal(){};

    public Animal(long id, String name, String kind, String breed, Integer bornDate) {
        this.id = id;
        this.name = name;
        this.Kind = kind;
        this.Breed = breed;
        this.BornDate = bornDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        this.Kind = kind;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        this.Breed = breed;
    }

    public int getBornDate() {
        return BornDate;
    }

    public void setBornDate(int bornDate) {
        this.BornDate = bornDate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Kind='" + Kind + '\'' +
                ", Breed='" + Breed + '\'' +
                ", BornDate=" + BornDate +
                '}';
    }
}
