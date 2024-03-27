package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "test-person-table")
public class Person implements Serializable {

    @Id
    @Column(name = "person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String majitel;
    int age;


    public Person(){};

    public Person(String majitel, int age) {
        this.majitel = majitel;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMajitel() {
        return majitel;
    }

    public void setMajitel(String majitel) {
        this.majitel = majitel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "majitel='" + majitel + '\'' +
                ", age=" + age +
                ", animal=" + animal +
                '}';
    }

    @OneToOne(fetch = FetchType.LAZY)
    Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
