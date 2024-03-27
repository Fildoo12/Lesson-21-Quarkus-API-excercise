package cz.spsmb.rest;

import cz.spsmb.dao.AnimalRepository;
import cz.spsmb.dto.AnimalDTO;
import cz.spsmb.model.Animal;
import cz.spsmb.model.Category;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

@Path("/animals")
public class AnimalResource {

    @Inject
    AnimalRepository animalRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Animal> animals = animalRepository.listAll();
        return Response.ok().entity(animals).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Animal animal = animalRepository.findById(id);
        return Response.ok().entity(animal).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        animalRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(AnimalDTO animalDTO) {
        if (animalDTO.getName() != null && animalDTO.getAge() > 0) {
            Animal animal = new Animal();
            animal.setName(animalDTO.getName());
            animal.setAge(animalDTO.getAge());
            for (String category: animalDTO.getCategory()){
                Category cat = new Category(category);
                cat.setAnimal(animal);
                animal.getCategoryList().add(cat);
            }
            animalRepository.persist(animal);
            return Response.ok().entity("ok").build();
        } else {
            return Response.status(400).entity("Animal must have attributes \"name\" and \"age\".").build();
        }

    }

}
