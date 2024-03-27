package cz.spsmb.view;

import cz.spsmb.dao.AnimalRepository;
import cz.spsmb.dto.AnimalDTO;
import cz.spsmb.model.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
public class AnimalView {
    @Inject
    AnimalRepository animalRepository;

    AnimalDTO newAnimal = new AnimalDTO();

    List<Animal> animalList;
    String name;
    int age;

    @PostConstruct
    public void init() {
        animalList = animalRepository.listAll();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalDTO getNewAnimal() {
        return newAnimal;
    }

    public void setNewAnimal(AnimalDTO newAnimal) {
        this.newAnimal = newAnimal;
    }

    @Transactional
    public void saveAnimal() {
        Animal animal = new Animal(newAnimal.getName(), newAnimal.getAge());
        animalRepository.persist(animal);
        animalList.add(animal);
        System.out.println("Saved " + animal);


    }
}
