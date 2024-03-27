package cz.spsmb.dao;


import cz.spsmb.model.Animal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<Animal> {

    public List<Animal> listByName(String name) {


        return find("name", name).list();
    }

    public Animal listById(Long id){
        return findById(id);
    }

}