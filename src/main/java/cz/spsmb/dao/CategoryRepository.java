package cz.spsmb.dao;

import cz.spsmb.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.Optional;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    public Optional<Category> listByname(String name){
        return find("name", name).singleResultOptional();
    }
}