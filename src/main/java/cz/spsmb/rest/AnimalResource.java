package cz.spsmb.rest;

import cz.spsmb.dao.AnimalRepository;
import cz.spsmb.dto.AnimalDTO;
import cz.spsmb.dto.PersonDTO;
import cz.spsmb.model.Animal;
import cz.spsmb.model.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(AnimalDTO animalDTO){
        if (validateInput(animalDTO)){
            Animal animal = new Animal();
            animal.setName(animalDTO.setName());
            animal.setBreed(animalDTO.getBreed());
            animal.setKind(animalDTO.getKind());
            animal.setBornDate(animalDTO.getBornDate());

            animalRepository.persist(animal);
            return Response.ok().entity("ok").build();
        }
        return Response.status(400).entity("Invalid input").build();
    }
    private boolean validateInput(AnimalDTO animalDTO){
        return !(animalDTO.getName().isEmpty());
    }


}
