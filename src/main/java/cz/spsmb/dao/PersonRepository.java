package cz.spsmb.dao;

import cz.spsmb.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> listByName(String majitel){

        return find("Majitel", majitel).list();
    }

    public Person listById(Long id){
        return findById(id);
    }

}